package com.mcgenerator.mcgenerator.service;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.mcgenerator.mcgenerator.Utils.generateRandom;
import static com.mcgenerator.mcgenerator.Utils.randomIdentifier;

@Service
@Slf4j
public class McService {
	private ChromeDriver driver;

	private static String IS_VISIBLE = " and not(ancestor::div[contains(@style,'display:none')]) and not(ancestor::div[contains(@style,'display: none')])]";

	public void attempt() {
		String exePath = "C:\\Users\\Adams\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		driver = new ChromeDriver();

		driver.get("http://www.mcexperiencia.com.br/");
		log.info("Loaded2");
		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame("iframelanding");
		clickNext();
		CNPJ();
		info();
		compraRealizada();
		setorPedido();
		satisfacao();
		satisfacao2();
		quantaSatisfacao();
		ACABO();
	}

	public void clickNext() {
		log.info("advancing");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("movenextbtn")));
		driver.findElement(By.id("movenextbtn")).click();
	}

	public void clickNext(String xpath) {
		log.info("advancing");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void CNPJ() {
		log.info("firstPage");
		driver.findElementById("cnpj").sendKeys("42.591.651/0895-35");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickNext();
	}

	private void info() {
		driver.findElementByCssSelector("#NTKT > input.input-text").sendKeys(generateRandom(99999).toString());
		Select day = new Select(driver.findElement(By.className("input-day")));
		day.selectByIndex(generateRandom(31));
		Select month = new Select(driver.findElement(By.className("input-month")));
		month.selectByIndex(generateRandom(12));
		Select year = new Select(driver.findElement(By.className("input-year")));
		year.selectByIndex(1);
		Select hours = new Select(driver.findElement(By.className("input-hours")));
		hours.selectByIndex(generateRandom(24));
		Select minutes = new Select(driver.findElement(By.className("input-minutes")));
		minutes.selectByIndex(generateRandom(60));
		clickNext();
	}

	private void compraRealizada() {
		clickNext("//input[@value='Y' and not(ancestor::div[contains(@style,'display:none')]) and not(ancestor::div[contains(@style,'display: none')])]/..");
	}

	private void setorPedido() {
		driver.findElementsByXPath("//*[contains(text(),'Drive Thru')]").get(0).click();
		driver.findElementsByXPath("//*[contains(text(),'Comprou para levar')]").get(0).click();
		driver.findElementsByXPath("//*[contains(text(),'Só eu')]").get(0).click();
		clickNext();
		//*[contains(@class,"question-title-container")]//*[@value="4" and not(@type="hidden")]
	}

	private void satisfacao() {
		muitoSatisfeito();
		driver.findElementByXPath("//textarea").sendKeys("a");
		clickNext();
	}

	private void satisfacao2() {
		muitoSatisfeito();
		muitoSatisfeito();
		driver.findElementByXPath("//li[@id='qw-2']//div[contains(@class, 'yes-option')]").click();
	}
	private void quantaSatisfacao() {
		muitoSatisfeito();
		muitoSatisfeito();
		muitoSatisfeito();
		muitoSatisfeito();
		muitoSatisfeito();
		muitoSatisfeito();
		muitoSatisfeito();
		muitoSatisfeito();
		muitoSatisfeito();
		driver.findElementByXPath("//li[contains(@style, 'display: list-item')]//div[contains(@class, 'option-view answer_cell_0011')]").click();
		clickNext("//input[@value='N' and not(ancestor::div[contains(@style,'display:none')]) and not(ancestor::div[contains(@style,'display: none')])]/..");
	}

	private void ACABO(){
		driver.findElementByXPath("//input[@type='email']").sendKeys("adamsvcs@gmail.com");
		driver.findElementsByXPath("//input[@type='text']").get(0).sendKeys(randomIdentifier());
		driver.findElementsByXPath("//div[@data-toggle='buttons']//input").get(generateRandom(1)).click();
		driver.findElementByClassName("form-control text numeric integeronly empty em_sq_validation good").click();
		clickNext();
	}

	private void muitoSatisfeito() {
		driver.findElementsByXPath("//li[contains(@style, 'display: list-item')]//div[contains(@class, 'answer_cell_005')]").get(0).click();
	}

}

/*
$x("//li[@id='qw-2']//div[contains(@class, 'yes-option')]")[0].click()
$x("//li[contains(@style, 'display: list-item')]//div[contains(@class, 'option-view answer_cell_0011')]").click()

* */