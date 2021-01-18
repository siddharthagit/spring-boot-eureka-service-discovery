package com.siddb.model;

/**
 * Model Class to represent Article
 */
public class Article {
  private String id;
  private String name;
  private String description;
  private String category;

  public Article() {

  }

  public Article(String name, String category, String description) {
    this.id = name.replace(" ", "-");
    this.name = name;
    this.category = category;
    this.description = description
        + "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt "
        + "ut labore et dolore magna aliqua. "
        + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        + " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum "
        + "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
        + "sunt in culpa qui officia deserunt mollit anim id est laborum";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "name= " + this.name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

}
