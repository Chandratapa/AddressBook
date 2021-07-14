Installation and Getting Started

I have created a docker image for the spring boot application using the the Dockefile
Please run the docker image using the below command to access the AddressBook Application

docker run -p{any_port}:8080 addressbook-server:latest


For accessing the REST API'server

1. We need JWT authorization token which we can get by calling the post api "authenticate" (http://localhost:{any_port}/authenticate), pass username and password in the body
For simplicity I have hard coded the username and password in application.properties file instead of reading from a database and havent used any passcode encoder

2. We need to use the JWT token generated in step 1 to access the remaining api's whose description can be found  using the url
http://localhost:{any_port}/swagger-ui.html

I have also uploaded the postman collection in github  Reece.postman_collection.json
Example for authorization header key- value is shown below
Key = Authorization
Value = Bearer jwttoken


Please note I wanted to usek lombok dependency but I was facing some issue with the lombok plugins in Eclipse IDE, hence used the simple getter and setter methods instead.
I kept the code related to lombok commented out in the project.







