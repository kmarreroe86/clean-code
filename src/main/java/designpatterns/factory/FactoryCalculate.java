package designpatterns.factory;

public class FactoryCalculate {

    public Calculate getCalculateFactory(String type) {
        Calculate instance = null;
        if ("add".equalsIgnoreCase(type)) {
            instance = new Add();
        } else if ("subtract".equalsIgnoreCase(type)) {
            instance = new Subtract();
        } else if ("divide".equalsIgnoreCase(type)) {
            instance = new Divide();
        }
        return instance;
    }
}
