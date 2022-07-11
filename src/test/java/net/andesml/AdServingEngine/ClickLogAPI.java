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

public class ClickLogAPI extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ClickLogAPI_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling ClickLogAPI api.");
		String URI = "https://dev.adserv.api.andesml.com/andes-ml/v1/ad/click";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		
		RequestSpecification request = RestAssured.given()
				.queryParam("adId", "f3c606e1226b43088129a7e8dffb0855_20220711022852_R3PGqRK87l")
				.queryParam("tenantId", "629886dcc2311500bd86854a")
				.queryParam("productId", "2836")
				.queryParam("campaignId", "62c5aa6b3daf5950565e0b51")
				.queryParam("cpc", "300")
				.queryParam("cpm", "")
				.queryParam("encryptedPdpUrl", "tgNmdoidj2m1JO77jL7lyJ9bl4u6gRieWtFvzazsNGNBRxTEDez%2FVb9cwWYnq8JxVweUTBpkJxm3c%2FKxQ0uo0QVPrBg3sSykSvGLCXjGBkZD7WGctMIZsJs%3D")
				.queryParam("isUrlEncrypted", "true")
				.queryParam("requestType", "CATEGORY_LISTING_PAGE")
				.queryParam("searchKw", "Dharco")
				.queryParam("categoryName", "")
				
				.header("Authorization", "Bearer " + TestUtils.getAccessTokenClientCreds(Constants.client_id_client_cred,Constants.client_secret_client_cred));
		request.header("Content-Type", "application/json")
		.header("client_id", Constants.client_id_client_cred)
		.header("trace_id", Constants.trace_id_client_cred);

		Response response = request.get(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(200));

	}
	
}
