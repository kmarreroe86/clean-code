package designpatterns.templatemethod;

public abstract class DataProcessor {

    public void processFile() {
        readData();
        processData();
        saveData();
    }

    protected abstract void readData();
    protected abstract void processData();
    protected void saveData() {
        System.out.println("Save data to DB");
    }



}
