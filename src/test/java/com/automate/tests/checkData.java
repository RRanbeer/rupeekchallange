package com.automate.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import com.commonlib.CommonlyUsedFile;
import com.commonlib.OutcomePoints;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.Matchers;

public class checkData extends CommonlyUsedFile
{
	@Test
	public void checkAuth()
	{
		given().when().post(OutcomePoints.POST).then().assertThat().statusCode(400).and()
		.contentType(ContentType.JSON).and().body("error", Matchers.equalTo("Bad Request")).and()
		.time(lessThan(3000l));
	}
	
	@Test
	public void verifyAuth()
	{
		given().when().post(OutcomePoints.POST).then().assertThat().statusCode(200).and()
		.contentType(ContentType.JSON).and().time(lessThan(3000l));
	}
	
	@Test
	public void customer()
	{
		given().when().get(OutcomePoints.GET_ALL_CUSTOMERS).then().assertThat().statusCode(401).and()
		.contentType(ContentType.JSON).and().body("error", Matchers.equalTo("Unauthorized"))
		.and().time(lessThan(3000l));

	}
	
	@Test
	public void phone()
	{
		given().when().get(OutcomePoints.GET_PH_NUM).then().assertThat().statusCode(401).and()
		.contentType(ContentType.JSON).and().body("message", Matchers.equalTo("Unauthorized"))
		.and().time(lessThan(1000l));
	}

}
