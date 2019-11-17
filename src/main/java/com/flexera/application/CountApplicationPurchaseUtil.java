package com.flexera.application;

import java.io.IOException;

public class CountApplicationPurchaseUtil {

	protected static final String FILE_PATH = ".\\src\\main\\resources\\";
	private static ApplicationPurchaseFactory applicationPurchaseFactory = new ApplicationPurchaseFactory();
	
	private static void processCSVFile(String csvFile) {
		int appCopiesNum;
		try {
			System.out.println("Processing " + csvFile + " started");
			long startTime = System.currentTimeMillis();
			appCopiesNum = applicationPurchaseFactory.countApplicationCopies("374",FILE_PATH + csvFile);
			System.out.println("Total Processing Duration: " + (System.currentTimeMillis() - startTime) / 1000d + "s");
			System.out.println("CSV File : " + csvFile + " Number of Application copies purchase: " + appCopiesNum);
		} catch (IOException e) {
			System.out.println("IOException while processing the csv file: " + e.getLocalizedMessage());
		}
	}
	
	public static void main(String[] args) {
		String csvFile = "sample-small.csv";
		processCSVFile(csvFile);
	}
}
