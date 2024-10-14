FROM openjdk:17-alpine
RUN apk add --no-cache maven
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY src ./src
RUN mvn package
EXPOSE 9000
CMD ["java", "-jar", "target/eshop-0.0.1-SNAPSHOT.jar"]