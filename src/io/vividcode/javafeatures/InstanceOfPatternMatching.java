package io.vividcode.javafeatures;

public class InstanceOfPatternMatching {
  void oldWay(Object obj) {
    if (obj instanceof String) {
      String str = (String) obj;
      System.out.println(str.length());
    }
  }

  void patternMatching(Object obj) {
    if (obj instanceof String str) {
      System.out.println(str.length());
    }
  }

  public static void main(String[] args) {
    InstanceOfPatternMatching instanceOfPatternMatching = new InstanceOfPatternMatching();
    instanceOfPatternMatching.oldWay("Hello");
    instanceOfPatternMatching.oldWay(100);
    instanceOfPatternMatching.patternMatching("Hello");
    instanceOfPatternMatching.patternMatching(100);
  }
}
