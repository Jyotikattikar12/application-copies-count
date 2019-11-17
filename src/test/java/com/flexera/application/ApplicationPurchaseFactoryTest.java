package com.flexera.application;

import static org.junit.Assert.assertSame;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ApplicationPurchaseFactoryTest {

	private static String FILE_PATH = ".//src//test//resources//";
	String applicationId = "374";
		
		
	@Test
	public void testCheckNumPuchasesFromEmail() {
		String csvFile = FILE_PATH + "sample-8.csv";
		ApplicationPurchase applicationPurchase = new Application374Purchase( applicationId ,  csvFile);		
		
		
		Map<String, Map<String, String>> userCompApp = new HashMap<>();
		int copiesNum = 1;			 
		int applicationPurchaseCount = 0;
		
		Map<String, String> compApp = new HashMap<>();
		compApp.put("1", "LAPTOP");
		userCompApp.put("1",compApp);
		String [] row = {"2","1","374","DESKTOP","Exported from System A" };
		applicationPurchaseCount = ((Application374Purchase) applicationPurchase).checkNumPuchases(row, userCompApp, copiesNum);
		assertSame(1, applicationPurchaseCount);	
		
		userCompApp = new HashMap<>();
		compApp = new HashMap<>();
		compApp.put("1", "LAPTOP");
		compApp.put("2", "DESKTOP");		
		userCompApp.put("1",compApp);
		Map<String, String> compApp1 = new HashMap<>();
		compApp1.put("3", "DESKTOP");
		userCompApp.put("2",compApp1);
		String [] row1 = {"4","2","374","DESKTOP","Exported from System A" };
		copiesNum = 2;
		applicationPurchaseCount = ((Application374Purchase) applicationPurchase).checkNumPuchases(row1, userCompApp, copiesNum);
		assertSame(3, applicationPurchaseCount);
		
		userCompApp = new HashMap<>();
		compApp = new HashMap<>();
		compApp.put("1", "LAPTOP");;
		userCompApp.put("1",compApp);
		compApp1 = new HashMap<>();
		userCompApp.put("2",compApp1);
		compApp.put("2", "DESKTOP");
		String [] row3 = {"2",  "2","374", "desktop", "Exported from System A"};
		copiesNum = 2;
		applicationPurchaseCount = ((Application374Purchase) applicationPurchase).checkNumPuchases(row3, userCompApp, copiesNum);
		assertSame(2, applicationPurchaseCount);
		
	}
	
	

}
