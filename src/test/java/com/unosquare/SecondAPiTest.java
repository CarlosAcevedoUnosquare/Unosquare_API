package com.unosquare;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.reader.ConfigFileReadFromFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SecondAPiTest {
	  //@Test
	  public void f() {

	  }
	  
	  public int post1() {
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
			 
			 System.out.println("Post 1 status code: " + statusCode);
			 return statusCode;
	  }
	  
	  /**
	   * Method for POST CREATE call
	   * Structure for this method:
	   * { "name": name, "job": job }
	   * 
	   * @return
	   */
	  public int postCreate(String URL) {
		  ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
		  String reqres_URL = configFileReadFromFile.getJsonValueOf("reqres_url");
		  String user_name = configFileReadFromFile.getJsonValueOf("userOne");
		  String user_job = configFileReadFromFile.getJsonValueOf("jobUserOne");
		  
		  JSONObject requestParams = new JSONObject(); 
		  requestParams.put("name",user_name);
		  requestParams.put("job",user_job);
		  
			 RestAssured.baseURI = reqres_URL; 
			 RequestSpecification httpRequest = RestAssured.given(); 
			 httpRequest.headers("Content-Type", "application/json");
			 httpRequest.body(requestParams.toString());
			 System.out.println(requestParams.toString());
			 Reporter.log("Request parameters: " + requestParams.toString());
			 URL = reqres_URL + URL;
			 Response response = httpRequest.post(URL);
			 System.out.println(response.body().asString());
			 Reporter.log("Response Body: " + response.body().asString());
			 System.out.println("" + response.getStatusCode());
			 
			 int statusCode = response.getStatusCode();
			 Reporter.log("Status code: " + statusCode);
			 Reporter.log("URL used for this script: ["+URL+"]");
			 
			 System.out.println("Post status code: " + statusCode);
			 return statusCode;
	  }
	  
	  /**
	   * Method for POST REGISTER call
	   * Structure for this method:
	   * { "email": email, "password": password }
	   * 
	   * @return
	   */
	  public int postRegisterSuccess(String URL) {
		  ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
		  String reqres_URL = configFileReadFromFile.getJsonValueOf("reqres_url");
		  String user_email = configFileReadFromFile.getJsonValueOf("userOneEmail");
		  String user_pwd = configFileReadFromFile.getJsonValueOf("userOnePwd");
		  
		  JSONObject requestParams = new JSONObject(); 
		  requestParams.put("email",user_email);
		  requestParams.put("password",user_pwd);
		  
			 RestAssured.baseURI = reqres_URL; 
			 RequestSpecification httpRequest = RestAssured.given(); 
			 httpRequest.headers("Content-Type", "application/json");
			 httpRequest.body(requestParams.toString());
			 System.out.println(requestParams.toString());
			 Reporter.log("Request parameters: " + requestParams.toString());
			 URL = reqres_URL + URL;
			 Response response = httpRequest.post(URL);
			 System.out.println(response.body().asString());
			 Reporter.log("Response Body: " + response.body().asString());
			 System.out.println("" + response.getStatusCode());
			 
			 int statusCode = response.getStatusCode();
			 Reporter.log("Status code: " + statusCode);
			 Reporter.log("URL used for this script: ["+URL+"]");
			 
			 System.out.println("Post status code: " + statusCode);
			 return statusCode;
	  }
	  
	  
	  /**
	   * Method for POST REGISTER call
	   * Structure for this method:
	   * { "email": email }
	   * 
	   * @return
	   */
	  public int postRegisterFailed(String URL) {
		  ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
		  String reqres_URL = configFileReadFromFile.getJsonValueOf("reqres_url");
		  String user_email = configFileReadFromFile.getJsonValueOf("userOneEmail");
		  
		  JSONObject requestParams = new JSONObject(); 
		  requestParams.put("email",user_email);
		  
			 RestAssured.baseURI = reqres_URL; 
			 RequestSpecification httpRequest = RestAssured.given(); 
			 httpRequest.headers("Content-Type", "application/json");
			 httpRequest.body(requestParams.toString());
			 System.out.println(requestParams.toString());
			 Reporter.log("Request parameters: " + requestParams.toString());
			 URL = reqres_URL + URL;
			 Response response = httpRequest.post(URL);
			 System.out.println(response.body().asString());
			 Reporter.log("Response Body: " + response.body().asString());
			 System.out.println("" + response.getStatusCode());
			 
			 int statusCode = response.getStatusCode();
			 Reporter.log("Expected code for this test is 400.");
			 Reporter.log("Status code: " + statusCode);
			 Reporter.log("URL used for this script: ["+URL+"]");
			 
			 System.out.println("NOTE: Expected status code: 400");
			 System.out.println("Post status code: " + statusCode);
			 return statusCode;
	  }
	  
	  
	  /**
	   * Method for POST LOGIN call
	   * Structure for this method:
	   * { "email": email, "password": password }
	   * 
	   * @return
	   */
	  public int postLogin(String URL) {
		  ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
		  String reqres_URL = configFileReadFromFile.getJsonValueOf("reqres_url");
		  String user_email = configFileReadFromFile.getJsonValueOf("userOneEmail");
		  String user_pwd = configFileReadFromFile.getJsonValueOf("postPassword");
		  
		  JSONObject requestParams = new JSONObject(); 
		  requestParams.put("email",user_email);
		  requestParams.put("password",user_pwd);
		  
			 RestAssured.baseURI = reqres_URL; 
			 RequestSpecification httpRequest = RestAssured.given(); 
			 httpRequest.headers("Content-Type", "application/json");
			 httpRequest.body(requestParams.toString());
			 System.out.println(requestParams.toString());
			 Reporter.log("Request parameters: " + requestParams.toString());
			 URL = reqres_URL + URL;
			 Response response = httpRequest.post(URL);
			 System.out.println(response.body().asString());
			 Reporter.log("Response Body: " + response.body().asString());
			 System.out.println("" + response.getStatusCode());
			 
			 int statusCode = response.getStatusCode();
			 Reporter.log("Status code: " + statusCode);
			 Reporter.log("URL used for this script: ["+URL+"]");
			 
			 System.out.println("Post status code: " + statusCode);
			 return statusCode;
	  }
	  
	  
	  /**
	   * Method for PUT UPDATE call
	   * Structure for this method:
	   * { "name": name, "job": job }
	   * 
	   * @return
	   */
	  public int putUpdate(String URL) {
		  ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
		  String reqres_URL = configFileReadFromFile.getJsonValueOf("reqres_url");
		  String user_name = configFileReadFromFile.getJsonValueOf("userOne");
		  String user_job = configFileReadFromFile.getJsonValueOf("jobUserOne");
		  
		  JSONObject requestParams = new JSONObject(); 
		  requestParams.put("name",user_name);
		  requestParams.put("job",user_job);
		  
			 RestAssured.baseURI = reqres_URL; 
			 RequestSpecification httpRequest = RestAssured.given(); 
			 httpRequest.headers("Content-Type", "application/json");
			 httpRequest.body(requestParams.toString());
			 System.out.println(requestParams.toString());
			 Reporter.log("Request parameters: " + requestParams.toString());
			 URL = reqres_URL + URL;
			 Response response = httpRequest.put(URL);
			 System.out.println(response.body().asString());
			 Reporter.log("Response Body: " + response.body().asString());
			 System.out.println("" + response.getStatusCode());
			 
			 int statusCode = response.getStatusCode();
			 Reporter.log("Status code: " + statusCode);
			 Reporter.log("URL used for this script: ["+reqres_URL+"]");
			 
			 System.out.println("Post status code: " + statusCode);
			 return statusCode;
	  }
	  
	  
	  public int getReqresRequest(String URL) {
		  ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
		  String getURL = configFileReadFromFile.getJsonValueOf("reqres_partial_url");
		  getURL = getURL + URL;
		  RestAssured.given()
		  .when()
		  	.get(getURL)
		  		.then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON);
		  
		  Reporter.log("Sucess 200 validation");
		  
		  RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get(getURL);
			int statusCode = response.getStatusCode();
			// Assert that correct status code is returned.
			Assert.assertEquals(statusCode,200);
			
			System.out.println("Response: " + response.getStatusCode());
			return response.getStatusCode();
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  
	  }

	}
