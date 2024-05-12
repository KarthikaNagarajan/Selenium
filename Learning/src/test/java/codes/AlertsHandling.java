package codes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandling{
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		
		//Alert with only OK
		WebElement simple = driver.findElement(By.id("j_idt88:j_idt91"));
		simple.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement simpleResult = driver.findElement(By.xpath("//span[@id='simple_result']"));
		System.out.println(simpleResult.getText());
		
		//Alert dismiss
		WebElement confirm = driver.findElement(By.id("j_idt88:j_idt93"));
		confirm.click();
		alert.dismiss();
		WebElement result = driver.findElement(By.xpath("//span[@id='result']"));
		System.out.println(result.getText());
		
		//Modal dialog dismissal
		WebElement modal = driver.findElement(By.id("j_idt88:j_idt100"));
		modal.click();
		WebElement modalClose = driver.findElement(By.xpath("//div[@id='j_idt88:j_idt101']/*/a"));
		modalClose.click();
		
		//Prompt user input , accept, dismiss
		WebElement prompt = driver.findElement(By.id("j_idt88:j_idt104"));
		prompt.click();
		alert.sendKeys("Hi Karthi");
		alert.accept();
		WebElement userInput = driver.findElement(By.id("confirm_result"));
		System.out.println(userInput.getText());
		
		WebElement promptDismiss = driver.findElement(By.id("j_idt88:j_idt104"));
		prompt.click();
		alert.dismiss();
		WebElement userInputDismiss = driver.findElement(By.id("confirm_result"));
		System.out.println(userInput.getText());
		
		driver.close();
	}
}
