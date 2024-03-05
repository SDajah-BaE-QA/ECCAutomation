package bankAlEtihadECC.pageObjects;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import bankAlEtihadECC.abstractComponents.AbstractComponents;

public class OutwardPage extends AbstractComponents{
	
	
	WebDriver driver;
	public OutwardPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="btnCollaps")
	 private WebElement collaps;
	@FindBy(id="txt_id_1010000_10")
	 private WebElement outwardTab;
	@FindBy(xpath="//span[@id='1010010']")
	 private WebElement imgCapture;
	@FindBy(id="batchListCreateBatch")
	 private WebElement createBatchBtn;
	@FindBy(id="accountNo1")
	 private WebElement accountNo1;
	@FindBy(id="create-totalAmount")
	 private WebElement createTotalAmount;
	@FindBy(id="create-totalCount")
	 private WebElement createTotalCount;
	@FindBy(id="create-batch-scan")
	 private WebElement createBatchScan;
	By batches = By.xpath("//*[@id='Batches']/tbody/tr[2]/td/table/tbody/tr[1]/td[contains(@onmouseover,'hand')]");
	@FindBy(name="sequence")
	 private WebElement batchSequence;
	@FindBy(xpath="//*[@id='Batches']/tbody/tr[2]/td/table/tbody/tr[1]/td[contains(@onmouseover,'hand')]")
	 private WebElement batches1;
	@FindBy(xpath="//*[@id='ChequeInfoTagEditButton']")
	 private WebElement chequeInfoTagEditButton;
	@FindBy(id="serial")
	 private WebElement chqSerial;
	@FindBy(id="payBankCodeInputFieldId")
	 private WebElement payBankCode;
	@FindBy(xpath="//*[@id='payBranchCodeTextField']")
	 private WebElement payBranchCode;
	@FindBy(id="payAccountNumber")
	 private WebElement payAccountNumber;
	@FindBy(id="transactionCode")
	 private WebElement transactionCode;
	@FindBy(id="amount")
	 private WebElement chequeAmount;
	@FindBy(xpath="//*[@id='buttons'] //div[@class='toolbar'] //a[@id='ChequeInfoTagUpdateCell']")
	 private WebElement chequeInfoTagUpdate;
	@FindBy(xpath="//*[@id='buttons'] //div[@class='toolbar'] //a[@id='ChequeInfoTagNextCell']")
	 private WebElement chequeInfoTagNext;
	By editChequeInfo=By.xpath("//*[@id='ChequeInfoTagEditButton']");
	@FindBy(xpath="//*[@id='Batches']/tbody/tr[1]/td[1]/table/tbody/tr/td[2]")
	 private WebElement batchUpdate;
	By batchApprove=By.xpath("//*[@id='BatchInfoApproveCell']");
	@FindBy(xpath="//span[@id='1010040']")
	 private WebElement qualityAssurnace;
	By qualityBatchInforApprove=By.xpath("//*[@id='BatchInfoApproveCell']");
	By qualityBatchInforReject=By.xpath("//*[@id='BatchInfoRejectCell']");
	@FindBy(xpath="//span[@id='1010030']")
	 private WebElement repair;
	@FindBy(name="chequeIDArr")
	 private WebElement chequeSelect;
	@FindBy(css="input[class='Chkbox']:first-of-type")
	 private WebElement firstCheque;
	@FindBy(css="a[title*='Repair']")
	 private WebElement markForRepair;
	@FindBy(id="ChequesListDeleteCell")
	private WebElement deleteCheq;
	@FindBy(id="note")
	private WebElement noteTextBox;
	@FindBy(css="input#totalAmount")
	private WebElement repairTotalAmount;
	@FindBy(css="input#totalCount")
	private WebElement repairTotalCount;
	@FindBy(xpath="//*[@id='BatchInfoUpdateCell']")
	private WebElement repairBatchUpdate;
	@FindBy(id="deleteButton")
	private WebElement deteleCheque;
	
	

	
	public  void createBatch()
	{
		menuFrameToBeAvailable();
		collaps.click();
		outwardTab.click();
		driver.switchTo().frame("mainTree");
		imgCapture.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainFrame");
		createBatchBtn.click();
		accountNo1.sendKeys("0010100044115101");
		WebElement inputFieldAmount = driver.findElement(By.id("create-totalAmount"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", inputFieldAmount);
        createTotalAmount.sendKeys("500");
		WebElement inputFieldCount = driver.findElement(By.id("create-totalCount"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", inputFieldCount);
        createTotalCount.sendKeys("2");
        createBatchScan.click();
		
	}
	
	public String chequeInfo() throws InterruptedException
	{
		elementToBeClickable(batches);
		
		String sequence = batchSequence.getAttribute("value");
		batches1.click();
		alertWaitAndAccept();
		chequeInfoTagEditButton.click();
		Random random = new Random();
	     // Generate a random 6-digit number
	     int randomserial = 100000 + random.nextInt(900000);
	     String serial = Integer.toString(randomserial);
	     chqSerial.sendKeys(serial);
	     payBankCode.sendKeys("09");
	     Thread.sleep(1000);
	     payBranchCode.sendKeys("1010");
	     payAccountNumber.sendKeys("1111111111111111");
	     transactionCode.sendKeys("001");
	     WebElement chqAmount = chequeAmount;
	     ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", chqAmount);
	     chequeAmount.sendKeys("240");
	     if (driver.findElement(By.xpath("//*[@id='payBranchCodeTextField']")).getText()!= "1010")
	     {
	    	 payBankCode.sendKeys("09");
		     Thread.sleep(1000);
		     payBranchCode.sendKeys("1010");
	     }
	     driver.switchTo().defaultContent();
	     driver.switchTo().frame("MainFrame");
	     chequeInfoTagUpdate.click();
	     chequeInfoTagNext.click();
	     alertWaitAndAccept();
	     elementToBeClickable(editChequeInfo);
	     Random random1 = new Random();
	     // Generate a random 6-digit number
	     int randomserial1 = 100000 + random1.nextInt(900000);
	     String serial1 = Integer.toString(randomserial1);
	     chqSerial.sendKeys(serial1);
	     payBankCode.sendKeys("09");
	     Thread.sleep(1000);
	     payBranchCode.sendKeys("1010");
	     payAccountNumber.sendKeys("1111111111111111");
	     transactionCode.sendKeys("001");
	     WebElement chqAmount1 = chequeAmount;
	     ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", chqAmount1);
	     chequeAmount.sendKeys("260");
	     if (driver.findElement(By.xpath("//*[@id='payBranchCodeTextField']")).getText()!= "1010")
	     {
	    	 payBankCode.sendKeys("09");
		     Thread.sleep(1000);
		     payBranchCode.sendKeys("1010");
	     }
	     driver.switchTo().defaultContent();
	     driver.switchTo().frame("MainFrame");
	     //elementToBeClickableW(chequeInfoTagUpdate);
	     chequeInfoTagUpdate.click();
	     //elementToBeClickable(batchUpdate);
	     batchUpdate.click();
	     elementToBeClickable(batchApprove);
	     Thread.sleep(1000);
	     return sequence;
	     
     	     
        
	}
	
	public void qualityAssuranceAccept(String sequence)
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menu");
		collaps.click();
		driver.switchTo().frame("mainTree");
		qualityAssurnace.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainFrame");
		String batchNumber = String.format("//a[contains(@href,'%s')]", sequence);
		WebElement element = driver.findElement(By.xpath(batchNumber));
		element.click();
		elementToBeClickable(qualityBatchInforApprove);
				
	}
	
	public void qualityAssuranceReject(String sequence) throws InterruptedException
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menu");
		collaps.click();
		driver.switchTo().frame("mainTree");
		qualityAssurnace.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainFrame");
		String batchNumber = String.format("//a[contains(@href,'%s')]", sequence);
		WebElement element = driver.findElement(By.xpath(batchNumber));
		element.click();
		firstCheque.click();
		markForRepair.click();
		Thread.sleep(1000);
		elementToBeClickable(qualityBatchInforReject);
				
	}
	
	public void repairTab(String sequence)
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menu");
		collaps.click();
		driver.switchTo().frame("mainTree");
		repair.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainFrame");
		String batchNumber = String.format("//a[contains(@href,'%s')]", sequence);
		WebElement element = driver.findElement(By.xpath(batchNumber));
		element.click();
		firstCheque.click();
		deleteCheq.click();
		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		noteTextBox.sendKeys("Delete The Cheque");
		deteleCheque.click();
		driver.switchTo().window(parentId);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainFrame");

		
		WebElement inputFieldAmount = driver.findElement(By.cssSelector("input#totalAmount"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", inputFieldAmount);
        repairTotalAmount.sendKeys("260");
		WebElement inputFieldCount = driver.findElement(By.cssSelector("input#totalCount"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", inputFieldCount);
		repairTotalCount.sendKeys("1");
		elementToBeClickableW(repairBatchUpdate);
		elementToBeClickable(batchApprove);
		
	}



}
