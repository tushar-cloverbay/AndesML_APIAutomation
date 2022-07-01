package net.andesml.CampaignManagement;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.andesml.base.Base;
import net.andesml.base.Constants;
import net.andesml.utils.JsonUtils;
import net.andesml.utils.TestUtils;

public class UpdateProducts extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateProducts_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling UpdateProducts api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateProducts.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 207");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(207));
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateProducts_Verify_tenant_details(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify tenant details in response body after calling UpdateProducts api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateProducts.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 207");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(207))
		.body("tenant_id", notNullValue())
		.body("tenant_name", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateProducts_Verify_advertiser(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify advertiser details in response body after calling UpdateProducts api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateProducts.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 207");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(207))
		.body("advertiser_id", notNullValue())
		.body("advertiser_name", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateProducts_Verify_seller(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify seller details in response body after calling UpdateProducts api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateProducts.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 207");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(207))
		.body("seller_id", notNullValue())
		.body("seller_name", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateProducts_Verify_total_products(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify total products count in response body after calling UpdateProducts api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+campaignId+"/products";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateProducts.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("trace_id", Constants.trace_id)
				.header("tenant_id", Constants.tenant_id)
				.header("advertiser_id", Constants.advertiser_id)
				.header("seller_id", Constants.seller_id);
		Response response = request.patch(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 207");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.body("total_products", notNullValue());
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void UpdateProducts_Verify_error_invalid_campaignid(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify error code and error message for invalid campaignidafter calling UpdateProducts api.");
		String URI = Constants.campaign_manager_domain+"/campaigns/v1/"+"62b0415202a08410023e7c84"+"/products";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\CampaignManager\\UpdateProducts.json");
		
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.user, Constants.password))
				.body(payload);
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
		.body("errors[0].message", is("No Campaign found with campaign id: 62b0415202a08410023e7c84"));
	}
}