FROM openjdk:8

WORKDIR /order-service

COPY target/order-service-0.0.1-SNAPSHOT.jar /order-service

EXPOSE 8082

ENTRYPOINT ["java","-jar","/order-service/order-service-0.0.1-SNAPSHOT.jar"]