package Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Homepage extends BasePOMpage {

    @AndroidFindBy(xpath ="//android.widget.RelativeLayout[@index='0']/android.widget.FrameLayout[@index='0']")
    private AndroidElement menuIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Settings')]")
    private AndroidElement clickOnSetting;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Country & Language')]")
    private AndroidElement clickOnCountry;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private AndroidElement clickOnCountryRegion;

    @AndroidFindBy(xpath ="//android.widget.RadioButton[@index='4']")
    private AndroidElement clickOnAustralia;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    private AndroidElement clickOnDoneBtn;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@content-desc='English - EN']")
    private AndroidElement selectEnglish;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='सेव करें']")
    private AndroidElement clickSave;




    public Homepage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }
    //This method used to click on English radio button
    public void clickOnEnglish() throws InterruptedException {
        Thread.sleep(1000);
        selectEnglish.click();
    }
    //This method used to click on save button
    public void clickOnSave() throws InterruptedException {
        Thread.sleep(3000);
        clickSave.click();
    }
    //This method used to click on menu icon
    public void clickOnMenu() throws InterruptedException {
        Thread.sleep(8000);
//        if (selectEnglish.isDisplayed()) {
//            clickOnEnglish();
//            clickOnSave();
//        }
//        else {
//            menuIcon.click();
//        }
        menuIcon.click();
    }
    //This method used to click on Setting Element
    public void clickOnSetting() throws InterruptedException {
        Thread.sleep(10000);
        Dimension size = driver.manage().window().getSize();
        int startY = (int)(size.height*0.5);
        int endY = (int)(size.height *0.3);
        int startX = size.width/2;
        TouchAction action = new TouchAction(driver);
        action.press(startX,startY).waitAction(Duration.ofSeconds(3)).moveTo(startX,endY).release().perform();
        clickOnSetting.click();
    }
    //This method used to click on country/Language button
    public void clickOnCountryAndLanguage() throws InterruptedException {
        Thread.sleep(3000);
        clickOnCountry.click();
    }
    //This method used to click on country/region button
    public void clickOnCountryAndRegion() throws InterruptedException {
        Thread.sleep(15000);
        clickOnCountryRegion.click();

    }
    //This method used to select Australia radio button
    public void selectAustralia() throws InterruptedException {
        Thread.sleep(3000);
        clickOnAustralia.click();
    }
    //This method used to click on Done button
    public void clickOnDoneBtn() throws InterruptedException {
        Thread.sleep(3000);
        clickOnDoneBtn.click();
        Thread.sleep(1000);
    }
    //This method used to set country as Australia
    public String selectCountryToAustralia() throws InterruptedException {
        clickOnMenu();
        clickOnSetting();
        clickOnCountryAndLanguage();
        clickOnCountryAndRegion();
        selectAustralia();
        clickOnDoneBtn();
        return null;

    }
}
