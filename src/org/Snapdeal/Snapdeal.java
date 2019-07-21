package org.Snapdeal;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\Java\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(3000);
		WebElement txt = driver.findElement(By.xpath("//input[@onkeypress='clickGo(event, this)']"));
		txt.sendKeys("shoes");
		WebElement search = driver.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']"));
		search.click();
		
		WebElement clk = driver.findElement(By.xpath("//img[@title='Action Sneakers Gray Casual Shoes']"));
		Actions acc=new Actions(driver);
		acc.moveToElement(clk).perform();
		clk.click();
		Thread.sleep(3000);
		
		String PID=driver.getWindowHandle();
		System.out.println(PID);
		
		Set <String> allwindows=driver.getWindowHandles();
		System.out.println(allwindows);
		for (String i : allwindows) {
			if (!i.equals(PID)) {
				driver.switchTo().window(i);
				
			}
			
		}
		
		Thread.sleep(3000);
				
		WebElement addtocart = driver.findElement(By.xpath("//div[@catalog='621857239683']"));
		addtocart.click();
		driver.quit();

}
