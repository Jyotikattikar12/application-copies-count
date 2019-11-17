package com.flexera.application;

import java.io.IOException;

/**
 * @author jyoti.bandi
 *
 */
public class ApplicationPurchaseFactory {
		
	public int countApplicationCopies(String applicationId , String csvFile) throws IOException {
		int appCopiesNum = 0;
		
		// Based on the applicationID get the instance of the right class
		if(applicationId.equals("374")) {
			ApplicationPurchase applicationPurchase = new Application374Purchase( applicationId ,  csvFile);
			appCopiesNum = applicationPurchase.countApplicationCopies(csvFile);
		}
		return appCopiesNum; 
	}	
}
