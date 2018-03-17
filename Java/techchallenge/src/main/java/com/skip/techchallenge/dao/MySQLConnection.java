package com.skip.techchallenge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/************************************************************************************
 * @desc A singleton database access class for MySQL
 * @author felipe.bonfim
 ************************************************************************************/
public class MySQLConnection {

	public Connection conn;
	private Statement statement;
	public static MySQLConnection db;
	
	private MySQLConnection() {
		String url= "jdbc:mysql://localhost:3306/techChallengeDb?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "admin";
		try {
			Class.forName(driver).newInstance();
			this.conn = (Connection)DriverManager.getConnection(url,userName,password);
		}
		catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}
	
	/**
	 *
	 * @return MysqlConnect Database connection object
	 */
	public static synchronized MySQLConnection getDbCon() {
		if ( db == null ) {
			db = new MySQLConnection();
		}
		return db;

	}
	/**
	 *
	 * @param query String The query to be executed
	 * @return a ResultSet object containing the results or null if not available
	 * @throws SQLException
	 */
	public ResultSet query(String query) throws SQLException{
		statement = db.conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		return res;
	}
	/**
	 * Method to insert data to a table
	 * @param insertQuery String The Insert query
	 * @return boolean
	 * @throws SQLException
	 */
	public int insert(String insertQuery) throws SQLException {
		statement = db.conn.createStatement();
		int result = statement.executeUpdate(insertQuery);
		return result;

	}
}
