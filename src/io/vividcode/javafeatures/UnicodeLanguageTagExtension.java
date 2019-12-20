package io.vividcode.javafeatures;

import java.time.temporal.WeekFields;
import java.util.Locale;

public class UnicodeLanguageTagExtension {

  public static void main(String[] args) {
    Locale locale = new Locale.Builder().setLocale(Locale.CHINA)
        .setExtension(Locale.UNICODE_LOCALE_EXTENSION, "fw-mon").build();
    System.out.println(WeekFields.of(locale).getFirstDayOfWeek()); // MONDAY
  }
}
