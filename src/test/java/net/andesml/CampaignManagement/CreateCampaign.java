package net.andesml.CampaignManagement;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.andesml.base.Base;
import net.andesml.base.Constants;
import net.andesml.utils.JsonUtils;
import net.andesml.utils.TestUtils;

public class CreateCampaign extends Base {

	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Authentication(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "verify access token");
		Response response = RestAssured.given().auth().preemptive().basic(Constants.client_id, Constants.client_secret)
				.formParam("grant_type", "password")
				.formParam("username", Constants.user)
				.formParam("password", Constants.password)
				.when().post(Constants.access_token_url);
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : ");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();

	}

	@Test(dataProvider = "version-data-provider",priority = -1, enabled = true)
	public void CreateCampaign_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling create campaign api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaign.json");
		
		campaignName = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 207");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		campaignId = JsonUtils.getKeyValue(response, "campaign_id");
		response.then().assertThat().statusCode(equalTo(207));

	}
	
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_VerifywithoutCampaignName(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message if campaign id parameter is not present in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithoutCampaignName.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("campaignName"))
		.body("errors[0].message", is("Campaign Name  is missing"));	
	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Verifywithout_tenant_name(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message if tenant_name parameter is not present in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithoutTanentName.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("tenantName"))
		.body("errors[0].message", is("Tenant Name  is missing"));	
	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Verifywithout_advertiser_name(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message if advertiser_name parameter is not present in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithoutAdvertiserName.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("advertiserName"))
		.body("errors[0].message", is("Advertiser Name  is missing"));	
	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Verifywithout_seller_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message if seller_id parameter is not present in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithoutSeller_id.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("sellerId"))
		.body("errors[0].message", is("Seller Id  is missing"));	
	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Verifywithout_seller_name(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message if seller_name parameter is not present in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithoutSeller_name.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("sellerName"))
		.body("errors[0].message", is("Seller Name  is missing"));	
	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Verifywithout_budget(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message if budget parameter is not present in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithoutBudget.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("budget"))
		.body("errors[0].message", is("Budget  is missing"));	
	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_VerifyStatusCodeWithoutProduct(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling create campaign api without product in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithoutProduct.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 207");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(207))
		.body("status", is("CREATED"));

	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Verify_wrong_budget(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message if budget is not between 20000.00 to 80000.00.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWrongBudget.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].message", is("Budget has to be in between 20000.0 to 80000.0"));	
	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Verify_wrong_cpc(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message if cpc is not between 0.30 to 2000.00");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWrongCPC.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].message", is("CPC has to be in between  0.3 to 2000.0"));	
	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_VerifyStatusCodeWithout_product_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling create campaign api without product_id in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithout_product_id.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("products[0].productId"))
		.body("errors[0].message", is("Product Id is missing"));	

	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_VerifyStatusCodeWithout_product_name(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling create campaign api without product_name in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithout_product_name.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("products[0].productName"))
		.body("errors[0].message", is("Product Name is missing"));	

	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_VerifyStatusCodeWithout_product_title(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling create campaign api without product_title in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithout_product_title.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("products[0].productTitle"))
		.body("errors[0].message", is("Product Title is missing"));	

	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_VerifyStatusCodeWithout_product_brand(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling create campaign api without product_brand in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithout_product_brand.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("products[0].productBrand"))
		.body("errors[0].message", is("Product Brand is missing"));	

	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_VerifyStatusCodeWithout_product_image_url(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling create campaign api without product_image_url in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithout_product_image_url.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("products[0].productImageUrl"))
		.body("errors[0].message", is("Product Image Url is missing"));	

	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_VerifyStatusCodeWithout_product_cpc(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling create campaign api without product_cpc in body.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaignWithout_product_cpc.json");
		
		String campaignName1 = "Test " + TestUtils.getTime();
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName1);
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("products[0].productCpc"))
		.body("errors[0].message", is("Cpc is missing"));	

	}
	
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Verify_duplicate_campaign(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling create campaign api with duplicate campaign name.");
		apiVersion = version;
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaign.json");
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", campaignName);

		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 409");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(409))
		.body("errors[0].code", is("CAMPAIGN_CONFLICT"));

	}
	@Test(dataProvider = "version-data-provider", enabled = true)
	public void CreateCampaign_Verify_startDate(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling create campaign api if start date is past date.");
		apiVersion = version;
		String URI = Constants.campaign_manager_domain+"/campaigns/v1";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\CreateCampaign.json");
		String resultBody = TestUtils.updateJsonKey(payload, "campaign_name", "Test " + TestUtils.getTime());
		resultBody = TestUtils.updateJsonKey(resultBody, "start_date", "2022-06-20");
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(resultBody);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].message", is("must be a future date"));

	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void CreateCampaign_VerifyResponseParameters(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify Response parameters after calling create campaign api.");
		apiVersion = version;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 207");
		statusCode = ""+responseBase.getStatusCode();
		responseBody =responseBase.getBody().asString();
		responseBase.then().assertThat()
		.body("status", is("CREATED"))
		.body("campaign_id", notNullValue())
		.body("total_products_count", notNullValue())
		.body("successful_products_count", notNullValue())
		.body("products", notNullValue());
	}

	
}
