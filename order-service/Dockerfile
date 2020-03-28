FROM openjdk:8

ADD target/order-service-0.0.1-SNAPSHOT.jar orderservice.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","orderservice.jar"]