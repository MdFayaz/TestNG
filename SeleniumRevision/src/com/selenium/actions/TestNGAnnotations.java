package com.selenium.actions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@BeforeSuite
	public void beforeSuite(){
		System.out.println("This message from beforeSuite() method");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("This message from beforeTest() method ");	
	}
	
	@Test(description = "This is a testLoginPage method")
	public void testLoginPage() {
		System.out.println("This message from testLoginPage() method ");
	}
	
	@Test(description = "This is a testInvocationCount method", invocationCount = 3)
	public void testInvocationCount() {
		System.out.println("This message from testInvocationCount() method with invocation count 3");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("This message from afterTest() method");
	}
	
	@Test (dependsOnGroups = { "GroupOneTest" })
	public void testGroupDependentMethod(){
		System.out.println("This message from testGroupDependentMethod() method");
	}
	
	@Test (dependsOnMethods = {"testGroupDependentMethod"})
	public void testDependedMethod(){
		System.out.println("This method from testDependedMethod() method");
	}
	
	@Test(groups = {"GroupOneTest"})
	public void anotherTestGroupOne(){
		System.out.println("This message from anotherTestGroupOne() method");
	}
	
	@Test(groups = {"GroupOneTest"})
	public void testGroupOne(){
		System.out.println("This message from testGroupOne() method");
	}
	
	@Test(groups = {"CommonGroupTest", "GroupTwoTest"})
	public void testGroupTwo(){
		System.out.println("This message from testGroupTwo() method");
	}
	
	@Test(groups = {"GroupTwoTest"})
	public void anotherTestGroupTwo(){
		System.out.println("This message from anotherTestGroupTwo() method");
	}
	
	@Test(groups = {"CommonGroupTest"})
	public void commonGroupTestMethod(){
		System.out.println("This message from commonGroupTestMethod() method");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("This message from afterSuite() method");
	}
}
