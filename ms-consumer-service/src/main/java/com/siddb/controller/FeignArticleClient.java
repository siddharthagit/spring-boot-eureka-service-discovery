package com.siddb.controller;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.siddb.models.Article;

@FeignClient(name = "article-service-consumer")
public interface FeignArticleClient {
  @RequestMapping(method = RequestMethod.GET, value = "/api/articles")
  public List<Article> getArticles();

  @RequestMapping(method = RequestMethod.GET, value = "/api/articles/{ID}")
  public List<Article> getArticleByID(@PathVariable(value = "") String ID);
}