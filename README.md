# freshworks_assignment

The main JAR file has been created in java called freshworks.jar. This is the main package to be downloaded and used.
The 3 dependencies for this jar file are:
  jackson-annotations-2.9.8.jar
  jackson-core-2.9.8.jar
  jackson-databind-2.9.8.jar
  
To run the jar file with the dependencies, refer the link : https://timjansen.github.io/jarfiller/javabasics/jar/libraries.xhtml

The main class is the CDR class present in the freshworks.jar
  The key value pair I/O operations are done in this.
  The operations need to be selected during run-time, they are:
    1.CREATE
    2.READ
    3.DELETE
    
The suitable dats structure to store key value pair was a Hashmap <Key,JSONObject>.
As part of JSON object, 2 parameters are to be provided as an input during run time : Name and Age.
The JSON opject consists of a key value pair in the format - KEY : JSONObject [NAME : "Name", AGE : "Age", TIME CREATED : *Time at which the key value pair was created*]

The Singleton class is used to ensure single threaded operation.

Jackson API provides multiple approaches to working with JSON, including using binding annotations on POJO classes for simple use cases. 

The Java Program Files CRD.java , JSONObject.java and Singleton.java are also uploaded in the repository for your reference.
