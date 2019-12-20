package io.vividcode.javafeatures;

public class Records {
  record Pair(Object first, Object second) {}

  public static void main(String[] args) {
    Pair pair = new Pair("Hello", "World");
    System.out.println(pair.first());
    System.out.println(pair.second());
    System.out.println(pair);
  }
}
