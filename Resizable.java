package week4.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//load URL
		driver.get("https://jqueryui.com/resizable");
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		System.out.println("Heading:"+driver.findElement(By.tagName("h3")).getText());
		WebElement element = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		Actions builder=new Actions(driver);
		builder.clickAndHold(element).moveByOffset(200,220).release();
		int height1 = element.getSize().getHeight();
		int width1 = element.getSize().getWidth();
		System.out.println("Resized Value "+height1+" "+width1);
		Thread.sleep(2000);
		//driver.close();
	}

}
