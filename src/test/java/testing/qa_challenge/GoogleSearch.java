package testing.qa_challenge;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GoogleSearch extends BaseDriver{
	
	@Test
	public void googleTest() throws IOException {
		BaseDriver bd= new BaseDriver();
		bd.getDriver();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("test automation is awesome");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		String title=driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
