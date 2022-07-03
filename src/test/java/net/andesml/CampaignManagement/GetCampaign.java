package net.andesml.CampaignManagement;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.andesml.base.Base;
import net.andesml.base.Constants;
import net.andesml.utils.TestUtils;

public class GetCampaign extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling get campaign api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignName;

		RequestSpecification request = RestAssured.given()
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
		.header("tenant_id", Constants.tenant_id)
		.header("advertiser_id", Constants.advertiser_id)
		.header("client_id", Constants.client_id)
		.header("trace_id", Constants.trace_id)
		.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.asPrettyString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.statusCode(equalTo(200));
	}
	

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_Verify_responseBody(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify response parameters after calling get campaign api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignName;

		RequestSpecification request = RestAssured.given()
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
		.header("tenant_id", Constants.tenant_id)
		.header("advertiser_id", Constants.advertiser_id)
		.header("client_id", Constants.client_id)
		.header("trace_id", Constants.trace_id)
		.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.asPrettyString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.body("tenant_id", notNullValue())
		.body("tenant_name", notNullValue())
		.body("campaign_id", notNullValue())
		.body("campaign_name", notNullValue())
		.body("start_date", notNullValue())
		.body("end_date", notNullValue())
		.body("cpc", notNullValue())
		.body("budget", notNullValue())
		.body("clicks", notNullValue())
		.body("impressions", notNullValue());
	}

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_without_tenant_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling GetCampaign api without tenant_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignName;

		RequestSpecification request = RestAssured.given()
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
		
		.header("advertiser_id", Constants.advertiser_id)
		.header("client_id", Constants.client_id)
		.header("trace_id", Constants.trace_id)
		.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.asPrettyString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("tenantId"))
		.body("errors[0].message", is("tenantId value is empty or invalid or missing"));	
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_without_advertiser_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling GetCampaign api without advertiser_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignName;

		RequestSpecification request = RestAssured.given()
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
		.header("client_id", Constants.client_id)
		.header("trace_id", Constants.trace_id)
		.header("tenant_id", Constants.tenant_id)
		
		.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.asPrettyString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("advertiserId"))
		.body("errors[0].message", is("advertiserId value is empty or invalid or missing"));	
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_without_seller_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling GetCampaign api without seller_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignName;

		RequestSpecification request = RestAssured.given()
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
		.header("client_id", Constants.client_id)
		.header("trace_id", Constants.trace_id)
		.header("tenant_id", Constants.tenant_id)
		.header("advertiser_id", Constants.advertiser_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.asPrettyString();
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("sellerId"))
		.body("errors[0].message", is("sellerId value is empty or invalid or missing"));	
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_without_client_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling GetCampaign api without client_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignName;

		RequestSpecification request = RestAssured.given()
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
		.header("trace_id", Constants.trace_id)
		.header("tenant_id", Constants.tenant_id)
		.header("advertiser_id", Constants.advertiser_id)
		.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.asPrettyString();
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("clientId"))
		.body("errors[0].message", is("clientId value is empty or invalid or missing"));
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_invalid_campaignName(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling GetCampaign api for invalid campaign name.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+"invalidName";

		RequestSpecification request = RestAssured.given()
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
		.header("trace_id", Constants.trace_id)
		.header("tenant_id", Constants.tenant_id)
		.header("advertiser_id", Constants.advertiser_id)
		.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 404");
		statusCode = ""+response.getStatusCode();
		responseBody =response.asPrettyString();
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(404))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].message", is("campaign not found with name invalidName"));
	}
	
}
	