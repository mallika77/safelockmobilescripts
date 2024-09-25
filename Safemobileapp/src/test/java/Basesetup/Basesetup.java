package Basesetup;



import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;



public class Basesetup {


public static AppiumDriver driver;
public static Properties prop;
public static URL url;



@BeforeTest
    public void loadProperties() {
        try {
            File f = new File("C:\\Users\\mallika\\git\\safelockmobilescripts\\Safemobileapp\\inputprop");
            FileInputStream fis = new FileInputStream(f);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    @BeforeSuite
    public void setupMobileDriver() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:deviceName", "TKW88H9TONSSQG6D");
        cap.setCapability("appium:platformName", "Android");
        cap.setCapability("appium:platformVersion", "12");
        cap.setCapability("appium:automationName", "UiAutomator2");
        cap.setCapability("appium:app", "F:\\selyek 40.apk");
        cap.setCapability("appium:commandTimeout", 600);
        cap.setCapability("appium:newCommandTimeout", 600);



        url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, cap);
        System.out.println("App opened successfully!");
    }



    public String getProperty(String key) {
        return prop.getProperty(key);
    }



    public void Clickfunction(WebElement clickElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
            wait.until(ExpectedConditions.elementToBeClickable(clickElement));
            clickElement.click();
        } catch (Exception e) {
            System.out.println("Failed to click the element: " + e.getMessage());
        }
    }




public void sendkeys(WebElement element, String value) {
element.sendKeys(value);
}
}
