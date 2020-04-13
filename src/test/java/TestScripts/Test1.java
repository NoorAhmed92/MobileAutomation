package TestScripts;

import Config.DriverSetup;
import Pages.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class Test1 extends DriverSetup {
    private LoginPage login;
    private Homepage home;
    private ProductPage srp;
    private CheckOutPage cp;
    SoftAssert softAssert = new SoftAssert();

//    @Test(priority = 1, description = "signIn into app")
//    @Parameters({"PNum1", "password"})
//    //This method is used to signIn into app
//    public void signIntoAPP(String PNum1, String password) throws InterruptedException {
//        login = new LoginPage(driver);
//        softAssert.equals(login.loginIntoApp(PNum1, password));
//        System.out.println("Successfully loggedIn to app");
//        softAssert.assertAll();
//    }

    @Test(priority = 2, description = "set country to Australia")
    //This method is used to set country to Australia
    public void setCountryToAustralia() throws InterruptedException {
        home = new Homepage(driver);
        softAssert.equals(home.selectCountryToAustralia());
        System.out.println("Country been set to Australia");
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "search product and do checkout")
    @Parameters({"searchItem"})
    //This method is used to search product and do checkout
    public void searchForTV(String searchItem) throws InterruptedException {
        srp = new ProductPage(driver);
        softAssert.equals(srp.checkoutItem(searchItem));
        String s1 = srp.getDescriptionOfItem();
        System.out.println(s1);
        softAssert.equals(srp.checkOutProduct());
        cp = new CheckOutPage(driver);
        softAssert.equals(cp.setClickOnDeliverButton());
        String s2 = cp.getProductData();
        System.out.println(s2);
        if (s1.equals(s2)) {
            System.out.println("Pass: Product description matched with checkout page product");
        } else {
            System.out.println("Fail: Product description didn't matched with checkout page product");
        }


    }
}
