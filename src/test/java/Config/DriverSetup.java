package Config;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverSetup {

    public AndroidDriver<MobileElement>  driver;

    @BeforeTest
    @Parameters({"deviceName","platformVersion","UDID"})
    public void setup(String deviceName,String platformVersion,String UDID) throws MalformedURLException {
       try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.UDID, UDID);
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
            caps.setCapability(MobileCapabilityType.NO_RESET, true);

            File appDir = new File("C:/Users/NoorAhmed/IdeaProjects/AppiumAssignmnet/src/test/resources/Apps"); //only path to apk file directory
            File app = new File(appDir, "Amazon_shopping.apk");
            //caps.setCapability(MobileCapabilityType.APP, "src/test/resources/Apps/Amazon_shopping.apk");
            caps.setCapability("app",app.getAbsolutePath());
            caps.setCapability("appPackage","com.amazon.mShop.android.shopping");
            caps.setCapability("appActivity","com.amazon.mShop.splashscreen.StartupActivity");
            //caps.setCapability("appWaitActivity","com.amazon.mShop.home.web.MShopWebGatewayActivity");
            //caps.setCapability(MobileCapabilityType.APP,"app.");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<MobileElement> (url, caps);


        }catch(Exception ex)
        {
            System.out.println("Cause is:"+ ex.getCause());
            System.out.println("Message is" + ex.getMessage());
            ex.printStackTrace();
        }
    }

  @AfterTest
  public void teardown()
    {
        driver.quit();
     }
}

