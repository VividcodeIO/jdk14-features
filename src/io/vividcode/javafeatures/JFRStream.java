package io.vividcode.javafeatures;

import jdk.jfr.FlightRecorder;
import jdk.jfr.consumer.RecordingStream;

public class JFRStream {

  public static void main(String[] args) {
    try (var rs = new RecordingStream()) {
      FlightRecorder.getFlightRecorder().getEventTypes()
          .forEach(eventType -> rs.onEvent(eventType.getName(), System.out::println));
      rs.start();
    }
  }
}
