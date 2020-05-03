package test.first.time.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Softs/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://popuptest.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement click=driver.findElement(By.xpath("//*[contains(text(),'Come & Go Test')]"));
		click.click();
		Set<String> wi=driver.getWindowHandles();
		Iterator<String> it=wi.iterator();
		String pw=it.next();
		System.out.println(pw);
		String cw=it.next();
		System.out.println(cw);
		driver.switchTo().window(cw);
		String title=driver.getTitle();
		System.out.println(title);
		driver.close();
		driver.switchTo().window(pw);
		String s1=driver.getTitle();
		System.out.println(s1);
		driver.quit();
		

	}

}
