package testCases;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utilities.ReadConfig;

public class Base {

	ReadConfig readconfig = new ReadConfig();
	String BaseURL = readconfig.getApplicationURL();
	public WebDriver driver;
	public WebDriverWait wait;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String br) {
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxDriverPath());
			driver = new FirefoxDriver();
		} else if (br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEDriverPath());
			driver = new InternetExplorerDriver();
		}

		driver.get(BaseURL); //https://todomvc.com/examples/react/#/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 90);

	}
	

	@AfterMethod
	public void CaptureScreenshot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,
					new File(System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png"));
			System.out.println("Screenshot taken.");
		}

	}
	
	public void closeHomePagPopUp() throws InterruptedException { 
		for(int i=0;i<10;i++)
		{ 
			List<WebElement> popUp= driver.findElements(By.xpath("//div[@class='at4win-header']/a[@title='Close']"));
			System.out.println("Close Pop-up size: "+popUp.size());
			if(popUp.size()>0)
			{
				driver.findElement(By.xpath("//div[@class='at4win-header']/a[@title='Close']")).click();
				System.out.println("Home Page Pop-up closed");
				break;
			}
			}
		}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
