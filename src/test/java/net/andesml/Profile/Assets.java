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

public class Assets extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void uploadAssets_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String URI ="https://"+Constants.ENV+"/andes-ml/v1/assets";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		request.queryParam("vanity_name", "");
		Response response = request.post(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void deleteAssets_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String URI ="https://"+Constants.ENV+"/andes-ml/v1/assets";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);
		String payload = JsonUtils.payloadGenerator("Inputs\\"+Constants.ENV+"\\example\\.json");
		requestBody = payload;
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		request.queryParam("vanity_name", "").queryParam("mediaUrl", "");
		Response response = request.delete(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(207));

	}
}
