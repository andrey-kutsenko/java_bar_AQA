package ua.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


  public SessionHelper(WebDriver driver) {

    super(driver);
  }
  public void login(String username, String password) {
    driver.manage().window().maximize();
    type(By.name("user"),username);
    type(By.name("pass"),password);
    click(By.cssSelector("input:nth-child(7)"));

    //driver.findElement(By.name("user")).click();
    //driver.findElement(By.name("user")).sendKeys(username);
   // driver.findElement(By.name("pass")).click();
    //driver.findElement(By.name("pass")).sendKeys(password);
    //driver.findElement(By.cssSelector("input:nth-child(7)")).click();
  }
}
