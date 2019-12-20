package io.vividcode.javafeatures;

public class PointMain {
  record Point(int x, int y) {
    public Point {
      this.x = Math.max(x, 0);
      this.y = Math.max(y, 0);
    }
  }

  public static void main(String[] args) {
    Point point = new Point(10, -1);
    System.out.println(point.x());
    System.out.println(point.y());
  }
}