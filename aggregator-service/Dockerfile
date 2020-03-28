FROM openjdk:8

ADD target/aggregator-service-0.0.1-SNAPSHOT.jar aggregatorservice.jar

EXPOSE 8001

ENTRYPOINT ["java","-jar","aggregatorservice.jar"]