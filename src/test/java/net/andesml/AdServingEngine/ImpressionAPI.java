package net.andesml.AdServingEngine;

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

public class ImpressionAPI extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ImpressionsAPI_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling ImpressionsAPI api.");
		String URI = Constants.ADSE_domain+"/andes-ml/v1/ad/impression";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\ADSE\\impressionAPI.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessTokenClientCreds(Constants.client_id_client_cred,Constants.client_secret_client_cred))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id_client_cred)
				.header("trace_id", Constants.trace_id_client_cred)
				.header("tenant_id", Constants.tenant_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(200));
		adId = JsonUtils.getKeyValue(response, "data[0].adId");
		System.out.println("****************Ad_ID*************"+adId);

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ImpressionsAPI_VerifyResponseBody(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify Response parameters after calling create campaign api.");
		String URI = Constants.ADSE_domain+"/andes-ml/v1/ad/impression";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\ADSE\\impressionAPI.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessTokenClientCreds(Constants.client_id_client_cred,Constants.client_secret_client_cred))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id_client_cred)
				.header("trace_id", Constants.trace_id_client_cred)
				.header("tenant_id", Constants.tenant_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(200))
		.body("success", is(true))
		.body("message", is("Success"))
		.body("data[0].adId", notNullValue())
		.body("data[0].tenantId", notNullValue())
		.body("data[0].impressionTime", notNullValue())
		.body("data[0].productId", notNullValue())
		.body("data[0].productName", notNullValue())
		.body("data[0].productTitle", notNullValue())
		.body("data[0].imageUrl", notNullValue())
		.body("data[0].mrp", notNullValue())
		.body("data[0].refUrl", notNullValue())
		.body("data[0].productBrand", notNullValue());
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ImpressionsAPI_without_tenant_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "\"Verify status code and error message after calling impression api without tenant_id header.");
		String URI = Constants.ADSE_domain+"/andes-ml/v1/ad/impression";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\ADSE\\impressionAPI.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessTokenClientCreds(Constants.client_id_client_cred,Constants.client_secret_client_cred))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id_client_cred)
				.header("trace_id", Constants.trace_id_client_cred);
		
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ImpressionsAPI_without_client_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "\"Verify status code and error message after calling impression api without client_id header.");
		String URI = Constants.ADSE_domain+"/andes-ml/v1/ad/impression";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\ADSE\\impressionAPI.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessTokenClientCreds(Constants.client_id_client_cred,Constants.client_secret_client_cred))
				.body(payload);
		request.header("Content-Type", "application/json")

				.header("trace_id", Constants.trace_id_client_cred)
				.header("tenant_id", Constants.tenant_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 500");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(500));
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ImpressionsAPI_without_category_name(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling impression api without category_name in body.");
		String URI = Constants.ADSE_domain+"/andes-ml/v1/ad/impression";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\ADSE\\impressionAPI_without_category_name.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessTokenClientCreds(Constants.client_id_client_cred,Constants.client_secret_client_cred))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id_client_cred)
				.header("trace_id", Constants.trace_id_client_cred)
				.header("tenant_id", Constants.tenant_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(200))
		.body("data", nullValue());
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ImpressionsAPI_without_andes_user_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling impression api without andes_user_id in body.");
		String URI = Constants.ADSE_domain+"/andes-ml/v1/ad/impression";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\ADSE\\impressionAPI_without_andes_user_id.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessTokenClientCreds(Constants.client_id_client_cred,Constants.client_secret_client_cred))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id_client_cred)
				.header("trace_id", Constants.trace_id_client_cred)
				.header("tenant_id", Constants.tenant_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400));
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ImpressionsAPI_without_user(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling impression api without user in body.");
		String URI = Constants.ADSE_domain+"/andes-ml/v1/ad/impression";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\ADSE\\impressionAPI_without_user.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessTokenClientCreds(Constants.client_id_client_cred,Constants.client_secret_client_cred))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id_client_cred)
				.header("trace_id", Constants.trace_id_client_cred)
				.header("tenant_id", Constants.tenant_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400));
	}
}
