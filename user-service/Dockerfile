FROM openjdk:8

ADD target/user-service-0.0.1-SNAPSHOT.jar userservice.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","userservice.jar"]