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

public class GetCatalogueProducts extends Base {

	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCatalogueProducts_VerifyStatusCode(String version) throws Exception {
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling GetCatalogueProducts api.");
		apiVersion = version;
		String URI = Constants.campaign_manager_domain+"/catalogue/v1/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("brand", "TRP%7C%5ETAG%20METALS")
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
			.header("tenant_id", Constants.tenant_id)
			.header("client_id", Constants.client_id)
			.header("trace_id", Constants.trace_id)
			.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.statusCode(equalTo(200));
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCatalogueProducts_Verify_response_body(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify response body parameters after calling GetCatalogueProducts api.");
		apiVersion = version;
		String URI = Constants.campaign_manager_domain+"/catalogue/v1/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("brand", "TRP%7C%5ETAG%20METALS")
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
			.header("tenant_id", Constants.tenant_id)
			.header("client_id", Constants.client_id)
			.header("trace_id", Constants.trace_id)
			.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.body("tenant_id", notNullValue())
		.body("seller_id", notNullValue())
		.body("total_products", notNullValue())
		.body("page_size", notNullValue());
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCatalogueProducts_Verify_category_subCategory(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify status code after calling GetCatalogueProducts api with category and sub category.");
		apiVersion = version;
		String URI = Constants.campaign_manager_domain+"/catalogue/v1/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("category", "Cycling%7C%5EBike").queryParam("sub_category", "Bicycle Parts%7C%5ESampleeee")
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
			.header("tenant_id", Constants.tenant_id)
			.header("client_id", Constants.client_id)
			.header("trace_id", Constants.trace_id)
			.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.statusCode(equalTo(200))
		.body("products", notNullValue());
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCatalogueProducts_Verify_max_min_mrp(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify max and min mrp after calling GetCatalogueProducts api with category and sub category.");
		apiVersion = version;
		String URI = Constants.campaign_manager_domain+"/catalogue/v1/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("min_mrp", "500").queryParam("max_mrp", "2000")
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
			.header("tenant_id", Constants.tenant_id)
			.header("client_id", Constants.client_id)
			.header("trace_id", Constants.trace_id)
			.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.statusCode(equalTo(200))
		.body("products", notNullValue());	
		}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCatalogueProducts_Verify_pageNumber_pageSize_parameter(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify with page_number and page size parameter in response body after calling get campaign list api.");
		String URI = Constants.campaign_manager_domain+"/catalogue/v1/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "1").queryParam("page_size", "10")
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
			.header("tenant_id", Constants.tenant_id)
			.header("client_id", Constants.client_id)
			.header("trace_id", Constants.trace_id)
			.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.statusCode(equalTo(200))
		.body("products", notNullValue());	
	}
	
	@Test(dataProvider = "version-data-provider",enabled = true)
	public void GetCatalogueProducts_Verify_product_details(String version) throws Exception
	{
		extentTest.log(LogStatus.PASS, "Test Description : " + "Verify product details in response body after calling get campaign list api.");
		String URI = Constants.campaign_manager_domain+"/catalogue/v1/products";

		RequestSpecification request = RestAssured.given()
			.queryParam("page_number", "1").queryParam("page_size", "10")
			.header("Authorization", "Bearer "+TestUtils.getAccessToken(Constants.user, Constants.password));
		request.header("Content-Type", "application/json")
			.header("tenant_id", Constants.tenant_id)
			.header("client_id", Constants.client_id)
			.header("trace_id", Constants.trace_id)
			.header("seller_id", Constants.seller_id);
		Response response = request.get(URI);
		extentTest.log(LogStatus.PASS, "ExpectedStatus Code : 200");
		statusCode = ""+response.getStatusCode();
		responseBody =response.getBody().asString();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		response.then().assertThat()
		.statusCode(equalTo(200))
		.body("products[0].product_id", notNullValue())
		.body("products[0].product_name", notNullValue())
		.body("products[0].product_title", notNullValue())
		.body("products[0].product_image_url", notNullValue())
		.body("products[0].mrp", notNullValue())
		.body("products[0].currency", notNullValue())
		.body("products[0].product_brand", notNullValue())
		.body("products[0].andes_category", notNullValue())
		.body("products[0].andes_sub_category", notNullValue())
		.body("products[0].in_stock", notNullValue());	
	}
}
