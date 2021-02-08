package ua.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.stqa.aqa.addressbook.model.GroupData;

public class GroupHelper {
  WebDriver driver;
  public GroupHelper(WebDriver driver) {
    this.driver=driver;
  }

  public void returnToGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

  public void submitGroupCreation() {
    driver.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation(String s) {
    driver.findElement(By.name(s)).click();
  }

  public void deleteSelectedGroups() {
    driver.findElement(By.name("delete")).click();
  }

  public void selectGroup() {
    driver.findElement(By.name("selected[]")).click();
  }
}
