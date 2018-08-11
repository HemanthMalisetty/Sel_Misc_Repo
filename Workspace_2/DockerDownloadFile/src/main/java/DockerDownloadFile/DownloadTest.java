package DockerDownloadFile;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadTest extends BaseTest {

	private WebDriver driver;
	public PageObjectForDownload pageObjectForDownload;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        super.setUp();
        pageObjectForDownload = PageFactory.initElements(driver, PageObjectForDownload.class);
    }

	@Test
	public void pageObjectForDownload() throws InterruptedException {
	
		pageObjectForDownload.goTo();
		pageObjectForDownload.downloadFile();
		// Path path = Paths.get("/home/Downloads/some-file.txt");
		Path path = Paths.get("/Users/ahoss1/Downloads/some-file.txt");

		// this will wait until the file download is complete.
		Awaitility.await().atMost(1, TimeUnit.MINUTES).until(() -> {
			return path.toFile().exists();
		});

		Assert.assertTrue(path.toFile().exists());
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		 driver.quit();
	}

}
