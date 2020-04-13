package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BasePOMpage {

    @AndroidFindBy(xpath="//android.view.View[@index='1']/android.view.View[@index='1']")
    private AndroidElement clickOnDeliverBtn;

    @AndroidFindBy(xpath="//android.view.View[@index='0']/android.widget.ListView[@index='1']")
    private AndroidElement getProductData;

    public CheckOutPage (AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    //This method is used to click on Delivery button
    public String setClickOnDeliverButton() throws InterruptedException {
        Thread.sleep(10000);
        clickOnDeliverBtn.click();
        return null;

    }
    //This method used to get product description
    public String getProductData() throws InterruptedException {
        Thread.sleep(5000);
        return getProductData.getText();
    }
}
