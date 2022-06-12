package week4.Day2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LearnWebTable 
{
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		int colSize = driver.findElements(By.xpath("//table//tr//th")).size();
		System.out.println(colSize);
		// number of rows
		int rowSize = driver.findElements(By.xpath("//table//tr")).size();
		System.out.println(rowSize);
		List<WebElement> ele = driver.findElements(By.xpath("//*[@class='even']/td[2]"));
		for (int i = 0; i < ele.size(); i++) 
		{
			String progress = ele.get(i).getText();
			System.out.println(driver.findElement(By.xpath("//td/font"))+":"+progress);

		}
		for(int i=2; i<= rowSize; i++) 
		{
			for (int j=1; j<=colSize; j++) 
			{
				String text = driver.findElement(By.xpath("//table//tr[" + i + "]/td[" + j + "]")).getText();
				System.out.println(text);
				driver.findElement(By.name("vital")).click();
			}
		}
		Thread.sleep(2000);
		driver.close();

	}
}