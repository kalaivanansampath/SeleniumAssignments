package com.Leaf.Salesforce;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import junit.framework.Assert;

public class CreateTask {
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();

		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement Userlo = driver.findElement(By.id("username"));
		Userlo.sendKeys("hari.radhakrishnan@qeagle.com");
		WebElement UserPs = driver.findElement(By.id("password"));
		UserPs.sendKeys("Testleaf$321");
		WebElement Logo = driver.findElement(By.id("Login"));
		Logo.click();

		WebElement Globe = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		Globe.click();

		WebElement ViewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		ViewAll.click();

		WebElement Search = driver.findElement(By.xpath("//input[@class='slds-input']"));
		Search.click();
		Search.sendKeys("task");

		WebElement ClickTask = driver.findElement(By.xpath("//mark[text()='Task']"));
		ClickTask.click();

		WebElement TaskDropdown = driver.findElement(By.xpath("//li[@class='oneActionsDropDown']"));
		TaskDropdown.click();

		WebElement NewTask = driver.findElement(By.xpath("//li[@role='presentation']//a[@title='New Task']"));
		NewTask.click();

		WebElement EnterSubject = driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']"));
		EnterSubject.click();
		EnterSubject.sendKeys("Bootcamp");

		WebElement StatusDropDown = driver.findElement(By.xpath("(//a[@class='select'])[1]/parent::div"));
		StatusDropDown.click();

		WebElement StatusDrop = driver.findElement(
				By.xpath("//ul[@role='presentation']/following::li/following::a[@title='Waiting on someone else']"));
		StatusDrop.click();
		
		WebElement Save = driver.findElement(By.xpath("//button[@title='Save']"));
		Save.click();
		
		// Alert Message (Expected Text)
		String expectedAlertMessage = "Task Bootcamp was created.";
		String actualText = driver.findElement(By.xpath("//a[@class='forceActionLink']/parent::span")).getText();
		System.out.println(actualText);
		System.out.println("ttttttttttttt" + actualText);
		// Assertion
		Assert.assertEquals(expectedAlertMessage, actualText);

		if (expectedAlertMessage == actualText) {
			System.out.println("Task Created");
		} else {
			System.out.println("Not Created");
		}

		Assertions.assertEquals(expectedAlertMessage, actualText);

	}

}
