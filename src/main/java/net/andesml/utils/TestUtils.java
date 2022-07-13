package net.andesml.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.json.JSONObject;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.andesml.base.Base;
import net.andesml.base.Constants;

public class TestUtils extends Base {
	
	public static String getResposeString(Response response) {
		log.info("Converting Response to String");
		String strResponse = response.getBody().asString();
		log.debug(strResponse);
		return strResponse;
	}

	public static JsonPath jsonParser(String response) {
		log.info("Parsing String Response to JSON");
		JsonPath jsonResponse = new JsonPath(response);
		log.debug(jsonResponse);
		return jsonResponse;
	}

	public static XmlPath xmlParser(String response) {
		log.info("Parsing String Response to XML");
		XmlPath xmlResponse = new XmlPath(response);
		log.debug(xmlResponse);
		return xmlResponse;
	}

	public static int getStatusCode(Response response) {
		log.info("Getting Response Code");
		int statusCode = response.getStatusCode();
		log.info(statusCode);
		return statusCode;
	}

	public static String getStatusMessage(Response response) {
		log.info("Getting Response Message");
		String responseMessage = response.getStatusLine();
		log.info(responseMessage);
		return responseMessage;
	}


	public static void sendEmail(String email) {

		String to = email;
		String from = "tushar.behera@cloverbaytechnologies.com";

		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("tushar.behera@cloverbaytechnologies.com", "tolffzlmvtiwivzw");
			}

		});
		// session.setDebug(true);
		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("API Automation report for " + Constants.ENV);
			Multipart multipart = new MimeMultipart();
			MimeBodyPart attachmentPart = new MimeBodyPart();
			MimeBodyPart textPart = new MimeBodyPart();
			try {
				File f = new File(".\\ExtentReport.html");
				attachmentPart.attachFile(f);
				textPart.setText("Please find the attachment for html report.");
				multipart.addBodyPart(textPart);
				multipart.addBodyPart(attachmentPart);
			} catch (IOException e) {
				e.printStackTrace();
			}
			message.setContent(multipart);
			System.out.println("sending...");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public static String getTime() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String time = timestamp.getTime() + "";
		return time;
	}

	public static void verifyResponseTime(Response response, long maxTime) {
		if (response.getTime() >= maxTime) {
			log.info("Response time is greater then expected");
			Assert.assertTrue(false);
		}
	}

	public static void verifyStatusCode(Response response, int status) {
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}

	public static void verifyStatusMessage(Response response, String status) {
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}
	
	public static String updateJsonKey(String payload,String key,String value) throws Exception {
		JSONObject jsonObj = new JSONObject(payload);
		JSONObject resultJson = JsonUtils.updateJson(jsonObj, key, value);
		System.out.println(resultJson.toString());
		return resultJson.toString();
	}
	public static void addProduct() throws Exception {
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaign.json");
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(payload.toString());
		request.header("Content-Type", "application/json")
			.header("client_id", Constants.client_id)
			.header("trace_id", Constants.trace_id)
			.header("tenant_id", Constants.tenant_id)
			.header("advertiser_id", Constants.advertiser_id)
			.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 207");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
	}
	public static String getAccessToken(String userName, String password) throws Exception {
		Response response = RestAssured.given().auth().preemptive().basic(Constants.client_id, Constants.client_secret)
				.formParam("grant_type", "password")
				.formParam("username", Constants.user)
				.formParam("password", Constants.password)
				.when().post(Constants.access_token_url);
		System.out.println("*******************************************************************************");
		System.out.println(response.asPrettyString());
		String token = JsonUtils.getKeyValue(response, "access_token");
		return token;
	}
	public static String getAccessTokenClientCreds(String client_id, String client_secret) throws Exception {
		Response response = RestAssured.given().auth().preemptive().basic(client_id, client_secret)
				.formParam("grant_type", "client_credentials")
				.when().post(Constants.access_token_url_client_cred);
		System.out.println("*******************************************************************************");
		System.out.println(response.asPrettyString());
		String token = JsonUtils.getKeyValue(response, "access_token");
		System.out.println(token);
		return token;
	}
}
