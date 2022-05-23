package designpatterns.factory;

public class Divide implements Calculate {
    @Override
    public void calculate(double number1, double number2) {
        if (number2 == 0) {
            System.out.println("Division by 0 is undefined");
        } else {
            System.out.println(String.format("%f divided by %f is %f", number1, number2, number1 / number2));
        }

    }
}
