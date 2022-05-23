package solid.ex1;

import java.util.List;

public class AreaCalculatorImpl implements AreaCalculator {
    
    @Override
    public double sum(List<Shape> shapes) {
        double sum = shapes.stream().mapToDouble(Shape::area).sum();

        return sum;
    }
}
