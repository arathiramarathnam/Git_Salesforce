package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.CreateAccount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountReport extends CreateNewView{
	
	public static void createAccountReport() throws InterruptedException {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//table[@id='toolsContent']//h3[contains(text(),'Reports')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
		Thread.sleep(3000);
		String unsavedreport=driver.findElement(By.xpath("//h2[@class='pageDescription']")).getText();
		System.out.println("Unsaved Report page is displayed----> "+unsavedreport);
		
	}
	
	public static void unsavedreport() throws InterruptedException {
		driver.findElement(By.id("ext-gen140"));
		driver.findElement(By.id("ext-comp-1056"));
		WebElement fromdate=driver.findElement(By.id("ext-comp-1042"));
		fromdate.clear();
		fromdate.sendKeys(from);
/*		driver.findElement(By.id("ext-gen152")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='x-date-active x-date-today x-date-selected']//span[contains(text(),'26')]")).click();
		Thread.sleep(2000);*/
		driver.findElement(By.id("ext-comp-1057"));
		WebElement todate=driver.findElement(By.id("ext-comp-1045"));
		todate.clear();
		todate.sendKeys(to);
/*		driver.findElement(By.id("ext-gen154")).click();
		Thread.sleep(2000);
		WebElement right=driver.findElement(By.xpath("//td[@class='x-date-right']"));
		right.getAttribute("title");
		driver.findElement(By.id("ext-gen288")).click();
		driver.findElement(By.xpath("//table[@id='ext-gen271']//td[@class='x-date-active x-date-today x-date-selected']//a[@class='x-date-date']")).click();*/
		Thread.sleep(2000);
		WebElement datefield=driver.findElement(By.xpath("//input[@id='ext-gen20']"));
		waitForPageElementToVisible(datefield);
		WebElement option=driver.findElement(By.xpath("//div[@class='x-combo-list-item x-combo-selected']//div[contains(text(),'Created Date')]"));
		driver.findElement(By.xpath("//div[@class='x-combo-list-item x-combo-selected']//div[contains(text(),'Created Date')]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("ext-comp-1002"));
		waitForPageElementToVisible(driver.findElement(By.xpath("//table[2]//thead[1]//tr[1]")));
		
		List<WebElement> li_row1 =driver.findElements(By.xpath("//table[2]//thead[1]//tr[1]"));
		for(int count=0;count<li_row1.size();count++) { // row1size =4, 0,1,2,3
		System.out.println(li_row1.get(count).getText()+",");
		}
		List<WebElement> li_row2 =driver.findElements(By.xpath("//table[2]//thead[1]//tr[2]"));
		for(int count=0;count<li_row2.size();count++) {
		System.out.println(li_row2.get(count).getText()+",");
		}
		List<WebElement> li_row3 =driver.findElements(By.xpath("//table[2]//thead[1]//tr[3]"));
		for(int count=0;count<li_row3.size();count++) {
		System.out.println(li_row3.get(count).getText()+",");
		}
		
	Thread.sleep(4000);
	driver.findElement(By.id("//table[@id='saveReportBtn']")).click();
	Thread.sleep(4000);
	}
	

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		verifyAccountsPage();
		createAccountReport();
		unsavedreport();
		Thread.sleep(5000);
		quitBrowser();
	}

}
