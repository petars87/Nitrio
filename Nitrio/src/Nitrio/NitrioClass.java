package Nitrio;


import java.io.File;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NitrioClass {

public static void main(String[] args) throws InterruptedException{

System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
ChromeOptions options = new ChromeOptions();
options.addExtensions(new File("C://Users/petar/Nitrio-SalesAware_v0.12.1.crx"));
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
@SuppressWarnings("deprecation")
ChromeDriver driver = new ChromeDriver(capabilities);

		//Login (button click)
		driver.findElement(By.className("nitrio-google-login-button")).click();
		
		//Username (pass value)
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("selenium@heytester.org");
	     Thread.sleep(2000);	
		//Next (button click)
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		
		//Password (pass value)
		WebDriverWait waitPass = new WebDriverWait(driver,5);
		WebElement password = waitPass.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name=\"password\"]")));
		password.sendKeys("Selen2018!");
		//Password next (button click)
		driver.findElement(By.id("passwordNext")).click();
		
		//Submit_approve_access (button click)
		WebDriverWait waitConf = new WebDriverWait(driver,5);
		WebElement conf = waitConf.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"submit_approve_access\"]/content")));
		conf.click();
		
		//Recommendation tab (button click)
		Thread.sleep(5000);	
		WebDriverWait waitRecom = new WebDriverWait(driver,5);
		WebElement recomm = waitRecom.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dashboard\"]/div/div[1]/div/nav/div[1]/ul/li[2]/a")));
		recomm.click();
		
		//Add new recommendation (button click)
		WebDriverWait waitNewRecon = new WebDriverWait(driver,5);
		WebElement NewRecomm = waitNewRecon.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[3]/div/div[2]/a")));
		NewRecomm.click();
		
		WebDriverWait waitSubject = new WebDriverWait(driver,5);
		WebElement subject = waitSubject.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nitrio-edit-recommendation-modal\"]/div/div[1]/input")));
		subject.sendKeys("Petar S.");
		
		WebDriverWait waitRec = new WebDriverWait(driver,5);
		WebElement rec = waitRec.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nitrio-edit-recommendation-modal\"]/div/div[2]/textarea")));
		rec.sendKeys("Petar S. Recommendation");
		
		//Auto suggestion
		WebDriverWait waitTop = new WebDriverWait(driver,5);
		WebElement top = waitTop.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nitrio-edit-recommendation-modal\"]/div/div[3]/div/div/input")));
		top.sendKeys("C");
		Thread.sleep(3000);
		//List handling
		List<WebElement> listElement = driver.findElements(By.cssSelector(".nitrio-select-topic-autocomplete"));
		for(int i =0;i<listElement.size();i++) {
		WebElement listSubElement = listElement.get(i).findElement(By.cssSelector(":nth-child(12)"));
		listSubElement.click();
		}
		
		//Save
		Thread.sleep(2000);	
		WebDriverWait waitSave = new WebDriverWait(driver,5);
		WebElement save = waitSave.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nitrio-edit-recommendation-modal\"]/div/button[2]")));
		save.click();
		
		//Delete sub menu (button click)
		Thread.sleep(2000);	
		WebDriverWait waitPrepDel = new WebDriverWait(driver,5);
		WebElement prepDel = waitPrepDel.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[3]/table/tbody/tr[1]")));
		prepDel.click();
		
		//Delete (button click)
		WebDriverWait waitDel = new WebDriverWait(driver,5);
		WebElement Del = waitDel.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[3]/table/tbody/tr[2]/td[2]/div[2]/button[2]")));
		Del.click();
		
		//Accepting alert (button click)
		WebDriverWait waitAlert = new WebDriverWait(driver, 10);
		Alert alert = waitAlert.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		
		//Burger menu (button click)
		WebDriverWait waitBurger = new WebDriverWait(driver,5);
		WebElement Burger = waitBurger.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dashboard\"]/div/div[1]/div/nav/div[2]")));
		Burger.click();
		
		//Logout (button click)
		WebDriverWait waitLogOut = new WebDriverWait(driver,5);
		WebElement LogOut = waitLogOut.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu\"]/div/ul/li[5]/a")));
		LogOut.click();
		
		//Close driver
		Thread.sleep(2000);
		driver.close();
	}
}