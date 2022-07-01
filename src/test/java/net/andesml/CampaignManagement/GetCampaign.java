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
	public void GetCampaign_Verify_tanent(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify tanent id and name after calling get campaign api.");
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
		.body("tenant_name", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_Verify_advertiser(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify advertiser id and name after calling get campaign api.");
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
		.body("campaign_id", notNullValue())
		.body("campaign_name", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_Verify_start_date(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify start_date and end_date after calling get campaign api.");
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
		.body("start_date", notNullValue())
		.body("end_date", notNullValue());
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_Verify_cpc_budget(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify cpc and budget count after calling get campaign api.");
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
		.body("cpc", notNullValue())
		.body("budget", notNullValue());
	}
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCampaign_Verify_clicks_impresion(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify clicks and impressions count after calling get campaign api.");
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
		.body("clicks", notNullValue())
		.body("impressions", notNullValue());
	}
}
	