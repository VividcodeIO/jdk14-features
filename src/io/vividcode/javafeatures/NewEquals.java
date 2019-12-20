package io.vividcode.javafeatures;

import java.util.Objects;

public class NewEquals {
  private final String id;

  public NewEquals(String id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.id);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof NewEquals ne) && Objects.equals(this.id, ne.id);
  }

  public static void main(String[] args) {
    NewEquals newEquals1 = new NewEquals("Hello");
    NewEquals newEquals2 = new NewEquals("Hello");
    System.out.println(Objects.equals(newEquals1, newEquals2));
    System.out.println(Objects.equals(newEquals1, ""));
  }
}