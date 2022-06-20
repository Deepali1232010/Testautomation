package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class ScreenShot {

	/*public static void screenshot(WebDriver driver) throws IOException {
		int a = 0;
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("D:\\Velocity\\Automation\\Screenshot\\"+a+".png");// System ka path jaha par hume file save karni hain
		
		FileHandler.copy(source, destination);// file source is temprory memory se file destination is system ke permanant memory main save hogi
		a++;
		
		}*/
	
	
		public static void takeScreenShot (WebDriver driver, String name) throws IOException { 
			String d = ScreenShot.date();

		 File source =((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);

		File destination = new File("D:\\Velocity\\Automation\\Screenshot\\"+ name + d+".jpg");

		 FileHandler.copy(source, destination);

	}

		 public static String date() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern ("yyyy-MMM-dd HH-mm-ss"); //format the time date and time as required 
		 LocalDateTime currentTime = LocalDateTime.now(); //return current time
		String d= dtf.format(currentTime); //format the time given my now() method to required format and return String 

		return d;

		 // String date = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss").format(LocalDateTime.now());

		// return date;
		
		}

	}
	

