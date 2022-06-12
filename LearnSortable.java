package week4.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		//driver.switchTo().frame(0);
		//WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		//WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		//Actions builder = new Actions(driver);
		//builder.dragAndDrop(item5, item2).perform();
		WebElement item7 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 7']"));
		WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 1']"));
		Actions builder = new Actions(driver);
		builder.clickAndHold(item7).moveToElement(item1).release().perform();
		Thread.sleep(3000);
		driver.close();

	}

}

