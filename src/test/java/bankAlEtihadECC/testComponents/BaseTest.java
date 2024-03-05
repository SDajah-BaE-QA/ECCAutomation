package bankAlEtihadECC.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import bankAlEtihadECC.pageObjects.LandingPage;

public class BaseTest {
	
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\bankAlEtihadECC\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edg.driver", "D:/SHADI_TEST/Software/WebDriver/edgedriver_win64/msedgedriver.exe");
			driver = new EdgeDriver();
			
		}
		else if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/SHADI_TEST/Software/WebDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
			driver = new ChromeDriver();
			ChromeOptions option = new ChromeOptions();
			if(browserName.contains("headless"))
			{
			option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
			driver.manage().window().setSize(new Dimension(1440,900));
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public  List<HashMap<String, String>> getJsonData(String filePath) throws IOException
	{
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File(System.getProperty("user.dir")+"reports"+ testCaseName + ".png");
		FileUtils.copyFile(source, screenshotFile);
		return System.getProperty("user.dir")+"reports"+ testCaseName + ".png";
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}

}
