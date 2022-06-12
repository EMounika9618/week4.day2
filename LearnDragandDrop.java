package week4.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDragandDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//driver.get("http://www.leafground.com/pages/drop.html");// url for drop
		driver.get("http://www.leafground.com/pages/drag.html");// url for drag
		driver.manage().window().maximize();
		WebElement drag = driver.findElement(By.id("draggable"));
		//WebElement drop = driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);
		//builder.dragAndDrop(drag, drop).perform();
		builder.dragAndDropBy(drag, 100, 100).perform();
		Point location = drag.getLocation();//  drag location
		//Point location = drop.getLocation();//  drop location
		System.out.println(location);
		driver.close();

	}
}

