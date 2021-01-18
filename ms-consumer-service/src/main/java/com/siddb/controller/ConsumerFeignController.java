package com.siddb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.siddb.models.Article;

@RestController
public class ConsumerFeignController {

  @Autowired
  private FeignArticleClient articleClient;
  /**
   * This method calls the microservice GET article-service/api/articles but uses Feign to make the
   * calls and returns the list of Articles in the response in JSON format
   * @return
   * @throws Exception
   */
  @RequestMapping(value = {"v2/render"}, method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Article>> render() throws Exception {
    // Get the list of articles using Feign Client for Article
    List<Article> articles = this.articleClient.getArticles();
    return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
  }

}
