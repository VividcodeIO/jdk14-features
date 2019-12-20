package io.vividcode.javafeatures;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpsConnection {

  public static void main(String[] args) throws IOException {
    try(InputStream inputStream = new URL("https://github.com").openStream()) {
    }
  }
}
