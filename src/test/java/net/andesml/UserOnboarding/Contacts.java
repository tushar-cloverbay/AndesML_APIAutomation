package net.andesml.UserOnboarding;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.andesml.base.Base;
import net.andesml.base.Constants;
import net.andesml.utils.JsonUtils;

public class Contacts extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getAllContacts_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String URI ="https://"+Constants.ENV+"/andes-ml/contacts";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		Response response = request.get(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getByContactId_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String contactID = "";
		String URI ="https://"+Constants.ENV+"/andes-ml/contacts/v1/"+contactID;
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		Response response = request.get(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getByProfileId_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String profileID = "";
		String URI ="https://"+Constants.ENV+"/andes-ml/contacts/v1/"+profileID;
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		Response response = request.get(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void createContact_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String URI ="https://"+Constants.ENV+"/andes-ml/contacts/v1";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		Response response = request.post(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void updateContact_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String contactID = "";
		String URI ="https://"+Constants.ENV+"/andes-ml/contacts/v1/"+contactID;
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		Response response = request.put(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void deleteContact_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String contactID = "";
		String URI ="https://"+Constants.ENV+"/andes-ml/contacts/v1/"+contactID;
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		Response response = request.delete(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
}
