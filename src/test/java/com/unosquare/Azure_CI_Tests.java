package com.unosquare;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class Azure_CI_Tests {
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
