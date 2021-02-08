package ua.stqa.aqa.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    driver.manage().window().maximize();
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.cssSelector("input:nth-child(7)")).click();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }

  protected void returnToGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

  protected void submitGroupCreation() {
    driver.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupData groupData) {
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  protected void initGroupCreation(String s) {
    driver.findElement(By.name(s)).click();
  }

  protected void gotoGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

  protected void deleteSelectedGroups() {
    driver.findElement(By.name("delete")).click();
  }

  protected void selectGroup() {
    driver.findElement(By.name("selected[]")).click();
  }
}
