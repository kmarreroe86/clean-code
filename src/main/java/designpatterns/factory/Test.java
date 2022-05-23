package designpatterns.factory;

public class Test {

    public static void main(String[] args) {
//        Calculate calculate = new Divide();
        FactoryCalculate factory = new FactoryCalculate();
        Calculate calculate = factory.getCalculateFactory("add");
        calculate.calculate(2.5, 1.6);

        calculate = factory.getCalculateFactory("subtract");
        calculate.calculate(4.5, 2.5);

        calculate = factory.getCalculateFactory("divide");
        calculate.calculate(1.2, 0);
    }
}
