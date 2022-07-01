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
	public void getProducts_Verify_tenant_id(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify tenant_id after calling get campaign list api.");
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
		.body("tenant_id", notNullValue());
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getProducts_Verify_advertiser_id(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify advertiser_id after calling get campaign list api.");
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
		.body("advertiser_id", notNullValue());
	}
	
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getProducts_Verify_page_number(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify page_number after calling get campaign list api.");
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
		.body("page_number", notNullValue());
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void getProducts_Verify_page_size(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify page_size after calling get campaign list api.");
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
		.body("page_size", notNullValue());
	}
	
}
