FROM openjdk:8

WORKDIR /aggregator-service

COPY target/aggregator-service-0.0.1-SNAPSHOT.jar /aggregator-service

EXPOSE 8001

ENTRYPOINT ["java","-jar","/aggregator-service/aggregator-service-0.0.1-SNAPSHOT.jar"]