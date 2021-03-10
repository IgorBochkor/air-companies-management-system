FROM openjdk:11-oracle
ADD target/airplane-company-demo-0.0.1-SNAPSHOT.jar airplane-company-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "airplane-company-demo-0.0.1-SNAPSHOT.jar"]
