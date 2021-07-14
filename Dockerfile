FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/addressbook-0.0.1-SNAPSHOT.jar addressbook-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/addressbook-server-1.0.0.jar"]