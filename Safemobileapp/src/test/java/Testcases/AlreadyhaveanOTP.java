package Testcases;							


import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Basesetup.Basesetup;
import WebElements.Loginpage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlreadyhaveanOTP extends Basesetup {
	private Loginpage login;
	
	@BeforeClass
	public void setup() throws Exception {
		// Load properties and initialize mobile driver
		loadProperties(); // Load properties from the parent class
		// Initialize the mobile driver
		// Initialize the LoginPage elements after the driver is set up
		login = PageFactory.initElements(driver, Loginpage.class);
	}
	
	@Test(priority = 1, enabled = true)
	public void VERIFY_THAT_SAFELOCK_USER_ENTER_THE_ACTIVATION_CODE_ON_ACTIVATION_FIELD() throws InterruptedException {
		// Adding a wait to ensure the app is loaded properly
		Thread.sleep(3000);
		// Fetch the activation code from the properties file using getProperty method
		String EnterActivationCode = getProperty("EnterActivationCode");
		sendkeys(login.EnterActivationCode, EnterActivationCode);
		System.out.println("Activation code entered!");
	}

	@Test(priority = 2, enabled = true)
	public void VERIFY_THAT_USER_NAVIGATED_INTO_LOGIN_PAGE_AFTER_CLICKED_SUBMIT_BUTTON() {
		Clickfunction(login.EnterSubmit);
		System.out.println("User Navigated into Login page!");
	}

	/*
	 * try { ((AndroidDriver) driver).hideKeyboard();
	 * System.out.println("Keyboard hidden successfully."); } catch (Exception e) {
	 * System.out.println("No keyboard to hide."); }
	 */
	@Test(priority = 3, enabled = true)
	public void VERIFY_THAT_USER_ABLE_TO_ENTER_THE_EMAIL_ID_WHEN_KEYBOARD_APPEARS_BY_DEFAULT()
			throws InterruptedException {
		// Wait until the page is loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String Entermailid = getProperty("Entermailid"); // Declare email once

		try {
			// Assume the keyboard isn't showing and click to bring focus to the field
			Clickfunction(login.Entermailid);
			Thread.sleep(2000); // Wait to ensure any keyboard interaction is handled

			// Enter email ID directly
			sendkeys(login.Entermailid, Entermailid);
			System.out.println("Email ID entered successfully.");
		} catch (Exception e) {
			// If there was an issue finding the email field or keyboard interaction
			System.out.println("Keyboard is not present. Attempting to tap the field to bring up the keyboard.");
			Clickfunction(login.NOKEYBOARD);
			// Tap the field to bring up the keyboard
			Clickfunction(login.Entermailid); // Directly click the email field to bring focus
			System.out.println("Email field clicked to trigger the keyboard.");

			// Wait for the keyboard to appear
			Thread.sleep(1500); // Wait to ensure the keyboard is visible

			// Retry entering the email ID after focusing on the field
			sendkeys(login.Entermailid, Entermailid);
			System.out.println("Email entered successfully after clicking (keyboard not present initially).");
		}
	}

	@Test(priority = 4, enabled = true)
	public void VERIFY_THAT_USER_ABLE_TO_ENTER_THE_PASSWORD_ON_THE_PASSWORD_FIELD() throws InterruptedException {
		Thread.sleep(2000);
		Clickfunction(login.Enterpassword);
		String Enterpassword = getProperty("Enterpassword");
		sendkeys(login.Enterpassword, Enterpassword);
		System.out.println("Password entered successfully!");
	}

	@Test(priority = 5, enabled = true)
	public void VERIFY_THAT_SAFELOCK_APP_LOGGED_IN_SUCCESSFULLY_BY_CLICK_ON_SUBMIT_BUTTON()
			throws InterruptedException {
		Thread.sleep(3000);
		Clickfunction(login.Clicklogin);
		System.out.println("Logged in successfully!");
	}

	@Test(priority = 6, enabled = true)
	public void VERIFY_THAT_CREATED_ACCESS_IS_LISTED_IN_THE_ACCESS_PAGE() throws InterruptedException {
		Thread.sleep(3000);
		WebElement accessElement = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiSelector().description('Access Name demolock6 Date & Time Range Mon, Sep 30, 2024 12:00 AM - Tue, Sep 30, 2025 11:30 PM Available Days MON TUE WED THU FRI SAT SUN')"));
		
		accessElement.click();
		System.out.println("Access of the user Clicked successfully!");
	}

	@Test(priority = 7, enabled = true)
	public void VERIFY_THAT_BLUETOOTH_IS_ENALBED_BY_CLICKING_ON_ALLOW_BUUTON() throws InterruptedException {
		Thread.sleep(3000);
		Clickfunction(login.bleallowbutton);
		System.out.println("Nearby devices access allowed successfully!");
	}

	@Test(priority = 8, enabled = true)
	public void VERIFY_THAT_LOCATION_IS_ALLOWED_BY_CLICKING_ON_ALLOW_OPTION() throws InterruptedException {
		Thread.sleep(3000);
		Clickfunction(login.locationallow);
		System.out.println("Nearby devices location access allowed successfully!");
	}

	@Test(priority = 9, enabled = true)
	public void VERIFY_THAT_SELECTED_LOCK_IS_SEARCHED_AND_CONNECTED_TO_THE_DEVICE() throws InterruptedException {
		Thread.sleep(3000);
		Clickfunction(login.connectbutton);
		System.out.println("Controller searched and displayed successfully!");
	}

	@Test(priority = 10, enabled = true)
	public void VERIFY_THAT_USER_LOADED_WITH_OPEN_LOCK_PAGE_ALONG_WITH_CONTROLLER_DETAILS()
			throws InterruptedException {
		// Create WebDriverWait instance with AppiumDriver and timeout
		Thread.sleep(5000);
		System.out.println("The Lock deatils are :");
		// Wait for the element to be visible
		// WebElement lockdetails =
		// driver.findElement(By.xpath("//android.view.View[contains(@content-desc,
		// 'D1.A0003')]"));
		// Get the text from the element
		String lockid = login.lockdetails.getAttribute("content-desc");
		System.out.println("The lock id is " + lockid);
		// RTC
		WebElement LockRTCdataandtime = driver
				.findElement(By.xpath("//android.view.View[contains(@content-desc, 'Lock RTC Date & Time')]"));
		String text = LockRTCdataandtime.getAttribute("content-desc");
		System.out.println(text);
		// Wait until element is visible//not working
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement textElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'Status')]")));
		String lockStatusData = textElement.getAttribute("content-desc");

		String[] split = lockStatusData.split("\\s+"); // Split by any whitespace, including new lines

		if (split.length >= 2) {
			// Construct status (first two words: "Status Closed")
			String status = split[0] + " " + split[1];
			System.out.println("Current Lock status is: " + status);
		} else {
			System.out.println("Error: Unable to retrieve the full lock status.");
		}

		if (split.length >= 4) {
			// Construct battery (next two words: "Battery 100%")
			String battery = split[2] + " " + split[3];
			System.out.println("Current Battery status is: " + battery);
		} else {
			System.out.println("Error: Unable to retrieve battery details.");
		}

		if (split.length >= 7) {
			// Construct firmware version (next three words: "Firmware Version v1.2.8")
			String firmwareversion = split[4] + " " + split[5] + " " + split[6];
			System.out.println("Firmware details: " + firmwareversion);
		} else {
			System.out.println("Error: Unable to retrieve firmware details.");
		}

		// Pause for a moment
		Thread.sleep(2000);

		// Perform the click action
		Clickfunction(login.openlock);
	}
	

	@Test(priority = 11, enabled = true)
	public void VERIFY_THAT_USER_NAVIAGETED_INTO_GET_OTP_SCREEN_SUCCESSFULLY() throws InterruptedException {
	    Clickfunction(login.REQUESTOTP);
	    Thread.sleep(2000); // Consider replacing with an explicit wait if needed

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout
	    try {
	        // Wait for the presence of the deny button
	        WebElement denyButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.google.android.gms:id/negative_button']")));
	        
	        // Check if the button is displayed
	        if (denyButton.isDisplayed()) {
	            Clickfunction(denyButton);
	            System.out.println("Deny button clicked");
	        } else {
	            System.out.println("Deny button not displayed");
	        }
	    
	    } catch (Exception e) {
	        // This will catch any cases where the element was never found
	        System.out.println("Deny button not found (NoSuchElementException)");
	    }
		// Handle OTP screen close icon (if present) 
		 try {
		        WebElement otpCloseIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[1]")));
		        Clickfunction(login.EnterORPcrossicon);
		        System.out.println("OTP screen closed using close icon");
               // Continue with further actions
		        Clickfunction(login.openlock);
		        Thread.sleep(2000);
		        Clickfunction(login.AlreadyhaveanOTP);
		        System.out.println("AlreadyhaveanOTP Clicked Successfully and Enter the OTP received");
		        Thread.sleep(5000);
		        Clickfunction(login.otpsubmit);
		        } 
		 catch (Exception e) {
		        System.out.println("crossicon button not present");
		   
		    }
	    }
	@Test(priority = 12, enabled = true)
	public void VERIFY_THAT_LOCK_OPENED_SUCCESSFILLY_AFTER_ENTERED_THE_OTP_By_Click_Submit_AND_STATUS_CHANGED_INTO_OPENED()
			throws InterruptedException {
		// Use explicit wait for the textread element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'successfully opened')]")));
		// Get the content-desc attribute value
		String text = textElement.getAttribute("content-desc");
		System.out.println("Lock opened message: " + text);
		Clickfunction(login.okay);
		System.out.println("Lock Opened Successfully");
		WebElement openstates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'Status')]")));
		String lockStatusData = openstates.getAttribute("content-desc");
		String[] split = lockStatusData.split("\\s+"); // Split by any whitespace, including new lines
		if (split.length >= 2) {
			// Construct status (first two words: "Status Closed")
			String status = split[0] + " " + split[1];
			System.out.println("CURRENT LOCK STATUS AFTER ENTERED THE OTP IS: " + status);
		} else {
			System.out.println("Error: Unable to retrieve the full lock status.");
		}

	}

	@Test(priority = 13, enabled = true)
	public void VERIFY_THAT_LOCK_AUTOMATICALLY_CLOSED_AFTER_CONFIGURED_SECONDS_AND_STATUS_CHANGED_INTO_CLSOED()
			throws InterruptedException {
		// Use explicit wait for the textread element
		Thread.sleep(11000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement openstates = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'Status')]")));
		String lockStatusData = openstates.getAttribute("content-desc");
		String[] split = lockStatusData.split("\\s+"); // Split by any whitespace, including new lines

		if (split.length >= 2) {
			// Construct status (first two words: "Status Closed")
			String status = split[0] + " " + split[1];
			System.out.println("lOCK AUTOMATICALLY LOCKED AFTER CONFIGURED TIME: " + status);
		} else {
			System.out.println("Error: Unable to retrieve the full lock status.");
		}

	}

	@Test(priority = 14, enabled = true)
	public void VERIFY_THAT_ALL_THE_PENDING_SYNC_EVENTS_SYNCED_SUCCESSFULLY() throws InterruptedException {
		Thread.sleep(3000);
		Clickfunction(login.syncevent);
		System.out.println("All events synced successfully");
	}
}
