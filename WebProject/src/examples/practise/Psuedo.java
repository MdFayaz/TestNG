package examples.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Psuedo {
	static String PASS = "as#$#3rdf";
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Fayaz\\Downloads\\chromedriver.exe");
		/*RemoteWebDriver driver = new ChromeDriver();
		
		
//	WebDriver.Options a =(WebDriver.Options)driver;
//	a.window();
	
//	driver.switchTo().window("");
		
//		ChromeDriverService.Builder cds = new ChromeDriverService.Builder();
//		cds = cds.usingPort(5784);
//		WebDriver driver = new ChromeDriver(cds.build());
		
//		driver.get("C:\\Users\\Fayaz\\Desktop\\Irctc\\TrainsList_Classic.html");
		WebDriver driver = new HtmlUnitDriver();
//		driver.switchTo().window("Inbox - mdfayaz6138@gmail.com - Gmail");
		System.out.println("window handle: "+ driver.getWindowHandle());
		System.out.println(driver.getWindowHandles().size());
		System.out.println(driver.getTitle());*/
		
		
		driver = new ChromeDriver();
//		WebDriverBackedSelenium wdbs = new WebDriverBackedSelenium(driver, "http://");
		driver.get("http://www.gmail.com");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("mdfayaz6138");
		driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys(PASS);
		driver.findElement(By.xpath("//input[@id='signIn']")).click();
		driver.manage().window().maximize();
		try {
			waitForLoad();
			WebDriverWait driverWait = new WebDriverWait(driver, 10000);
			WebElement elementFound = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='CJ']")));
			elementFound.click();
			WebElement label = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
					"div[class$='aio aip'] span[class^='nU'] a[title*='ICICI']")));
			System.out.println(label.isDisplayed() + " -- "+label.getText());
			Actions action = new Actions(driver);
			Thread.sleep(1000 * 10);
			action.click(label);
			System.out.println("Action key down executed");
			Thread.sleep(1000 * 10);
			action.moveToElement(label).click();
			System.out.println(label.isSelected());
			System.out.println("Action moved to element executed");
			Thread.sleep(1000 * 10);
			driver.findElement(By.cssSelector("div.Cp td[class^='yf']")).click();
			System.out.println("**** Script ended ****");
//			 driver.findElement(By.xpath("(//div[@class='aj9 pp']/div/div)[1]/div[2]/div/div[2]/span/span[2]/div[@class='G-asx T-I-J3 J-J5-Ji']")).click();
		/*	driver.findElement(By.xpath("//span[@class='CJ']")).click();
			Thread.sleep(1000 * 10);
//			driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/?shva=1#label/ICICI+Mutual+Funds']")).click();
//			driver.findElement(By.xpath("//a[@title='ICICI Mutual Funds']")).click();
//			driver.findElement(By.xpath("//div[@class='aio aip']")).click();
//			driver.findElement(By.cssSelector("div[class^='n3'] a:nth-of-type(1)[title*='ICICI']")).click();
			Thread.sleep(1000 * 10);
//			driver.findElement(By.xpath("//div[@class='aio aip']/span[@class='nU ']/a[contains(text(), 'ICICI')]")).click();
//			driver.findElement(By.cssSelector("div[class$='aio aip'] span[class^='nU'] a[title*='ICICI']")).click();
			driver.findElement(By.cssSelector("input#gbqfq")).sendKeys("label:icici-mutual-funds");
			driver.findElement(By.cssSelector("input#gbqfq")).sendKeys(Keys.RETURN);
			driver.findElement(By.cssSelector("div.Cp td[class^='yf']")).click();
			driver.findElement(By.cssSelector("div[class^='ajl']>div>div[id$='l8']>div a[title~='ICICI']"));*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void waitForLoad() {
	    ExpectedCondition<Boolean> pageLoadCondition = new
	        ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	            }
	        };
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(pageLoadCondition);
	}
}
