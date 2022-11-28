package com.databaseframe.testcases;

import org.testng.annotations.Test;

public class TC004_UpdateDataTest extends BaseClass {

	@Test
	public void updateTest() throws InterruptedException {

		try {

			statement = connection.createStatement();
			resultset = statement.executeQuery(CallUpdateStatement);
			Thread.sleep(2000);

			resultset = statement.executeQuery(CallSelectStatement);
			while (resultset.next()) {

				String deptname = resultset.getString("DNAME");
				String dptno = resultset.getString("DEPTNO");

				if (deptname.equalsIgnoreCase("JJJJJ") && dptno.equalsIgnoreCase("97")) {
					log.info("Update Test Passed");
					break;
				}
			}

		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

}
