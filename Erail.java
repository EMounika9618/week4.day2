package week4.Day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in");
		driver.manage().window().maximize();
		// Enter From Station
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MS");
		Thread.sleep(1000);
		from.sendKeys(Keys.TAB);
		// Enter To Station
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU");
		Thread.sleep(1000);
		to.sendKeys(Keys.TAB);
		// Deselect sortOnDate checkbox
		driver.findElement(By.id("chkSelectDateOnly")).isSelected();
		Thread.sleep(2000);
		List<WebElement> name = driver.findElements(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader'//tr]"));
		System.out.println(name);
		//WebElement table = driver.findElement(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']"));
		int size=driver.findElements(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr")).size(); 
		// Get the train names
		List<String> trainNames = new ArrayList<String>();
		System.out.println(trainNames);
		for(int i=1; i<size; i++)
		{
		     String text = driver.findElement(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader'//tr["+i+"]//td[2]")).getText();

			trainNames.add(text);
		}
		// Ensure Train names are not duplicated
		Set<String> setTrainNames = new HashSet<String>(trainNames);
		if(trainNames.size() == setTrainNames.size()) 
		{
			System.out.println("No Duplicates");
			System.out.println(setTrainNames.size());
			System.out.println(setTrainNames);
		} 
		else 
		{
			System.out.println("Duplicates found");
		}
		Thread.sleep(2000);
		driver.close();

	}
}