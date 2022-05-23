package designpatterns.factory;

public class Subtract implements Calculate {

    @Override
    public void calculate(double number1, double number2) {
        System.out.println(String.format("%f minus by %f is %f", number1, number2, number1 - number2));
    }
}
