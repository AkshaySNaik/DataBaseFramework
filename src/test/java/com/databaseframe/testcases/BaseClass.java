package com.databaseframe.testcases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.databaseframe.utilities.ReadConfig;

public class BaseClass {

	ReadConfig cofig = new ReadConfig();
	String CallSelectStatement = cofig.getSelectStatement();
	String CallInsertStatement = cofig.getInsertStatement();
	String CallUpdateStatement = cofig.getUpdateStatement();
	String CallDeleteStatement = cofig.getDeleteStatement();
	String CallCreateStatement = cofig.getCreateStatement();

	public static Connection connection;
	public static Statement statement;
	public static ResultSet resultset;
	public static Logger log;
	public static SoftAssert asert;
	public static PreparedStatement prepstatm;

	@BeforeClass
	public void setUp() {

		try {

			log = LogManager.getLogger(BaseClass.class.getName());

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			log.info("Connected To Oracle DataBase Successfully");

		} catch (SQLException e) {

			log.info("Failed To Connect To DataBase");
			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			log.info("Failed To Connect To DataBase");
			e.printStackTrace();
		}

	}

	// Stored Function Utility File
	public boolean compareResultSets(ResultSet resultset1, ResultSet resultset) throws SQLException {

		while (resultset1.next()) {

			resultset.next();
			int count = resultset1.getMetaData().getColumnCount();
			for (int i = 1; i <= count; i++) {
				if (!StringUtils.equals(resultset1.getString(i), resultset.getString(i))) {

					return false;
				}
			}
		}
		return true;
	}

	@AfterClass
	public void tearDown() {

		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
