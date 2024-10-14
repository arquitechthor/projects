# HexaShop.Backend
eShop exercise with Spring Boot, Hexagonal Architecture, Java 21 and H2

### Download
> $ git clone https://github.com/arquitechthor/HexaShop.Backend.git

### Install & Run
You can use maven wrapper from Spring Initializr, but will need Java 21 for run:
> $ ./mvnw clean spring-boot:run

Also you can use docker for running the project:
> docker build -t hexashop .

then
> docker run -p 9000:9000 hexashop

# Let's Test
You can run unit test in the project. But here you
have some JSON valid examples to consume the API.

The Endpoint. Method **POST**.
> http://localhost:9000/api/v1/price

### Example 1
Request
>``` 
>{
>    "brandId": 1,
>    "productId": 35455,
>    "applicationDate": "2020-06-14T10:00:00.000Z"
>}
> ```
Response
>``` 
>{
>    "productId": 35455,
>    "brandId": 1,
>    "priceList": 1,
>    "applicationDate": "2020-06-14T10:00:00",
>    "price": 35.5
>}
> ```

### Example 2

Request
>``` 
>{
>    "brandId": 1,
>    "productId": 35455,
>    "applicationDate": "2020-06-14T16:00:00.000Z"
>}
> ```
Response
>``` 
>{
>    "productId": 35455,
>    "brandId": 1,
>    "priceList": 2,
>    "applicationDate": "2020-06-14T16:00:00",
>    "price": 25.45
>}
> ```

### Example 3

Request
>``` 
>{
>    "brandId": 1,
>    "productId": 35455,
>    "applicationDate": "2020-06-14T21:00:00.000Z"
>}
> ```
Response
>``` 
>{
>    "productId": 35455,
>    "brandId": 1,
>    "priceList": 1,
>    "applicationDate": "2020-06-14T21:00:00",
>    "price": 35.5
>}
> ```


### Example 4

Request
>``` 
>{
>    "brandId": 1,
>    "productId": 35455,
>    "applicationDate": "2020-06-15T10:00:00.000Z"
>}
> ```
Response
>``` 
>{
>    "productId": 35455,
>    "brandId": 1,
>    "priceList": 3,
>    "applicationDate": "2020-06-15T10:00:00",
>    "price": 30.5
>}
> ```

### Example 5

Request
>``` 
>{
>    "brandId": 1,
>    "productId": 35455,
>    "applicationDate": "2020-06-16T21:00:00.000Z"
>}
> ```
Response
>``` 
>{
>    "productId": 35455,
>    "brandId": 1,
>    "priceList": 4,
>    "applicationDate": "2020-06-16T21:00:00",
>    "price": 38.95
>}
> ```

Error Cases

### Bad Request

Request
>``` 
>{
>    "brandId": q,
>    "productId": 35455,
>    "applicationDate": "2020-06-16T21:00:00.000Z"
>}
> ```
Response
>``` 
>{
>    {
>    "type": "about:blank",
>    "title": "Bad Request",
>    "status": 400,
>    "detail": "Failed to read request",
>    "instance": "/api/v1/get-price"
>}
> ```