package linkeinlearning.generics;

public class GenericsExample {

    public static void main(String[] args) {
        Printer<Integer> printerInt = new Printer<>(23);
        printerInt.print();

        Printer<Double> printerDouble = new Printer<>(23d);
        printerDouble.print();

        print(new PrinterChild<String>("String Test"));

        Dog dog = new Dog();
        Cat cat = new Cat();
        PrintAnimal<Dog> printAnimal = new PrintAnimal<>(dog);
        printAnimal.print();

        printAnimal = new PrintAnimal<>(cat);
        printAnimal.print();

    }

    public static <T1 extends Printer> void print(T1 data) {
        data.print();
    }
}
