package io.vividcode.javafeatures;

public class SwitchExpressions {
  void printDays(int days) {
    switch (days) {
      case 0 -> System.out.println("None");
      case 1 -> System.out.println("1 day");
      default -> System.out.println(days + " days");
    }
  }

  void printDays2(int days) {
    String output = switch (days) {
      case 0 -> "None";
      case 1 -> "1 day";
      default -> days + " days";
    };
    System.out.println(output);
  }

  void printDays3(int days) {
    String output = switch (days) {
      case 0 -> "None";
      case 1 -> "1 day";
      default -> {
        if (days > 10) {
          yield "too many days";
        } else {
          yield days + " days";
        }
      }
    };
    System.out.println(output);
  }

  void switchWithEnum(Color color) {
    String output = switch (color) {
      case RED -> "R";
      case BLUE -> "B";
      case GREEN -> "G";
    };
    System.out.println(output);
  }

  public static void main(String[] args) {
    SwitchExpressions switchExpressions = new SwitchExpressions();
    switchExpressions.printDays(0);
    switchExpressions.printDays(1);
    switchExpressions.printDays(3);
    switchExpressions.printDays2(0);
    switchExpressions.printDays2(1);
    switchExpressions.printDays2(3);
    switchExpressions.printDays3(0);
    switchExpressions.printDays3(1);
    switchExpressions.printDays3(3);
    switchExpressions.printDays3(15);
    switchExpressions.switchWithEnum(Color.BLUE);
  }

  public enum Color {
    RED, GREEN, BLUE
  }
}
