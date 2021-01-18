
# Micro Service for Author Domain
Contains Article REST API as microservices, which can be used to perform CRUD operations
on Article Objects. The microservices are registered with Netflix Eureka discovery server, so that clients can discover them.
 
## Service Name
The microservice will be registered as article-service in the Eureka Discover Server.
This is defined in bootstrap.properties file

```sh
spring.application.name=article-service

```

##REST API's
Following are the list of REST API's built in this project

- GET  http://localhost:9051/api/articles
- GET  http://localhost:9051/api/articles/ARTICLE_ID
- POST  http://localhost:9051/api/articles PAYLOAD
- DELETE  http://localhost:9051/api/articles/ARTICLE_ID


## Build Project
```sh
cd microservice-article-api
mvn install
mvn spring-boot:run
```

## License
[MIT](LICENSE)
