package io.vividcode.javafeatures;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LocalVariableTypeInference {
  public void java10() {
    var str = "hello";
    var list = List.of("a", "b", "c");
    for (var value : list) {
      System.out.println(value);
    }
    for (var i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    Consumer<String> consumer = (var value) -> System.out.println(str);
    BiConsumer<String, String> biConsumer = (var v1, var v2) -> System.out.println(v1 + v2);
  }
}
