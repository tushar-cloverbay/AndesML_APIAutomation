package net.andesml.CampaignManagement;

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

public class UpdateCampaign extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling UpdateCampaign api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 204");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(204));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_tenant_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling UpdateCampaign api without tenant_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
request.header("Content-Type", "application/json")
		
		.header("advertiser_id", Constants.advertiser_id)
		.header("client_id", Constants.client_id)
		.header("trace_id", Constants.trace_id)
		.header("seller_id", Constants.seller_id);
	Response response = request.get(URI);
	extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
	statusCode = ""+response.getStatusCode();
	responseBody =response.asPrettyString();
	System.out.println(response.asPrettyString());
	System.out.println(response.getStatusCode());
	response.then().assertThat().statusCode(equalTo(400));
//	.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
//	.body("errors[0].property", is("tenantId"))
//	.body("errors[0].message", is("tenantId value is empty or invalid or missing"));	

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_advertiser_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling UpdateCampaign api without advertiser_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
		.header("client_id", Constants.client_id)
		.header("trace_id", Constants.trace_id)
		.header("tenant_id", Constants.tenant_id)
		
		.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.asPrettyString();
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400));
//		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
//		.body("errors[0].property", is("advertiserId"))
//		.body("errors[0].message", is("advertiserId value is empty or invalid or missing"));	
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_seller_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling UpdateCampaign api without seller_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
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
		response.then().assertThat().statusCode(equalTo(400));
//		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
//		.body("errors[0].property", is("sellerId"))
//		.body("errors[0].message", is("sellerId value is empty or invalid or missing"));	

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_client_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling UpdateCampaign api without client_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
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
		response.then().assertThat().statusCode(equalTo(400));
//		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
//		.body("errors[0].property", is("clientId"))
//		.body("errors[0].message", is("clientId value is empty or invalid or missing"));	

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_campaignId(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling UpdateCampaign api without campaignId.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign_without_campaignId.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("campaignId"));
//		.body("errors[0].message", is("Campaign Id is missing"));	

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_startDate(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling UpdateCampaign api without start date.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign_without_startDate.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("startDate"));
//		.body("errors[0].message", is("Start Date is missing"));	

	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_endDate(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling UpdateCampaign api without endDate.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign_without_endDate.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("endDate"));
//		.body("errors[0].message", is("End Date is missing"));	

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_cpc(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling UpdateCampaign api without cpc.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign_without_cpc.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("cpc"));
//		.body("errors[0].message", is("Cpc is missing"));	

	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_budget(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling UpdateCampaign api without budget.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign_without_budget.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("budget"));
//		.body("errors[0].message", is("Budget is missing"));	

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_without_daily_budget(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling UpdateCampaign api without daily_budget.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign_without_daily_budget.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 204");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(204));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_invalid_budget(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling UpdateCampaign api with invalid budget.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign_invalidBudget.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].message", is("Budget has to be in between 20000.0 to 80000.0"));	

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_invalid_cpc(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling UpdateCampaign api with invalid cpc.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign_invalid_CPC.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].message", is("CPC has to be in between  0.3 to 2000.0"));	

	}
	
	
	
	
	
	
	
	
	
	
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateCampaign_Verify_error_pastDate(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and message for past start date after calling UpdateCampaign api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateCampaign.json");
		
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_id", Constants.campaignId);
		resultBody = TestUtils.updateJsonKey(resultBody, "start_date", "2022-06-22");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400));

	}
}
