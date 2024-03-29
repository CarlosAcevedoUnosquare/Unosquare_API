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

public class APiCalls {
	SecondAPiTest test = new SecondAPiTest();
	
	@Test
	public void getCall0() {
		int testResponse = test.getRequest("configFile.json","/api/users?page=2");
		Assert.assertEquals(200, testResponse);
	}
	@Test
	public void getCall1() {
		int testResponse = test.getReqresRequest("/api/users?page=2");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall1Path() {
		int testResponse = test.getRequest("configFile.json", "/api/users?page=2");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall2() {
		int testResponse = test.getReqresRequest("/api/users/2");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall2path() {
		int testResponse = test.getRequest("configFile.json", "/api/users/2");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall3() {
		int testResponse = test.getReqresRequest("/api/unknown");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall3Path() {
		int testResponse = test.getRequest("configFile.json", "/api/unknown");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall4() {
		int testResponse = test.getReqresRequest("/api/unknown/2");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void getCall4Path() {
		int testResponse = test.getRequest("configFile.json", "/api/unknown/2");
		Assert.assertEquals(200, testResponse);
	}
	
	/////////////////////////////////////////////////////////////////////
	@Test
	public void postCall1Create() {
		int testResponse = test.postCreate("/users");
		Assert.assertEquals(201, testResponse);
	}
	
	@Test
	public void postCall1Create2() {
		int testResponse = test.postCreate("configFile.json", "/users");
		Assert.assertEquals(201, testResponse);
	}
	
	@Test
	public void postCall2Register() {
		int testResponse = test.postRegisterSuccess("/register");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void postCall2Register2() {
		int testResponse = test.postRegisterSuccess("configFile.json", "/register");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void postCall3RegisterFailed() {
		int testResponse = test.postRegisterFailed("/register");
		Assert.assertEquals(400, testResponse);
	}
	
	@Test
	public void postCall3RegisterFailed2() {
		int testResponse = test.postRegisterFailed("configFile.json", "/register");
		Assert.assertEquals(400, testResponse);
	}
	
	@Test
	public void postCall4Login() {
		int testResponse = test.postLogin("/login");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void postCall4Login2() {
		int testResponse = test.postLogin("configFile.json", "/login");
		Assert.assertEquals(200, testResponse);
	}
	
	/////////////////////////////////////////////////////////////////////
	
	@Test
	public void putCall1Update() {
		int testResponse = test.putUpdate("/users/2");
		Assert.assertEquals(200, testResponse);
	}
	
	@Test
	public void putCall1Update2() {
		int testResponse = test.putUpdate("configFile.json", "/users/2");
		Assert.assertEquals(200, testResponse);
	}
	  @BeforeMethod
	  public void beforeMethod() {
		  
	  }
}
