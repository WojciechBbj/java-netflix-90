package pl.yellowduck.netflix90.films;

import javax.persistence.Entity;
import javax.persistence.Id;

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
@Entity
public class Category {
  @Id
  private Integer id;
  private String name;
  private String description;

  private Category() {
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