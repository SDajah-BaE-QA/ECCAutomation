package bankAlEtihadECC.tests;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import bankAlEtihadECC.pageObjects.OutwardPage;
import bankAlEtihadECC.testComponents.BaseTest;



public class OutwardChequesTest extends BaseTest{

	@Test(dataProvider= "getData")
	public void outwardChequesTest(HashMap<String,String> input) throws IOException, InterruptedException
	{
		landingPage.loginApplication(input.get("userLoginName"), input.get("userPass"));
		OutwardPage outwardPage=new OutwardPage(driver);
		outwardPage.createBatch();
		String sequence= outwardPage.chequeInfo();
		outwardPage.qualityAssuranceAccept(sequence);      

	}
	
	@Test(dataProvider= "getData")
	public void repairCheques(HashMap<String,String> input) throws InterruptedException
	{
		landingPage.loginApplication(input.get("userLoginName"), input.get("userPass"));
		OutwardPage outwardPage=new OutwardPage(driver);
		outwardPage.createBatch();
		String sequence= outwardPage.chequeInfo();
		outwardPage.qualityAssuranceReject(sequence);
		outwardPage.repairTab(sequence);
		outwardPage.qualityAssuranceAccept(sequence); 
		System.out.println("Passed");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("userLoginName", "SD2023");
//		map.put("userPass", "Test@111");
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\bankAlEtihadECC\\data\\TestData.json");
		return new Object[][] {{data.get(0)}};
		//return new Object[][] {{"SD2023","Test@111"}};
	}

}
