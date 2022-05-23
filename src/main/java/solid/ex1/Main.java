package solid.ex1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var circle = new Circle(10);
        var square = new Square(10);
        var rectangle = new Rectangle(10, 10);
        var cube = new Cube();
        List<Shape> shapes = List.of(circle, square, rectangle, cube);

        AreaCalculator areaCalculator = new AreaCalculatorImpl();
        var areaCalculator2 = new AreaCalculatorImpl2();
        var printer = new ShapesPrinter(/*areaCalculator*/ areaCalculator2);
        System.out.println("Sum: " + printer.json(shapes));
        System.out.println("Sum: " + printer.cvs(shapes));

    }
}
