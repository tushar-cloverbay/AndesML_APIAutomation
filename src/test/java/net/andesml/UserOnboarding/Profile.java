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

public class Profile extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void CreatProfile_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String URI ="https://"+Constants.ENV+"/andes-ml/profiles/v1/";
		
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
	public void getProfile_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String profileID = "";
		String URI ="https://"+Constants.ENV+"/andes-ml/profiles/v1/"+profileID;
		
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
	public void updateProfile_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String profileID = "";
		String URI ="https://"+Constants.ENV+"/andes-ml/profiles/"+profileID;
		
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
	public void attachments_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String profileID = "";
		String URI ="https://"+Constants.ENV+"/andes-ml/v1/profiles/"+profileID+"/verification-doc";
		
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		request.queryParam("operation", "ADD");
		Response response = request.patch(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void changeStatus_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String profileID = "";
		String URI ="https://"+Constants.ENV+"/andes-ml/v1/profiles/"+profileID+"/status/OPEN";
		
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		Response response = request.patch(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void checkVanityAvailability_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String URI ="https://"+Constants.ENV+"/andes-ml/v1/availability/vn_myvanity";
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
	public void search_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String URI ="https://"+Constants.ENV+"/andes-ml/v1/search";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		request.queryParam("vanity_name", "");
		Response response = request.get(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
}
