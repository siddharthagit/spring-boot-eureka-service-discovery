package com.siddb;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.siddb.controller.ArticleController;
import com.siddb.handler.AppException;
import com.siddb.handler.NotFoundException;
import com.siddb.model.Article;
import com.siddb.service.ArticleService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ArticleController.class, ArticleService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArticleControllerTest {

  @Mock
  ArticleService articleService;

  @InjectMocks
  private ArticleController controller;

  @BeforeAll
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void contextLoads() {}

  @Test
  public void test_get_article_success() throws AppException {
    when(articleService.getArticles()).thenReturn(new ArrayList<Article>());
    ResponseEntity<List<Article>> object = controller.getArticles();
    Assertions.assertEquals(HttpStatus.OK, object.getStatusCode(), "OK Status");
  }

  @Test
  public void test_article_not_found() throws AppException, NotFoundException {

    when(articleService.getByID("444"))
        .thenThrow(new NotFoundException("Article with id 444 Not Found"));

    try {
      ResponseEntity<Article> object = controller.getArticle("444");
      fail("should have thrown exception");
    } catch (NotFoundException nfe) {
      Assertions.assertEquals("Article with id 444 Not Found", nfe.getMessage());
    }
  }

}
