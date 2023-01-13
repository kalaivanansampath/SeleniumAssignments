package com.Leaf.Salesforce;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditTask {

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

		WebElement Sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		Sales.click();

		WebElement Tasks = driver.findElement(By.xpath("//span[text()='Tasks']//parent::a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Tasks);

		WebElement RecentlyViewed = driver
				.findElement(By.xpath("//span[text()='Recently Viewed']//parent::span//parent::h1"));
		RecentlyViewed.click();

		WebElement RecentlyViewedInside = driver
				.findElement(By.xpath("//ul[@aria-label='Tasks | List Views']//span[text()='Recently Viewed']"));
		RecentlyViewedInside.click();

		WebElement BootCamp = driver
				.findElement(By.xpath("//ul[@aria-label='Select an item from this list to open it.']/div[1]"));
		BootCamp.click();

		WebElement BootCampDropDown = driver
				.findElement(By.xpath("//li[@class='slds-button slds-button--icon-border-filled oneActionsDropDown']"));
		BootCampDropDown.click();

		WebElement BootCampEdit = driver.findElement(By.xpath("//a[@title='Edit']"));
		BootCampEdit.click();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		WebElement DatePicker = driver.findElement(By.xpath(
				" //div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']//input[@class='slds-input']"));
		DatePicker.click();
		DatePicker.sendKeys(dtf.format(now));

		WebElement Prioirty = driver
				.findElement(By.xpath("(//div[@data-aura-class='uiPopupTrigger']//a[@class='select'])[2]"));
		Prioirty.click();

		WebElement PrioirtyLow = driver.findElement(By.xpath("//a[text()='Low']//parent::li"));
		PrioirtyLow.click();

		WebElement EditSave = driver.findElement(By.xpath("//span[text()='Save']"));
		EditSave.click();

		String ExpectedText ="Bootcamp";
		WebElement SubjectText = driver.findElement(By.xpath(
				"//span[text()='Bootcamp']//parent::span[@class='test-id__field-value slds-form-element__static slds-grow ']"));
		String ActualText = SubjectText.getText();
		System.out.println(ActualText);
		if(ActualText.equals(ExpectedText)) {
			System.out.println("Subject is BootCamp");
		}
		else {
			System.out.println("Subject is not BootCamp");
		}
	}
}
