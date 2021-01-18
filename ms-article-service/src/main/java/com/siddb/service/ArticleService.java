package com.siddb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.siddb.handler.AppException;
import com.siddb.handler.NotFoundException;
import com.siddb.model.Article;

/**
 * Service Class to create, retrieve different Objects
 */
@Service
public class ArticleService {

  HashMap<String, Article> stories = new HashMap<String, Article>();
  {
    stories.put("Winter_Skiing",
        new Article("Winter Travel", "Winter_Skiing", "Winter Skiing Blog"));
    stories.put("Road_Trip", new Article("Road Trip", "Road Trip", "Amazing Road trip"));
    stories.put("Asia_Travel", new Article("Asia Travel", "Travel", "Places to visit in Asia"));
    stories.put("Europe_Travel",
        new Article("Europe Travel", "Travel", "Places to visit in Europe"));
    stories.put("Japan_Travel", new Article("Japan Travel", "Travel", "Places to visit in Japan"));
    stories.put("America_Travel",
        new Article("America Travel", "Travel", "Places to travel in America"));
  }

  public List<Article> getArticles() throws AppException {
    return new ArrayList<Article>(stories.values());
  }

  public Article getByID(String id) throws AppException, NotFoundException {
    Article ret = stories.get(id);
    if (ret == null)
      throw new NotFoundException("Article with id " + id + " Not Found");
    return ret;
  }

  public void add(Article newStory) throws AppException {
    if (newStory == null)
      throw new AppException("Article cannot be null");
    this.stories.put(newStory.getId(), newStory);;
  }

  public void remove(String id) throws AppException {
    if (id == null)
      throw new AppException("Article cannot be null");
    this.stories.remove(id);
  }

  public List<String> getData() throws AppException {
    throw new AppException("Method Discontinued");
  }

}
