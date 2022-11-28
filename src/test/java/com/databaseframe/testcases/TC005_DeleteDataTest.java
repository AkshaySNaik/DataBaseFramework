package com.databaseframe.testcases;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_DeleteDataTest extends BaseClass {

	@Test
	public void deleteTest() throws InterruptedException {

		try {
			statement = connection.createStatement();
			statement.executeQuery(CallDeleteStatement);

			resultset = statement.executeQuery(CallSelectStatement);
			Thread.sleep(2000);

			while (resultset.next()) {

				String dname = resultset.getString("DNAME");

				if (dname.equalsIgnoreCase("JJJJJ")) {

					Assert.fail();
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
