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

public class ProductPage extends BasePOMpage{

    @AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
    private AndroidElement searchTxt;

    @AndroidFindBy(xpath ="//android.webkit.WebView[@index='0']/android.view.View[@index='0']/android.view.View[@index='4']")
    private AndroidElement clickOnTV;

    @AndroidFindBy(xpath= "//android.webkit.WebView[@index='0']/android.view.View[@index='0']/android.view.View[@index='2']")
    private AndroidElement getTitle;

    @AndroidFindBy(xpath ="//android.widget.Button[@content-desc='See All Buying Options See All Buying Options']")
    private AndroidElement buyOption;

    @AndroidFindBy(xpath ="//android.view.View[@index='7']")
    private AndroidElement addToCart;

    @AndroidFindBy(xpath="//android.widget.TextView[@index='1']")
    private AndroidElement clickOnCart;

    @AndroidFindBy(xpath="//android.widget.Button[@index='0']")
    private AndroidElement proceedToCheckout;

    @AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'add-to-cart-button')]")
    private AndroidElement addToCartBtn;


    public ProductPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    //This method used to search for a product
    public void searchTxt(String searchItem1) throws InterruptedException {
        Thread.sleep(3000);
        searchTxt.sendKeys(searchItem1);
        Thread.sleep(2000);
        driver.pressKeyCode(66);
    }
    //This method used to click on searched product except 1st product in search result page
    public void clickOnTv() throws InterruptedException {
        Thread.sleep(5000);
        Dimension size = driver.manage().window().getSize();
        int startY = (int)(size.height*0.8);
        int endY = (int)(size.height *0.2);
        int startX = size.width/2;
        TouchAction action = new TouchAction(driver);
        action.press(startX,startY).waitAction(Duration.ofSeconds(30)).moveTo(startX,endY).release().perform();
        Thread.sleep(5000);
        if (clickOnTV.isDisplayed()) {
            clickOnTV.click();
        } else {
            System.out.println("No 65 inch tv found");
        }
        //clickOnTV.click();
    }
    //This method used to get the product description
    public String getDescriptionOfItem() throws InterruptedException {
        Thread.sleep(10000);
        return getTitle.getAttribute("name");
    }
    //This method used to add the item into cart
    public void clickOnBuyOption() throws InterruptedException {
        Thread.sleep(3000);
        Dimension size = driver.manage().window().getSize();
        int startY = (int)(size.height*0.8);
        int endY = (int)(size.height *0.2);
        int startX = size.width/2;
        TouchAction action = new TouchAction(driver);
        action.press(startX,startY).waitAction(Duration.ofSeconds(5)).moveTo(startX,endY).release().perform();
        Thread.sleep(3000);

         if(addToCartBtn.isDisplayed()){
            addToCartBtn.click();
        }else if(buyOption.isDisplayed()){
            buyOption.click();
            addToCart();

         }
    }
    //This method used to add product to cart
    public void addToCart() throws InterruptedException {
        Thread.sleep(3000);

        addToCart.click();
    }
    //This method used to click on cart
    public void clickOnBasket() throws InterruptedException {
        Thread.sleep(5000);
        clickOnCart.click();
    }
    //This method used to click on proceed to checkout button
    public void clickOnCheckout() throws InterruptedException {
        Thread.sleep(5000);
        proceedToCheckout.click();
    }
    //This method used to search an item and click on it
    public String checkoutItem(String searchItem1) throws InterruptedException {
        searchTxt(searchItem1);
        clickOnTv();
        //getDescriptionOfItem();
        return null;

    }
    //This method used to click an addtocart button and proceed for checkout
    public String checkOutProduct() throws InterruptedException {
        clickOnBuyOption();
        //addToCart();
        clickOnBasket();
        clickOnCheckout();
        return null;
    }
}
