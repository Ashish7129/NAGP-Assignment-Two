FROM openjdk:8

WORKDIR /user-service

COPY target/user-service-0.0.1-SNAPSHOT.jar /user-service

EXPOSE 8081

ENTRYPOINT ["java","-jar","/user-service/user-service-0.0.1-SNAPSHOT.jar"]