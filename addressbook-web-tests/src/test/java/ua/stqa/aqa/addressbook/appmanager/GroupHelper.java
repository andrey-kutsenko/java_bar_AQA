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
    click(By.name("edit"));

    //click(By.cssSelector(input[3]));
    //click(By.xpath("form[action='/addressbook/group.php'] > input:nth-of-type(3)"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
   //input[@name='update'] [name='update']
  }
}
