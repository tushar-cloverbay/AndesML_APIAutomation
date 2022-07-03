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

public class AddProductsToCampaign extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling AddProductsToCampaign api.");
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
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(207));
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_Verify_tenant_details(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify response parameters details in response body after calling AddProductsToCampaign api.");
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
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(207))
		.body("tenant_id", notNullValue())
		.body("tenant_name", notNullValue())
		.body("advertiser_id", notNullValue())
		.body("advertiser_name", notNullValue())
		.body("seller_id", notNullValue())
		.body("seller_name", notNullValue())
		.body("total_products", notNullValue());
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_without_tenant_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling AddProductsToCampaign api without tenant_id header.");
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
		.body("errors[0].property", is("tenantId"))
		.body("errors[0].message", is("tenantId value is empty or invalid or missing"));	
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_without_advertiser_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling AddProductsToCampaign api without advertiser_id header.");
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
		
		.header("seller_id", Constants.seller_id);
		Response response = request.post(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("advertiserId"))
		.body("errors[0].message", is("advertiserId value is empty or invalid or missing"));	
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_without_seller_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling AddProductsToCampaign api without seller_id header.");
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
		.header("advertiser_id", Constants.advertiser_id);
		Response response = request.post(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("sellerId"))
		.body("errors[0].message", is("sellerId value is empty or invalid or missing"));	
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_without_client_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling AddProductsToCampaign api without client_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaign.json");
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(payload.toString());
		request.header("Content-Type", "application/json")
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
		.body("errors[0].property", is("clientId"))
		.body("errors[0].message", is("clientId value is empty or invalid or missing"));	
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_addDuplicateProduct(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error message after calling AddProductsToCampaign api with duplicate product.");
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
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(207))
		.body("products[0].status", is("FAILURE"))
		.body("products[0].message", is("Product already exists with product id: "));
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_addNewProduct(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error message after calling AddProductsToCampaign api with new product.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaign2.json");
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
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(207))
		.body("products[0].status", is("SUCCESS"))
		.body("products[0].message", is("Added Successfully"));
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_WithoutProduct(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error message after calling AddProductsToCampaign api without product.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaignWithoutProduct.json");
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
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("products"))
		.body("errors[0].message", is("Products is missing"));	
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_Without_productId(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error message after calling AddProductsToCampaign api without productId.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaignWithoutProductId.json");
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
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_Without_product_name(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error message after calling AddProductsToCampaign api without product_name.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaignWithout_product_name.json");
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
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_Without_productTitle(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error message after calling AddProductsToCampaign api without productTitle.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaignWithout_productTitle.json");
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
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_Without_product_brand(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error message after calling AddProductsToCampaign api without product_brand.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaignWithout_product_brand.json");
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
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_Without_productImageUrl(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error message after calling AddProductsToCampaign api without productImageUrl.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaignWithout_productImageUrl.json");
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
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_Without_productCpc(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error message after calling AddProductsToCampaign api without productCpc.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		System.out.println(URI);
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\AddProductToCampaignWithout_productCpc.json");
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
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void AddProductsToCampaign_Verify_error_invalid_campaignid(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message for invalid campaignidafter calling AddProductsToCampaign api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+"62b0415202a08410023e7c84"+"/products";
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
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 400");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].message", is("No Campaign found with campaign id: 62b0415202a08410023e7c84"));
	}
	
}
