package com.databaseframe.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	String path = System.getProperty("user.dir") + "//Config//Configration.properties";

	public ReadConfig() {

		prop = new Properties();

		File filepath = new File(path);
		try {
			FileInputStream fis = new FileInputStream(filepath);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public String getSelectStatement() {

		String selectstmt = prop.getProperty("Selectstatement");
		if (selectstmt != null)
			return selectstmt;
		else
			throw new RuntimeException("Select Statement Not Found In Properties File");
	}

	public String getInsertStatement() {

		String insertstmt = prop.getProperty("Insertstatement");
		if (insertstmt != null)
			return insertstmt;
		else
			throw new RuntimeException("Insert Statement Not Found In Properties File");
	}

	public String getUpdateStatement() {

		String updatestmt = prop.getProperty("Updatestatement");
		if (updatestmt != null)
			return updatestmt;
		else
			throw new RuntimeException("Update Statement Not Found In Properties File");
	}

	public String getDeleteStatement() {

		String deletestmt = prop.getProperty("Deletestatement");
		if (deletestmt != null)
			return deletestmt;
		else
			throw new RuntimeException("Delete Statement Not Found In Properties File");
	}

	public String getCreateStatement() {

		String createstmt = prop.getProperty("Createstatement");
		if (createstmt != null)
			return createstmt;
		else
			throw new RuntimeException("Create Statement Not Found In Properties File");
	}

}
