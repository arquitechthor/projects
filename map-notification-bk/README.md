# Map Notification (Backend)
This microservice send emails and using Kakfa with an Hexagonal Architecture

### How to run

Download
$ git clone https://github.com/arquitechthor/map-notification-bk.git

Install & Run
You can use maven wrapper from Spring Initializr:

$ ./mvnw clean spring-boot:run

Also you can use docker for running the project:

docker build -t notification .

then

docker run -p 8001:8001 notification

### Technologies
- Spring Boot: 3.2.2
- Java 21