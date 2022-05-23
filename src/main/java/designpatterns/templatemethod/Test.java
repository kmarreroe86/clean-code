package designpatterns.templatemethod;

public class Test {

    public static void main(String[] args) {
        DataProcessor processor = new ExcelFile();
        processor.processFile();

        System.out.println("====================");
        processor = new TextFile();
        processor.processFile();


        processor.processData();
    }
}
