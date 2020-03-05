package java_0305.shape;

import java.rmi.ConnectIOException;

public class Test {
    public static void main(String[] args) {
//        Shape shape = new Circle();
//        shape.draw();
//
//        shape = new Rect();
//        shape.draw();
//
//        shape = new Flower();
//        shape.draw();
        drawShapes2();
    }

    public static void drawShapes() {
        String[] shapes = {"circle", "rect", "circle", "rect", "flower"};

        for (String shape : shapes) {
            if (shape.equals("circle")) {
                Circle circle = new Circle();
                circle.draw();
            } else if (shape.equals("rect")) {
                Rect rect = new Rect();
                rect.draw();
            } else if (shape.equals("flower")) {
                Flower flower = new Flower();
                flower.draw();
            }
        }
    }

    public static void drawShapes2() {
        Shape[] shapes = {new Circle(), new Rect(), new Circle(), new Rect(), new Flower()};
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
