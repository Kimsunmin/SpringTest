package com.sun.study;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

	private WebDriver driver;
	private WebElement element;
	
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:\\CODE\\chromedriver.exe"; 
	public static String TEST_URL = "https://github.com/login";
	public static String SELECT_REPOSITORY = "ThreeJsTest";
	public static String ID = "sunmin0406@naver.com";
	public static String PASSWORD = "kim02240@";
	
	public static void main(String[] args) {
		
		Selenium test = new Selenium();

	}
	
	public Selenium() {
		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
		//Driver SetUp
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");

		driver = new ChromeDriver(options); 
		driver.get(TEST_URL);
		

		WebElement login = driver.findElement(By.id("login_field"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[12]"));
		
		
		login.sendKeys(ID);
		password.sendKeys(PASSWORD);
		loginButton.click();
		
		WebElement repositoryInput = driver.findElement(By.xpath("//*[@id=\"dashboard-repos-filter-left\"]"));
		repositoryInput.sendKeys(SELECT_REPOSITORY);
		
		List<WebElement> repositoryList = driver.findElements(By.cssSelector("#repos-container > ul:nth-child(3) li"));
		for (WebElement webElement : repositoryList) {
			if(webElement.getText().contains(SELECT_REPOSITORY)) {
				webElement.click();
				break;
			}
			
		}
		
		WebElement readMe = driver.findElement(By.cssSelector("#readme > div.Box-header.d-flex.flex-items-center.flex-justify-between.color-bg-primary.border-bottom-0 > div > a"));
		readMe.click();
		
		WebElement textArea = driver.findElement(By.xpath("//*[@id=\"new_blob\"]/div/file-attachment/div/div[2]/div/div/div[5]/div[1]/div/div/div/div[5]"));
		List<WebElement> text = textArea.findElements(By.tagName("span"));
		text.get(text.size()-1).sendKeys(" ");
		
		WebElement commit = driver.findElement(By.xpath("//*[@id=\"submit-file\"]"));
		commit.click();
		
		driver.close();
		System.out.println("커밋에 성공했습니다.");
		
		
	}

}
