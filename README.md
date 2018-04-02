Used Spring Style design pattern. Used Maven 

Entity classes are Pizza and Order which could later be made into Hibernate @Entity classes that correspond with Tables in a 
database. Currently, orders are stored in a text file.
I Assumed every order had only one pizza. 
Created Spring REST API and added ability to order Pizza through the API using a post method. 

<strong>RUNNING INSTRUCTIONS</strong>
<div>To run jar navigate to main folder then type:</div>
java -jar demo-1.jar. This will run program and start server.
http://localhost:8080/getorders to see all orders on file.
http://localhost:8080/saveorder to order pizza. USE POSTMAN and POST METHOD!
<div>Running Tests:</div>
<div>Type <em>mvn clean install</em> Then type <em>mvn test</em></div>
