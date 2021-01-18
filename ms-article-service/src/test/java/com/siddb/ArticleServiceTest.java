package com.siddb;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.siddb.handler.AppException;
import com.siddb.handler.NotFoundException;
import com.siddb.model.Article;
import com.siddb.service.ArticleService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ArticleService.class})
public class ArticleServiceTest {

  @Autowired
  ArticleService service;

  @Test
  public void test_get_article() {
    try {
      List<Article> list = service.getArticles();
      Assertions.assertNotNull(list, "list should not be null");
    } catch (AppException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void test_get_article_with_id() throws NotFoundException {
    try {
      Article data = service.getByID("Winter_Skiing");
      Assertions.assertNotNull(data, "data should not be null");
    } catch (AppException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
