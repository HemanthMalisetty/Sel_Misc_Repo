package Switch_Browsers_Window;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class faketest {

	@Test
	public void test() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("button1")).click();

		// Get and store both window handles in array
		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandles.toArray()[0]);
		String window2 = (String) AllWindowHandles.toArray()[1];
		System.out.print("\nWindow2 handle code = " + AllWindowHandles.toArray()[1]);

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);
		System.out.println("\nWindow2 Title = " + driver.getTitle());
		driver.get("http://www.google.com");
		Thread.sleep(2000);

		// Switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		// Once Again switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);
		System.out.println(driver.getTitle());
		driver.close();

		// Once Again switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
	}
}