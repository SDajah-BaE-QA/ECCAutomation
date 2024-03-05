package bankAlEtihadECC.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void menuFrameToBeAvailable()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("menu"));
	}
	
	public void elementToBeClickable(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
		
	}
	
	public void elementToBeClickableW(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
		
	}
	
	public void alertWaitAndAccept()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
	}
	
	

	
    



}
