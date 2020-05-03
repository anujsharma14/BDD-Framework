package test.first.time.selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:/Softs/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String title = driver.getTitle();
		if (title.equals("Google")) {
			System.out.println("Ttile is correct");
		} else {
			System.out.println("Title is incorrect");
		}

		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		WebElement gmaillink = driver.findElement(By.partialLinkText("Gmail"));
		Actions act = new Actions(driver);
		act.moveToElement(gmaillink).build().perform();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:/Screenshot/gmail.png"));
		List<WebElement> numberoflink=driver.findElements(By.tagName("a"));
		int i=numberoflink.size();
		System.out.println(i);
		for(int j=0; j<numberoflink.size(); j++) {
			String s=numberoflink.get(j).getText();
			System.out.println(s);
		}
		driver.quit();

	}

}
