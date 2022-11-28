package com.databaseframe.testcases;

import java.sql.SQLException;

import org.testng.annotations.Test;

public class TC002_RetriveSingleDataTest extends BaseClass {

	@Test
	public void sigleDataTest() {

		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery(CallSelectStatement);

			while (resultset.next()) {

				String detno = resultset.getString("DEPTNO");
				String dname = resultset.getString("DNAME");
				String locat = resultset.getString("LOC");

				log.info(detno + "     " + dname + "      " + locat);

				if (dname.contains("ACCOUNTING")) {

					log.info("Test Case Passed :" + dname);
				}
				// Assert.assertEquals(name.contains("ACCOUNTING"), true);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
