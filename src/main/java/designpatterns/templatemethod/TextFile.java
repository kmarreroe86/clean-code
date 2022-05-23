package designpatterns.templatemethod;

public class TextFile extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Read data from text file");
    }

    @Override
    protected void processData() {
        System.out.println("Process data from text file");
    }
}
