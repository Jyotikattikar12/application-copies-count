package com.flexera.application;

import java.io.IOException;

/**
 * 
 * Base class for processing the CSV files to analyze the number of application copies purchases required
 * 
 * @author jyoti.bandi
 *
 */
public abstract class ApplicationPurchase {	
	
	protected static final String CSV_SPLIT_BY = ",";	
	protected String applicationId;
	protected String csvFile;
	
	public ApplicationPurchase(String applicationId, String csvFile) {
		this.applicationId = applicationId;
		this.csvFile = csvFile;
	}
	
	/**
	 * Method to count the number of application copies required by processing each row of the csv file.
	 *  
	 * @param csvFile - CSV File to be parsed
	 * @return application copies count
	 * @throws IOException
	 */
	public abstract int countApplicationCopies(String csvFile) throws IOException;
	
}
	
