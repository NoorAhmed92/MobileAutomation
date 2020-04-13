package Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class Launchpage  {

    public AndroidDriver<MobileElement>  driver;

    @AndroidFindBy(xpath="//android.widget.Button[@index='5']")
    public WebElement signInButton;

    public Launchpage(AndroidDriver<MobileElement> driver) throws InterruptedException {
        this.driver = driver;

        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    // This method used to click on signin button
    public void clickOnSignInButton() throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.);
        //Thread.sleep(10000);
         signInButton.click();

    }


}
