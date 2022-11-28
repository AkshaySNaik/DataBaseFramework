package com.databaseframe.testcases;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_InsetDataTest extends BaseClass {

	@Test
	public void insertData() throws InterruptedException {

		try {
			statement = connection.createStatement();

			statement.execute(CallInsertStatement);

			resultset = statement.executeQuery("Select * From Dept");

			while (resultset.next()) {

				String deptno = resultset.getString("DEPTNO");

				// Hard Assertion cannot Be Used in Iterative loops Since It Imm.throw Exception
				// asert = new SoftAssert();
				// asert.assertEquals(deptno, "79");

				if (deptno.equalsIgnoreCase("89")) {
					log.info("Inserted Data Test Passed :" + deptno);
					break;
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
