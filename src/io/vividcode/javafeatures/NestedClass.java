package io.vividcode.javafeatures;

import io.vividcode.javafeatures.NestedClass.LevelOne.LevelTwo;
import java.util.Arrays;

public class NestedClass {
  static class LevelOne {
    private String str = "Hello world";

    private void doSomething() {
      System.out.println("Level 1");
    }

    static class LevelTwo {
      private void doSomething() throws Exception {
        LevelOne levelOne = new LevelOne();
        levelOne.doSomething();
        String value = (String) LevelOne.class.getDeclaredField("str").get(levelOne);
        System.out.println(value);
        System.out.println("Level 2");
      }
    }
  }

  public void doSomething() throws Exception {
    new LevelTwo().doSomething();
  }

  public static void main(String[] args) throws Exception {
    new NestedClass().doSomething();
    System.out.println(Arrays.toString(NestedClass.class.getNestMembers())); // 输出3个类
  }
}
