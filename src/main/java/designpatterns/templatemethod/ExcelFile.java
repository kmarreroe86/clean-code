package designpatterns.templatemethod;

public class ExcelFile extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Read data from excel file");
    }

    @Override
    protected void processData() {
        System.out.println("Process data from excel file");
    }
}
