package designpatterns.adapter;

public class WebDriverAdapter implements WebDriver {

    private final IEDriver ieDriverAdaptee;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriverAdaptee = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriverAdaptee.findElement();
    }

    @Override
    public void selectElement() {
        ieDriverAdaptee.clickElement();
    }
}
