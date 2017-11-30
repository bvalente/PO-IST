package editor;

import editor.core.Editor;
import editor.core.Line;
import editor.core.Circle;
import editor.core.Square;

public class Test {

  public static void main(String[] args) {
    Editor editor = new Editor();

    Square sq = new Square(editor, 4, 5, 20);
    Line li = new Line(editor, 2, -4, 34, 40);
    Circle ci = new Circle(editor, 0, 0, 30);

    System.out.println(sq.draw());
    System.out.println(li.draw());
    System.out.println(ci.draw());

    sq.move(5, 6);
    li.move(5, 6);
    ci.move(5, 6);

    System.out.println(sq.draw());
    System.out.println(li.draw());
    System.out.println(ci.draw());
  }
}
