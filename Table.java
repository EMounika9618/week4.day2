package week4.Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Table {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//row size
				int rowSize = driver.findElements(By.xpath("//table//tr")).size();
				System.out.println(rowSize);
		//col size
		int colSize = driver.findElements(By.xpath("//table//tr//th")).size();
		System.out.println(colSize);
		
		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='even']/td[2]"));
		for (int i = 0; i < elements.size(); i++) {
			String str = elements.get(i).getText();
			System.out.println(" interact with Elements is  " + str);
		}
	}
}
