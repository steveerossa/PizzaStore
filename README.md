Used Spring Style design pattern. Used Maven 
<strong>RUNNING INSTRUCTIONS</strong>
<div>To run jar navigate to main folder then type:</div>
<strong>java -jar pizzastore.jar <yourfileName.txt>. </strong>This will run program and start server.
Output will be written to text file you provided

Entity classes are Pizza and Order which could later be made into Hibernate @Entity classes that correspond with Tables in a 
database. Currently, orders are stored in a text file.
I Assumed every order had only one pizza. 
Created Spring REST API and added ability to order Pizza through the API using a post method. 


http://localhost:8080/getallorders to see all orders on file.
http://localhost:8080/saveorder to order pizza. USE POSTMAN and POST METHOD!
<div>Running Tests:</div>
Build project using Maven.
<div>Type <em>mvn clean install</em> Then type <em>mvn test</em></div>
