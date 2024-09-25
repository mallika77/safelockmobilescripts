package WebElements;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class Loginpage {
 
public WebDriver driver;
//activation code
@FindBy(xpath = "//android.widget.EditText")
public WebElement EnterActivationCode;
@FindBy(xpath ="//android.widget.Button[@content-desc=\"Submit\"]")
public WebElement EnterSubmit;
@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")
public WebElement withoutkeyboard; 
//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]
 
//login
@FindBy(xpath ="//android.widget.ScrollView/android.widget.EditText[1]")
public WebElement Entermailid;
@FindBy(xpath ="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")
public WebElement NOKEYBOARD;
@FindBy(xpath ="//android.widget.ScrollView/android.widget.EditText[2]")
public WebElement Enterpassword;
@FindBy(xpath ="//android.widget.Button[@content-desc='Login']")
public WebElement Clicklogin; 
//location and device access
@FindBy(xpath="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
public WebElement bleallowbutton; 
@FindBy(xpath="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_one_time_button']")
public WebElement locationallow;
@FindBy(xpath="//android.widget.Button[@content-desc='Connect']")
public WebElement connectbutton;
 
@FindBy(xpath="//android.view.View[@content-desc='D1.A0003']")
public WebElement lockdetails;
@FindBy(xpath="//android.widget.Button[@content-desc='Open Lock']")
public WebElement openlock;
//OTP
@FindBy(xpath="//android.widget.Button[@content-desc='Request OTP']")
public WebElement REQUESTOTP;
@FindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms:id/positive_button']")
public WebElement allowotp;
@FindBy(xpath="//android.widget.Button[@content-desc='Submit']")
public WebElement otpsubmit; 
@FindBy(xpath="//android.widget.Button[@content-desc='OK']")
public WebElement okay;
@FindBy(xpath="//android.widget.Button")
public WebElement syncevent;
//Already have an OTP
@FindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms:id/negative_button']")
public WebElement deny;
//   new UiSelector().resourceId("com.google.android.gms:id/negative_button")
@FindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.Button[1]']")
public WebElement EnterORPcrossicon;
 
 
 
 
//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.Button[1]
 
//android.widget.Button[@content-desc="Already have an OTP?"]
@FindBy(xpath="//android.widget.Button[1]")
public WebElement EnterORPcrossicon1;
@FindBy(xpath="//android.widget.Button[@content-desc='Already have an OTP?']")
public WebElement AlreadyhaveanOTP;
 
 
 
 
 
 
 
//android.view.View[@content-desc="Status Closed Battery 100% Firmware Version v1.2.8"]
//android.view.View[@content-desc="Lock RTC Date & Time September 13, 2024 4:09:36 PM"]
 
//android.widget.Button[@content-desc="Already have an OTP?"]
 
 
 
 
 
 
public Loginpage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}
}


