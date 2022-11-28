package com.databaseframe.testcases;

import org.testng.annotations.Test;

public class TC001_RetriveAllDataTest extends BaseClass {

	@Test
	public void trialRun() {

		try {
		    statement = connection.createStatement();
		    resultset = statement.executeQuery(CallSelectStatement);

			while (resultset.next()) {

				int empno = resultset.getInt("EMPNO");
				String ename = resultset.getString("ENAME");
				String jobes = resultset.getString("JOB");
				int mangr = resultset.getInt("MGR");
				String hiree = resultset.getString("HIREDATE");
				int salar = resultset.getInt("SAL");
				int commi = resultset.getInt("COMM");
				int depno = resultset.getInt("DEPTNO");
				
				log.info(empno+"    "+ename+"    "+jobes+"    "+mangr+"    "+hiree+"    "+salar+"    "+commi+"    "+depno);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
