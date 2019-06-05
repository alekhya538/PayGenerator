# PayGenerator

Prerequisite:

1. Eclipse
2. Apache Tomcat 7
3. Maven
4. Copy the given settings.xml to C:/Users/XXX/.m2/
5. Working internet connection for the maven to download all dependencies



Usage:

1. Import the supplied maven project to eclipse (PayGenerator/)
2. Create & configure Tomcat server (install directory, ports to use etc.)
3. Deploy the web application (Right-Click on project and Run As -> Run on Server)
4. Open a browser and navigate to “http://localhost:8080/
5. Enter input file in the text box (default path pre-populated)
6. Click on button “Generate Pay Details”
7. Employee Income details are displayed in a new page in a table
8. The same details are also saved as a CSV in below location,
	C:/dev/myob/PayGenerator/output/
	File name contains timestamp, to avoid unwanted overwrites.


Assumptions:

1. Solution assumes that the input CSV has correct no. of fields and in pre-defined order (first name,last name,annual salary,super rate,payment start date)
2. Output CSV is generated in below location,
C:/dev/myob/PayGenerator/output/empPayDetails_20190604134310.csv
3. Output files contain timestamp in name, so as to not overwrite file for every execution.



