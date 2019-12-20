package io.vividcode.javafeatures;

public class TextBlock {

  public static void main(String[] args) {
    String xml = """
      <root>
        <a>Hello</a>
        <b>
          <c>
            <d>World</d>
          </c>
        </b>
      </root>
      """;

    String xml2 = """
      <root>
        <a>Hello</a>
        <b>
          <c>
            <d>World</d>
          </c>
        </b>
      </root>
    """;

    String longString = """
    hello \
    world \
    goodbye
    """;

    String names = """
    alex     \s
    bob      \s
    long name\s
    """;

    String formatted = """
      <person>
        <name>%s<name>
        <age>%d</age>
      </person>
      """.formatted("alex", 18);

    System.out.println(xml);
    System.out.println(xml2);
    System.out.println(longString);
    System.out.println(names);
    System.out.println(names.replaceAll(" ", "."));
    System.out.println(formatted);
  }
}
