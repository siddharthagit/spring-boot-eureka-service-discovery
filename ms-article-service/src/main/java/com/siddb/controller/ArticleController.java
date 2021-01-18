package com.siddb.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.siddb.handler.AppException;
import com.siddb.handler.NotFoundException;
import com.siddb.model.Article;
import com.siddb.service.ArticleService;

/**
 * Controller which is used to CRUD operation on BlogStory objects. It uses @RestController, and
 * returns ResponseEntity<Article>
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

  private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

  @Autowired
  ArticleService articleService;

  @RequestMapping(value = {"/articles"}, method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Article>> getArticles() throws AppException {
    List<Article> articles = articleService.getArticles();
    return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
  }

  @RequestMapping(value = {"/articles/{id}"}, method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Article> getArticle(@PathVariable(value = "") String id)
      throws AppException, NotFoundException {
    Article articles = articleService.getByID(id);
    return new ResponseEntity<Article>(articles, HttpStatus.OK);
  }

  @RequestMapping(value = {"/articles"}, method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Article> addArticle(@RequestBody Article input) throws AppException {
    log.info("payload: " + input);
    articleService.add(input);
    return new ResponseEntity<Article>(input, HttpStatus.CREATED);
  }

  @RequestMapping(value = {"/articles/{id}"}, method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> deleteArticle(@PathVariable String id)
      throws AppException {
    log.info("payload: " + id);
    articleService.remove(id);
    return new ResponseEntity<String>(HttpStatus.OK);
  }


}
