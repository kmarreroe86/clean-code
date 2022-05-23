package designpatterns.adapter;

public class ChromeDriver implements WebDriver {
    @Override
    public void getElement() {
        System.out.println("Get element with Chrome driver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select element with Chrome driver");

    }
}
