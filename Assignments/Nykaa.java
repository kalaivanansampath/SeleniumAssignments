package com.Leaf.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver2 = new ChromeDriver();
		// EdgeDriver driver2 = new EdgeDriver();
		driver2.manage().window().maximize();
		driver2.get("https://www.nykaa.com/");

		String windowHandle1 = driver2.getWindowHandle();
		driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement brands = driver2.findElement(By.xpath("//a[text()='brands']"));

		Actions action = new Actions(driver2);

		action.moveToElement(brands).perform();
		WebElement lOreal = driver2
				.findElement(By.xpath("//div[@id='scroller-container']//a[text()=\"L'Oreal Paris\"]"));
		lOreal.click();

		String pageTitle = driver2.getTitle();

		if (pageTitle.contains("L'Oreal Paris")) {
			System.out.println("Page Title has: L'Oreal Paris");
		} else {
			System.out.println("Page Title does not has: L'Oreal Paris");
		}

		// *[name()='svg' and @viewBox='0 0 14 8']//*[local-name()='path'][1]
		WebElement sortBy = driver2.findElement(By.xpath("//span[text()='Sort By : popularity']"));

		sortBy.click();

		// WebElement category =
		// driver2.findElement(By.xpath("//span[text()='Category']"));

		WebElement customerTopRated = driver2.findElement(By.xpath("//span[text()='customer top rated']"));

		customerTopRated.click();

		WebElement category = driver2.findElement(By.xpath("//span[text()='Category']"));

		((JavascriptExecutor) driver2).executeScript("arguments[0].scrollIntoView(true);", category);
		action.moveToElement(category).perform();
		category.click();

		// span[text()='Hair']

		WebElement hair = driver2.findElement(By.xpath("//span[text()='Hair']"));
		hair.click();
		WebElement hairCare = driver2.findElement(By.xpath("//ul[@id='custom-scroll']//span[text()='Hair Care']"));
		hairCare.click();
		WebElement shampoo = driver2.findElement(By.xpath("//ul[@id='custom-scroll']//span[text()='Shampoo']"));
		shampoo.click();

		WebElement concern = driver2.findElement(By.xpath("//div[@class='sidebar__inner']//span[text()='Concern']"));

		((JavascriptExecutor) driver2).executeScript("arguments[0].scrollIntoView(true);", concern);

		System.out.println("Test");
		action.moveToElement(concern).perform();
		System.out.println("Test");

		((JavascriptExecutor) driver2).executeScript("arguments[0].click();", concern);

		System.out.println("Concern");

		WebElement colorProtection = driver2
				.findElement(By.xpath("//ul[@id='custom-scroll']//span[text()='Color Protection']"));
		action.moveToElement(concern).perform();
		colorProtection.click();
	}

}
