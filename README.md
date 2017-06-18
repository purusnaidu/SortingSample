Technology stack used:
1) JDK 1.8.0_131   (separate installation required)
2) apache-maven-3_5_0 (separate installation required)
3) angular 1.6.4
4) junit
5) H2 Embeded DB
6) Springboot JPA
7) Dozer

Setup Instructions:
1) import the shared project as maven project in eclipse
2) Add "src/main/resources/config" folder to classpath.
  (Project Properties-> Java build path -> Libraries -> Add Class Folder -> Select the config path)
3) Resolve if any other build path errors.
4) From Eclipse, Perform maven install.
5) If lib references are not updated then run "Maven -> Update project".

Execution instruction:
1) Run Application.Java to start the application.
2) Access the application UI using url from browser.(http://localhost:8080/)
3) Run as "Junit Test" the TestSortingServices.Java to run a sample unit test case.

User Guide:
1) In the Input field "Enter the numbers as Comma Separated Value" and Click Sort to see the result below.
2) Errors are also displayed using the same table.

Coding:
1)Coding has been done using multi-tier architecture.
   Sorting UI -> Service Controller -> NumberSorting Service -> DAO -> DB
