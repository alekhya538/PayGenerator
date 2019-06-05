# PayGenerator

Prerequisite

Eclipse
Apache Tomcat 7
Maven
Copy the given settings.xml to C:/Users/XXX/.m2/
Working internet connection for the maven to download all dependencies



Usage
•	Import the supplied maven project to eclipse (PayGenerator/)
•	Create & configure Tomcat server (install directory, ports to use etc.)
•	Deploy the web application (Right-Click on project and Run As -> Run on Server)
•	Open a browser and navigate to “http://localhost:8080/
•	Enter input file in the text box (default path pre-populated)
•	Click on button “Generate Pay Details”
•	Employee Income details are displayed in a new page in a table
•	The same details are also saved as a CSV in below location,
C:/dev/myob/PayGenerator/output/
	File name contains timestamp, to avoid unwanted overwrites.


Assumptions
•	Solution assumes that the input CSV has correct no. of fields and in pre-defined order (first name,last name,annual salary,super rate,payment start date)
•	Output CSV is generated in below location,
C:/dev/myob/PayGenerator/output/empPayDetails_20190604134310.csv
•	Output files contain timestamp in name, so as to not overwrite file for every execution.

