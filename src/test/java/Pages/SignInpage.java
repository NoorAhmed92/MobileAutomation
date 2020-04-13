package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SignInpage extends BasePOMpage {

    public SignInpage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'ap_ra_email_or_phone')]")
    private AndroidElement emailIdtxt;

    @AndroidFindBy(id = "continue")
    private AndroidElement ContinueBtn;


    public void EmailID(String PNum) {

        emailIdtxt.sendKeys(PNum);
    }
}