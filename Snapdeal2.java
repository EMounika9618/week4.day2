package week4.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		Actions builder=new Actions(driver);
		WebElement men = driver.findElement(By.className("catText"));
		builder.moveToElement(men).perform();
		WebElement shirt = driver.findElement(By.xpath("//a/span[text()='Shirts']"));
		builder.click(shirt).perform();
		WebElement firstShirt = driver.findElement(By.className("product-image"));
		builder.moveToElement(firstShirt).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'Quick')]")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.close();
		
		
	}
	}


