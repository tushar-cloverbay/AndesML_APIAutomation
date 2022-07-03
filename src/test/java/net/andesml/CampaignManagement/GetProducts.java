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

public class GetProducts extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getProducts_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling get campaign list api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "1").queryParam("page_size", "10")
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
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.statusCode(equalTo(200));
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getProducts_Verify_responseBody(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify response parameters after calling get campaign list api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "1").queryParam("page_size", "10")
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
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.body("tenant_id", notNullValue())
		.body("advertiser_id", notNullValue())
		.body("page_number", notNullValue())
		.body("page_size", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getProducts_without_tenant_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling getProducts api without tenant_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "1").queryParam("page_size", "10")
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
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("tenantId"))
		.body("errors[0].message", is("tenantId value is empty or invalid or missing"));	
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getProducts_without_advertiser_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling getProducts api without advertiser_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "1").queryParam("page_size", "10")
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
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].property", is("advertiserId"))
		.body("errors[0].message", is("advertiserId value is empty or invalid or missing"));	
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getProducts_without_seller_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling getProducts api without seller_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "1").queryParam("page_size", "10")
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
	public void getProducts_without_client_id(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code and error message after calling getProducts api without client_id header.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "1").queryParam("page_size", "10")
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
	public void getProducts_Verify_pageSize_0(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling get campaign list api with 0 page size.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "1").queryParam("page_size", "0")
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
			.header("tenant_id", Constants.tenant_id)
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
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].message", is("Invalid page number or page size."));
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getProducts_Verify_page_number_0(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message after calling get campaign list api with 0 page_number.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "0").queryParam("page_size", "10")
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
			.header("tenant_id", Constants.tenant_id)
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
		response.then().assertThat().statusCode(equalTo(400))
		.body("errors[0].code", is("CAMPAIGN_VALIDATION_ERROR"))
		.body("errors[0].message", is("Invalid page number or page size."));
	}

	
	
	
	
}
