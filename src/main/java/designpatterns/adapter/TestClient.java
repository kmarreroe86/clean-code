package designpatterns.adapter;

public class TestClient {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.getElement();
        driver.selectElement();

        System.out.println("=====================");
        driver = new WebDriverAdapter(new IEDriver());
        driver.getElement();
        driver.selectElement();
    }
}
