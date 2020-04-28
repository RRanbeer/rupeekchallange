package com.commonlib;


import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 *author Ranbeer 
 *
 */
public class CommonlyUsedFile {
	/*
	 * to initialize the base baseURI, port number and autontication
	 * */
	@BeforeSuite
	public void config()
	{
		baseURI = "http://13.126.80.194:8080";
		port = 8080;
		
		// basic auth
	  given().auth().basic("rupeek","password");
		
		//Bearer Token
	}

}
