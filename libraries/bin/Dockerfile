FROM maven:3-amazoncorretto-21
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn package
EXPOSE 8082
