package solid.ex1;

import java.util.List;

public class ShapesPrinter {

    private final AreaCalculator areaCalculator;

    public ShapesPrinter(AreaCalculator areaCalculator) {
        this.areaCalculator = areaCalculator;
    }

    public String json(List<Shape> shapes) {
        return String.format("{shapes sum: %s}", areaCalculator.sum(shapes));
    }

    public String cvs(List<Shape> shapes) {
        return String.format("{shapes_sum, %s}", areaCalculator.sum(shapes));
    }
}
