The project developer-code-test keeps the count on number of application copies 
The application has used Factory design pattern.
"resources" folder already contains the sample-small.csv

ApplicationPurchaseFactoryTest.java contains the unit cases for the examples given in the "developer code test.pdf"

Command to build the application
mvn clean install

Command to run the application
java -jar target/developer-code-test-0.0.1-SNAPSHOT.jar

NOTE: Due to github upload size limit, could not upload sample-large.csv. Follow the following instructions to upload and test the same. 
1. Upload the CSV at the src/main/resources
2. Replace the file name "sample-small.csv" with "sample-large.csv" in  CountApplicationPurchaseUtil.java 
3. mvn clean install
4. java -jar target/developer-code-test-0.0.1-SNAPSHOT.jar