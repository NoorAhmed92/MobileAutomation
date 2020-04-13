package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePOMpage{

    public LoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
    private AndroidElement passwordTxt;

    @AndroidFindBy(xpath= "//android.widget.Button[@index='0']")
    private  AndroidElement loginBtn;

    @AndroidFindBy(xpath="//android.widget.Button[@index='5']")
    public AndroidElement signInButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'ap_ra_email_or_phone')]")
    private AndroidElement emailIdTxt;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    private AndroidElement continueBtn;


    //This method is used to click on Already a customer? SignIn button
    public void clickOnSignInButton() throws InterruptedException {
        Thread.sleep(10000);
        signInButton.click();
    }
    //This method used to send EmailId/Phone number
    public void EmailID(String PNum) throws InterruptedException {
        Thread.sleep(10000);
        emailIdTxt.sendKeys(PNum);
    }
    //This method used to click on Continue button
    public void clickOnContinue() throws InterruptedException {
        Thread.sleep(10000);
        continueBtn.click();
    }
    //This method used to send password value
    public void enterPassword(String password) throws InterruptedException {
        Thread.sleep(10000);
        passwordTxt.sendKeys(password);
    }
    //This method used to click on Login button
    public void clickOnLogin() throws InterruptedException {
        Thread.sleep(10000);
        loginBtn.click();
    }
    //This method is used to login into app
    public String loginIntoApp(String PNum1,String password) throws InterruptedException {
        clickOnSignInButton();
        EmailID(PNum1);
        clickOnContinue();
        enterPassword(password);
        clickOnLogin();
        return null;

    }


}
