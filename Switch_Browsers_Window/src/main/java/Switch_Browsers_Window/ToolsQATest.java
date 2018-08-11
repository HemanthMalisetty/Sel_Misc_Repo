package Switch_Browsers_Window;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.inject.Inject;

public class ToolsQATest {

/*    @Inject
    private ToolsQA toolsQA;

    @Inject
    private ToolsQANewWindow toolsQANewWindow;

    @Test
    public void switchTest() {

        toolsQA.goTo();
        toolsQA.launchWindow();
        toolsQANewWindow.getTitle();
        }*/

	@Test

    public void testRobot() throws InterruptedException, AWTException{
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();
    	driver.get("http://upastg.nike.com/upa");

Robot robot = new Robot();
	setClipboardData("ahoss1");
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.delay(5000);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);

	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);

	setClipboardData("Daka1023");
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.delay(5000);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
           
             Thread.sleep(5000);

     }

private static void  setClipboardData(String str){		
	StringSelection ss = new StringSelection(str);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
}

}