package linkeinlearning.generics;

public class PrinterChild<T> extends Printer {

    public PrinterChild(T data) {
        super(data);
    }

    @Override
    public void print() {
        System.out.println("PrintChild override print");
        super.print();
    }
}
