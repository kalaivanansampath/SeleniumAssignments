package com.Leaf.Assignments;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrainNamesUnique {

	public static void main(String[] args) {
		ChromeDriver driver2 = new ChromeDriver();
		driver2.manage().window().maximize();
		driver2.get("https://erail.in/");

		String windowHandle1 = driver2.getWindowHandle();

		WebElement stationFrom = driver2.findElement(By.xpath("//input[@id='txtStationFrom']"));
		stationFrom.clear();
		stationFrom.click();
		stationFrom.sendKeys("MS");
		stationFrom.sendKeys(Keys.TAB);

		WebElement stationTo = driver2.findElement(By.xpath("//input[@id='txtStationTo']"));
		stationTo.clear();
		stationTo.click();
		stationTo.sendKeys("MDU");
		stationTo.sendKeys(Keys.TAB);

		driver2.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();

		// WebElement tableText =
		// driver2.findElement(By.xpath("//div[@id='divTrainsList']/table[1]/tbody/tr[2]/td[2]"));

		List<WebElement> findRows = driver2.findElements(By.xpath("//div[@id='divTrainsList']/table[1]/tbody/tr"));

		Set<String> unique = new LinkedHashSet<String>();

		for (int i = 2; i <= findRows.size(); i++) {

			String rowValue = driver2
					.findElement(By.xpath("//div[@id='divTrainsList']/table[1]/tbody/tr[" + i + "]/td[2]")).getText();

			if (!(unique.add(rowValue))) {
				System.out.println("Duplicate available: ");
				break;
			}
		}
		System.out.println(unique);
		System.out.println("Test");
		driver2.close();

	}

}
