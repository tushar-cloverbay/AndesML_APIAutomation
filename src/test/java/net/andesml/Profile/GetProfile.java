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

public class GetProfile extends Base {
	

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetProfile_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling GetProfile api.");
		String URI = Constants.profile_domain+"/profiles/v1/"+profile_id;
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.profileUser, Constants.profilePassword));
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("tenant_id", profile_id);

		Response response = request.get(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(200));
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetProfile_VerifyResponseParameters(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify response parameers after calling GetProfile api.");
		String URI = Constants.profile_domain+"/profiles/v1/"+profile_id;
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.profileUser, Constants.profilePassword));
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("tenant_id", profile_id);

		Response response = request.get(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.body("profile_id", notNullValue())
		.body("vanity_name", notNullValue())
		.body("profile_type", notNullValue())
		.body("profile_sub_type", notNullValue())
		.body("org_info", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetProfile_without_client_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling CreatProfile api without client_id header.");
		String URI = Constants.profile_domain+"/profiles/v1/"+profile_id;
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.profileUser, Constants.profilePassword));
		request.header("Content-Type", "application/json")
				.header("tenant_id", profile_id);

		Response response = request.get(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400));
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetProfile_without_tenant_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling CreatProfile api without tenant_id header.");
		String URI = Constants.profile_domain+"/profiles/v1/"+profile_id;
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.profileUser, Constants.profilePassword));
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id);

		Response response = request.get(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400));
	}
}
