FROM openjdk:11


ADD target/portfolioapi-0.0.1-SNAPSHOT.jar portfolioapi-0.0.1-SNAPSHOT.jar

ENTRYPOINT  ["java", "-jar", "/portfolioapi-0.0.1-SNAPSHOT.jar"]