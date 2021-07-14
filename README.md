Installation and Getting Started


1. Clone the project and open a terminal at the root of the project.
2. run the below commands
	1. For building the jar file  -> mvn clean package
	2. For building the docker image -> docker-compose build 
    3. Start the docker container using -> docker-compose up -d

3. I have already created a docker image for the application
    To download the image please click on the below url
    https://rimibucket88.s3.amazonaws.com/addressbook-server.tar
    Start the docker container using -  docker-compose up -d


For accessing the REST API'server

1. We need JWT authorization token which we can get by calling the post api "authenticate" (http://localhost:{any_port}/authenticate), pass username and password in the body
For simplicity I have hard coded the username and password in application.properties file instead of reading from a database and havent used any passcode encoder

2. We need to use the JWT token generated in step 1 to access the remaining api's whose description can be found  using the url
http://localhost:{any_port}/swagger-ui.html

Example for authorization header key- value is shown below
Key = Authorization
Value = Bearer jwttoken
I have also attached the postman collection in the email -  Reece.postman_collection.json

Please note I wanted to usek lombok dependency but I was facing some issue with the lombok plugins in Eclipse IDE, hence used the simple getter and setter methods instead.
I kept the code related to lombok commented out in the project.







