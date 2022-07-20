package net.andesml.Profile;

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

public class CheckVanity extends Base {
	
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void Attachments_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling Attachments api.");
		String URI = Constants.profile_domain+"/profiles/v1/"+profile_id+"/verification-doc";
		String payload = JsonUtils
				.payloadGenerator("Inputs\\" + Constants.ENV + "\\Profile\\Attachments.json");

		RequestSpecification request = RestAssured.given()
				.queryParam("operation", "ADD")
				.header("Authorization", "Bearer " + TestUtils.getAccessToken(Constants.profileUser, Constants.profilePassword))
				.body(payload);
		request.header("Content-Type", "application/json")
				.header("client_id", Constants.client_id)
				.header("tenant_id", profile_id);

		Response response = request.patch(URI);
		responseBase = response;
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(equalTo(200));
	}
	
}
