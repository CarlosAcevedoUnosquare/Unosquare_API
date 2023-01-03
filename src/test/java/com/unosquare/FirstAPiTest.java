package com.unosquare;

import org.testng.annotations.Test;

import com.reader.ConfigFileReadFromFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;


public class FirstAPiTest {
  //@Test
  public void f() {
	  
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users/2");
		
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode,200);
		Reporter.log("Sucess 200 validation");
		
		String validating = null;
		JsonPath jsonPathEvaluator = response.jsonPath();
		
//		Response wholeData = httpRequest.get("/users");
//		ResponseBody wholeBody = wholeData.getBody();
//		System.out.println(wholeBody.prettyPrint().toString());
		
		validating = jsonPathEvaluator.get("data.first_name");
		System.out.println("Expecting value to be: " + validating);
		response.then().body("data.first_name", equalTo("Janet"));
		Reporter.log(response.body().asString());
		
		validating = jsonPathEvaluator.get("data.last_name");
		System.out.println("Expecting value to be: " + validating);
		response.then().body("data.last_name", equalTo("Weaver"));
		Reporter.log(response.body().asString());
		
		System.out.println("The body of the response is the following:");
		ResponseBody body = response.getBody();
		System.out.println(body.prettyPrint().toString());
		
		String emailValue = jsonPathEvaluator.get("data.email");
		System.out.println("The value of email is: " + emailValue);
		
  }
  
  
  //@Test
  public void post_request() {
	  JSONObject requestParams = new JSONObject(); 
	  requestParams.put("name","JohnAPI");
	  requestParams.put("job","QA");
	  
//	  Request payload will look like this:
//	  {
//		    "name": "JohnAPI",
//		    "job": "QA"
//		}
	  
		 RestAssured.baseURI = "https://reqres.in/api"; 
		 RequestSpecification httpRequest = RestAssured.given(); 
		 httpRequest.headers("Content-Type", "application/json");
		 httpRequest.body(requestParams.toString());
		 Reporter.log(requestParams.toString());
		 
		 System.out.println(requestParams.toString());
		 Response response = httpRequest.post("/users");
		 System.out.println(response.prettyPrint().toString());
		 Reporter.log(response.body().asString());
  }
  
  @Test
  public void post_exercise() {
	  
	  ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
	  String reqres_URL = configFileReadFromFile.getJsonValueOf("reqres_url");
	  String user1_name = configFileReadFromFile.getJsonValueOf("userOne");
	  String user1_job = configFileReadFromFile.getJsonValueOf("jobUserOne");
	  
	  JSONObject requestParams = new JSONObject(); 
	  requestParams.put("name",user1_name);
	  requestParams.put("job",user1_job);
	  
		 RestAssured.baseURI = reqres_URL; 
		 RequestSpecification httpRequest = RestAssured.given(); 
		 httpRequest.headers("Content-Type", "application/json");
		 httpRequest.body(requestParams.toString());
		 System.out.println(requestParams.toString());
		 Reporter.log("Request parameters: " + requestParams.toString());
		 Response response = httpRequest.post("/users");
		 System.out.println(response.body().asString());
		 Reporter.log("Response Body: " + response.body().asString());
		 System.out.println("" + response.getStatusCode());
		 
		 int statusCode = response.getStatusCode();
		 Reporter.log("Status code: " + statusCode);
		 Reporter.log("URL used for this script: ["+reqres_URL+"]");
  }
  
  
  @Test
  public void post_exercise2() {
	  
	  ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
	  String reqres_URL = configFileReadFromFile.getJsonValueOf("reqres_url");
	  String user2_name = configFileReadFromFile.getJsonValueOf("userTwo");
	  String user2_job = configFileReadFromFile.getJsonValueOf("jobUserTwo");
	  
	  JSONObject requestParams = new JSONObject(); 
	  requestParams.put("name",user2_name);
	  requestParams.put("job",user2_job);
	  
		 RestAssured.baseURI = reqres_URL; 
		 RequestSpecification httpRequest = RestAssured.given(); 
		 httpRequest.headers("Content-Type", "application/json");
		 httpRequest.body(requestParams.toString());
		 System.out.println(requestParams.toString());
		 Reporter.log(requestParams.toString());
		 Response response = httpRequest.post("/users");
		 System.out.println(response.body().asString());
		 Reporter.log("Response Body: " + response.body().asString());
		 System.out.println("" + response.getStatusCode());
		 
		 int statusCode = response.getStatusCode();
		 Reporter.log("Status code: " + statusCode);
		 Reporter.log("URL used for this script: ["+reqres_URL+"]");
  }
  
  //@Test
  public void f_Gherkin() {
	  System.out.println("This is the F_Gherkin method");
	  RestAssured.given()
	  .when()
	  	.get("https://reqres.in/api/users/2")
	  		.then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON);
	  
	  Reporter.log("Sucess 200 validation");
}
  
  
  
  
  //@Test
  public void f_fix() {
	  
	  RestAssured.given()
	  .when()
	  	.get("https://reqres.in/api/users/2")
	  		.then()
	  		.assertThat().statusCode(200)
	  		.assertThat().contentType(ContentType.JSON)
	  		.assertThat().body("data.first_name", equalTo("Janet"));
	  
	  Reporter.log("Sucess 200 validation");
}
  
  
  
  //@Test
  public void first_PR() {
	  
	  RestAssured.given()
	  .when()
	  	.get("https://reqres.in/api/users/2")
	  		.then()
	  		.assertThat().statusCode(200)
	  		.assertThat().contentType(ContentType.JSON)
	  		.assertThat().body("data.id", equalTo(2))
	  		.assertThat().body("data.email", equalTo("janet.weaver@reqres.in"))
	  		.assertThat().body("data.first_name", equalTo("Janet"))
	  		.assertThat().body("data.last_name", equalTo("Weaver"))
	  		.assertThat().body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
	  		
	  		.assertThat().body("support.url", equalTo("https://reqres.in/#support-heading"))
	  		.assertThat().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	  
	  Reporter.log("Sucess 200 validation");
}
  
  //@Test
  public void second_PR() {
	  
	  RestAssured.given()
	  .when()
	  	.get("https://reqres.in/api/unknown/2")
	  		.then()
	  		.assertThat().statusCode(200)
	  		.assertThat().contentType(ContentType.JSON)
	  		.assertThat().body("data.id", equalTo(2))
	  		.assertThat().body("data.name", equalTo("fuchsia rose"))
	  		.assertThat().body("data.year", equalTo(2001))
	  		.assertThat().body("data.color", equalTo("#C74375"))
	  		.assertThat().body("data.pantone_value", equalTo("17-2031"))
	  		
	  		.assertThat().body("support.url", equalTo("https://reqres.in/#support-heading"))
	  		.assertThat().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	  
	  Reporter.log("Sucess 200 validation");
}
  
  

  //@Test
  public void jsonFinder() {
	  ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
	  String first_name = configFileReadFromFile.getJsonValueOf("first_name");
	  System.out.println("Data used for this test: [first_name] = "+ first_name);
	  RestAssured.given()
	  .when()
	  	.get("https://reqres.in/api/users/2")
	  		.then()
	  		.assertThat().statusCode(200)
	  		.assertThat().contentType(ContentType.JSON)
	  		.assertThat().body("data.first_name", equalTo(first_name));
	  
	  Reporter.log("Sucess 200 validation");
  }
  
  /* Adding test here to be executed on CI azure */
  
  SecondAPiTest test = new SecondAPiTest();
	@Test
	public void getCall1() {
		int testResponse = test.getReqresRequest("/api/users?page=2");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall2() {
		int testResponse = test.getReqresRequest("/api/users/2");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall3() {
		int testResponse = test.getReqresRequest("/api/unknown");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall4() {
		int testResponse = test.getReqresRequest("/api/unknown/2");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void postCall1Create() {
		int testResponse = test.postCreate("/users");
		Assert.assertEquals(201, testResponse);
	}
	
	@Test
	public void postCall2Register() {
		int testResponse = test.postRegisterSuccess("/register");
		Assert.assertEquals(200, testResponse);
	}
	
	
	@Test
	public void postCall3RegisterFailed() {
		int testResponse = test.postRegisterFailed("/register");
		Assert.assertEquals(400, testResponse);
	}
	
	@Test
	public void postCall4Login() {
		int testResponse = test.postLogin("/login");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void putCall1Update() {
		int testResponse = test.putUpdate("/users/2");
		Assert.assertEquals(200, testResponse);
	}
	
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

}
