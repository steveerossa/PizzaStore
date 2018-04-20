
Used Spring Style design pattern. Used Maven 

<strong>RUNNING INSTRUCTIONS</strong><br>
  To run jar navigate to main folder then type <br>
  <strong>java -jar pizzastore.jar yourfileName.txt. </strong> <br>
  This will run program and start server.
  Output will be written to text file you provided


Entity classes are Pizza and Order which could later be made into Hibernate @Entity classes that correspond with Tables in a 
database. Currently, orders are stored in a text file.
I Assumed every order had only one pizza. 
Created Spring REST API and added ability to order Pizza through the API using a post method. 


http://localhost:8080/getallorders to see all orders on file.
http://localhost:8080/saveorder to order pizza. USE POSTMAN and POST METHOD!
<div>Running Tests:</div>
Build project using Maven.
To build and run tests.
<div>Type <strong>mvn clean install</strong> Then type <strong>mvn test</strong></div>
