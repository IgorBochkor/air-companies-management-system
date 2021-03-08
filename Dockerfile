FROM java:8
VOLUME /tmp
EXPOSE 8086
ADD target/airplane-company-demo-0.0.1-SNAPSHOT.jar airplane-company-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "airplane-company-demo-0.0.1-SNAPSHOT.jar"]
