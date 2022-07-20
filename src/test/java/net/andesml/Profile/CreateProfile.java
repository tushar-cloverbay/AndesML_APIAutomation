package net.andesml.Profile;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.andesml.base.Base;
import net.andesml.base.Constants;
import net.andesml.utils.JsonUtils;
import net.andesml.utils.TestUtils;

public class CreateProfile extends Base {
	

	@Test(dataProvider = "version-data-provider",priority = -1,enabled = true)
	public void CreatProfile_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling CreatProfile api.");
		String URI = Constants.profile_domain+"/profiles/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\Profile\\CreateProfile.json");
		
		String vanity_name = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "vanity_name", vanity_name);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.profileUser, Constants.profilePassword))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id);

		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		profile_id = JsonUtils.getKeyValue(response, "profile_id");
		vanity_name_base = JsonUtils.getKeyValue(response, "vanity_name");
		response.then().assertThat().statusCode(equalTo(200));
		System.out.println("profile_id-----------"+profile_id);
	}
	@Test(dataProvider = "version-data-provider",priority = -1,enabled = true)
	public void CreatProfile_VerifyResponseParameter(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify response parameters after calling CreatProfile api.");
		String URI = Constants.profile_domain+"/profiles/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\Profile\\CreateProfile.json");
		
		String vanity_name = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "vanity_name", vanity_name);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.profileUser, Constants.profilePassword))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id);

		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		profile_id = JsonUtils.getKeyValue(response, "profile_id");
		response.then().assertThat()
		.body("profile_id", notNullValue())
		.body("vanity_name", notNullValue())
		.body("profile_type", notNullValue())
		.body("profile_sub_type", notNullValue())
		.body("org_info", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",priority = -1,enabled = true)
	public void CreatProfile_Without_client_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling CreatProfile api without client_id header.");
		String URI = Constants.profile_domain+"/profiles/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\Profile\\CreateProfile.json");
		
		String vanity_name = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "vanity_name", vanity_name);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.profileUser, Constants.profilePassword))
				.body(resultBody);
		request.header("Content-Type", "application/json");

		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		profile_id = JsonUtils.getKeyValue(response, "profile_id");
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].errorCode", is("PROFILES_VALIDATION_ERROR"))
		.body("errors[0].message", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",priority = -1,enabled = true)
	public void CreatProfile_existing_vanity_name(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling CreatProfile api with existing vanity_name.");
		String URI = Constants.profile_domain+"/profiles/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\Profile\\CreateProfile.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "vanity_name", vanity_name_base);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.profileUser, Constants.profilePassword))
				.body(resultBody);
		request.header("Content-Type", "application/json");

		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		profile_id = JsonUtils.getKeyValue(response, "profile_id");
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].errorCode", is("PROFILES_VALIDATION_ERROR"))
		.body("errors[0].message", is("Vanity name already taken"));
	}
}
