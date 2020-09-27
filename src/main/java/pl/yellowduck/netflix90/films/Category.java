package pl.yellowduck.netflix90.films;
/*
public enum Category {
  COMEDY, // orinal value 0

  FANTASY,

  DRAMA,  // orinal value 1

  HORROR, // orinal value 2

  MUSICAL, // orinal value 3

  ACTION; // orinal value 4
}
*/

public class Category {
  private Integer id;
  private String name;
  private String description;

  public Category() {
  }

  public Category(Integer id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return name;
  }
}