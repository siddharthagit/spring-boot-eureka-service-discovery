
# Spring Boot RESTTemplate Project

This project contains Spring Boot consumer microservice which consumes 
article microservices offered by ms-aritle-service project by using Netflix Feign Client as well as Eureka Ribbon client.
This consumer service it self exposes REST API's and demostrate how to discover and invoke other services by utilizing Discovery Service,

##REST API URL's
Following are the list of REST API's built in this project

- GET  /render 	   (Using Netflix Ribbon Client)
- GET  /v2/render (Using Netflix Feign Client)

## Build Project

```sh
cd ms-consumer-service
mvn install
mvn spring-boot:run
```

## Invoking the REST API's
GET http://localhost:9053/render

```yaml
List of Articles
 Repo 1::America Travel
 Repo 2::Asia Travel
 Repo 3::Europe Travel
 Repo 4::Road Trip
 Repo 5::Winter Travel
 Repo 6::Japan Travel
 ```


GET http://localhost:9053/v2/render

```yaml
[
  {
    "id": "America-Travel",
    "name": "America Travel",
    "summary": null,
    "description": "Places to travel in AmericaLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
    "category": "Travel"
  }
]
```

## License
[MIT](LICENSE)
