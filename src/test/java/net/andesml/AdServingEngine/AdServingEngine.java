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

public class AdServingEngine extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ImpressionsAPI_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		String tenantID = "t_123";
		String userId = "u_1";
		String UserIDType = "device_id";
		String categoryName = "Jeans";
		String totalResults = "2";
		String URI ="http://35.206.93.140:8092/andes-ml/v1/ad/impression?tenant_id="+tenantID
				+ "&user_id="+userId
				+ "&user_id_type="+UserIDType
				+ "&category="+categoryName
				+ "&total_results="+totalResults;
		extentTest.log(LogStatus.PASS, "API URI : " + URI);

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		Response response = request.get(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(201));

	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void ClicksAPI_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "");
		apiVersion = version;
		
		String adId = "c1df35f5215549b3a2adfd117fcd5c51_20220426041128_lwIicPOBI";
		String encryptedPdpUrl = "em6YWaOFrgJdY3s%2BYpt7TQOt5%2FvGHl8%2BBqJDjniRiFlZhPok2Uj7w7G91gkpu3iXeYbfXWqppXmT9B%2BKklkxNOLc6AX5YYr1vufwxCvGO8CYH0DJpuUxrfDNddnQbXFul7w%2FRGEKKTZONAQ00pZ9BkaArGM%2BiBDcPbyPofs5R7xPzcEThTtNNpCd06psbheMyZ0pM6vwMlj4Azy2p2XRNKYeqDC%2FQ0IBgstL4ePl5cQVftnGtshjE6lIs8CkGuoB4FUsHXu%2BQl8pu5sDTKRYzGCywI2LxpPWiOIuU43g6rpxIj7N%2FdbHGMCHpXuUXPZbtK1EpC4J4fbTs9TU7QSVkJnVJ%2FB%2FXN5WBCskEXmDufQkdmjewL7sj7sWRE2ffq0dCXWLQpEPDiSg3E8QwPR9RYwcV3Nd6%2B%2FfgbvDeCSx%2FJVRGrAVED62pGirpK5Dxury8l0jSHE7Y2jIeDr4UNVUwjYeCEAsfnLnK3fKqqHCWGf4k9rf7DQh9mVyUagCsojhEg%3D%3D";
		String isUrlEncrypted = "isUrlEncrypted";
		String tenantID = "t_123";
		String userId = "U130";
		String campaignID = "c_123";
		String productID = "option_3";
		String categoryName = "Jeans";
		String impressionCPC = "100";
		String cpc = "10";					
		String cpm = "0";
		String requestType = "CATEGORY";
		String searchKw = "";
		
		String URI ="https://"+Constants.ENV+"/andes-ml/ad/v1/click?adId="+adId
				+ "&encryptedPdpUrl="+encryptedPdpUrl
				+ "&isUrlEncrypted="+isUrlEncrypted
				+ "&tenantId="+tenantID
				+ "&userId="+userId
				+ "&campaignId="+campaignID
				+ "&productId="+productID
				+ "&categoryName="+categoryName
				+ "&impressionCpc="+impressionCPC
				+ "&productCode="+productID
				+ "&cpc="+cpc
				+ "&cpm="+cpm
				+ "&requestType="+requestType
				+ "&searchKw";
		extentTest.log(LogStatus.PASS, "API URI : " + URI);

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		Response response = request.get(URI);
		log.info("Requeste Submited");
		responseBody = response.asPrettyString();
		statusCode = Integer.toString(response.getStatusCode());
		System.out.println(responseBody);
		response.then().assertThat()
		.statusCode(equalTo(200));

	}
}
