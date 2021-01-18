package com.siddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class ConsumerController {

  @Autowired
  private RestTemplate restTemplate;

  /**
   * This method calls the microservice GET article-service/api/articles using Ribbon to get list of
   * Articles and returns the same. it uses RestTemplate to make the api calls.
   * @return
   * @throws Exception
   */
  @RequestMapping(value = {"render"}, method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> renderArticles() throws Exception {
    JsonNode repos =
        restTemplate.getForObject("http://article-service-consumer/api/articles", JsonNode.class);

    int counter = 1;
    StringBuilder result = new StringBuilder("\n List of Articles");
    if (repos.isArray()) {
      for (JsonNode jsonNode : repos) {
        result.append("\n Repo ").append(counter++).append("::");
        result.append(jsonNode.get("name").asText());
      }
    }
    return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
  }
}
