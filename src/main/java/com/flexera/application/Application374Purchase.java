package com.flexera.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * SubClass to process rows with Application ID 374. 
 * 
 * @author jyoti.bandi
 *
 */
public class Application374Purchase extends ApplicationPurchase{
	
	private static final String APPLICATION_ID = "374";
	
	public Application374Purchase(String applicationId, String csvFile) {
		super(applicationId, csvFile);
	}


	
	/**
	 * Method to count the number of application copies required by processing each row of the csv file.
	 * The Datastructure used while processing is Map<UserId, Map<<ComputerId>,<ApplicationType>>
	 *  
	 * @param csvFile
	 * @return
	 */
	public int countApplicationCopies(String csvFile) throws IOException {
		
		BufferedReader br = null;
		String line = "";
		int copiesNum = 0;
		
		Map<String, Map<String, String>> userCompApp = new HashMap<>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();			
			
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] computerDetails = line.split(CSV_SPLIT_BY);	

				copiesNum = checkNumPuchases (computerDetails, userCompApp, copiesNum);
			}

		} catch (Exception e) {
			System.out.println("Exception while processing the file: " + e.getMessage());
			throw e;
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("Exception while closing the reader: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}		

		return copiesNum;
	}
	
	/**
	 * Method to count the number of each application copies by processing each row of the csv file
	 * 
	 * @param computerDetails - Individual row of the CSV file
	 * @param compAppMap - Collection to hold the processed row data Key as UserId and Map <<computerId>,<ApplicationType>> as value
	 * @param copiesNum -  application copies count
	 * @return application copies count
	 */
	public int checkNumPuchases(String[] computerDetails, Map<String, Map<String, String>> userCompApp, int copiesNum){
		// If the row's ApplicationID  matches with the configured value
		if( computerDetails[2].equals(APPLICATION_ID)) {
			
			// If there is no key with UserID then create the map entry and increase the application copies numbers
			if( !userCompApp.containsKey(computerDetails[1])) {				
				Map<String, String> compApp = new HashMap<>();
				compApp.put(computerDetails[0], computerDetails[3]);
				userCompApp.put(computerDetails[1],compApp);
				copiesNum++ ;
			} else {
				// UserID exists, Check if computerId exists, if exists Ignore 
				Map<String, String> compApp = userCompApp.get(computerDetails[1]);
				
				if( !compApp.containsKey(computerDetails[0])) {
					
					Set<String> computerId = compApp.keySet();
					Iterator<String> iterator = computerId.iterator();	
					// Check if Computer Type exists, if so increase the copies number
					while(iterator.hasNext()) {
						String computerType = compApp.get(iterator.next());
						if(computerType.equalsIgnoreCase(computerDetails[3])) {
							copiesNum++ ;
						}
					}
					// As new ComputerId, make the CompId and Computer Type entry
					compApp.put(computerDetails[0], computerDetails[3]);
				}				
			}
		}		
		return copiesNum;
	}
}
