package testing.qa_challenge;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseDriver {
public static WebDriver driver;

public void getDriver() throws IOException{
	
	FileReader fl=new FileReader("SeleniumProperties.properties");
	BufferedReader reader=new BufferedReader(fl);
	Properties p=new Properties();
	p.load(reader);
	

	String browser=p.getProperty("browser");
	
	if(browser.equalsIgnoreCase("CHROME")){
		System.setProperty("webdriver.chrome.driver",p.getProperty("ChromeDriverPath"));
	 //driver= new ChromeDriver();
		ChromeOptions chromeoptions=new ChromeOptions();
		chromeoptions.addArguments("--disable-notifications");
		driver=new ChromeDriver(chromeoptions);
	}
	else if(browser.equalsIgnoreCase("IE")){
	System.setProperty("webdriver.ie.driver",p.getProperty("IEDriverPath") );
	 driver= new InternetExplorerDriver();
	
	}
	else if(browser.equalsIgnoreCase("FIREFOX")){
		System.setProperty("webdriver.gecko.driver", p.getProperty("GeckoDriverPath"));
		driver= new FirefoxDriver();
	}
	else{
		System.out.println("Please enter the correct browser name");
	}
	
	
	// Implicit wait :
	// Gloabl wait // It will applicable for all the webelement 
	// If element is not populated with in the time then it will throw No such Element exception
	// By default implicit wait time 0 sec
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	
}
}
