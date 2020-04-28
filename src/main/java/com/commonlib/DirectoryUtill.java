package com.commonlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public class DirectoryUtill {
	/*
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * */
	public static Connection connToDataBase()
	{
		Connection connection;
	//class.forname(com.mysl.cj.jdbc.Driver").newInstance();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hibernate","root","root");
			return connection;
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
/**
 *getDataFromDB method to retreive data from database as key value pairs
 *
 *@param query'
 *@param SQLException
 *@throws ClassNotFoundException
 *@throws ILLegalAccessException 
 */
	public static LinkedHashMap getDataFromDB(String query)
	{
	Connection con = null;
	LinkedHashMap data = new LinkedHashMap();
	
	try {
		con = connToDataBase();
		
		ResultSet result = con.createStatement().executeQuery(query);
		
		ResultSetMetaData resMetaData = result.getMetaData();
		for(int i=0; i<resMetaData.getColumnCount(); i++ )
		{
			data.put(resMetaData.getColumnName(i), result.getString(i));
		}
		return data;
	} 
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	return null;
	
	}
}
