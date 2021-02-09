package ua.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.stqa.aqa.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {
  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  public void returnToGroupPage() {
    click(By.linkText("groups"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation(String s) {
    click(By.name(s));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    //click(By.name("edit")); //working
    //click(By.cssSelector("form[action='/addressbook/group.php'] > input:nth-of-type(3)")); //working
    click(By.xpath("//input[3]"));
    // css: form[action='/addressbook/group.php'] > input:nth-of-type(3)
    // xpath: //input[3]
  }

  public void submitGroupModification() {
    /*
    click(By.name("update")); - working
    click(By.xpath("//input[@name='update']")); -working
    xp: //input[@name='update']        css: [name='update'] - from POM builder
    */
    click(By.cssSelector("[name='update']"));

  }
}
