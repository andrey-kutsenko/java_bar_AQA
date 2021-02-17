package ua.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.stqa.aqa.addressbook.model.GroupData;
import ua.stqa.aqa.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;

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

  public void selectGroup(int index) {
    driver.findElements(By.name("selected[]")).get(index).click();
    //click(By.name("selected[]"));
  }
  public void selectGroupById(int id) {
    driver.findElement(By.cssSelector("input[value='"+id+"']")).click();
  }

  public void initGroupModification() {
    click(By.name("edit")); //working
    //click(By.cssSelector("form[action='/addressbook/group.php'] > input:nth-of-type(3)")); //working
   // click(By.xpath("//input[3]"));
    // css: form[action='/addressbook/group.php'] > input:nth-of-type(3)
    // xpath: //input[3]
  }

  public void submitGroupModification() {

    click(By.name("update")); //- working
     /*
    click(By.xpath("//input[@name='update']")); -working
    xp: //input[@name='update']        css: [name='update'] - from POM builder
    */
    //click(By.cssSelector("[name='update']"));
  }
  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCache=null;
    returnToGroupPage();
  }
  public void delete(int index) {
    selectGroup(index);
    deleteSelectedGroups();
    returnToGroupPage();
  }
  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    groupCache=null;
    returnToGroupPage();
  }

  public void create(GroupData group) {
    initGroupCreation("new");
    fillGroupForm(group);
    submitGroupCreation();
    groupCache=null;
    returnToGroupPage();
  }

  public boolean IsThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return driver.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> list() {
    List<GroupData> groups=new ArrayList<GroupData>();
    List<WebElement> elements=driver.findElements(By.cssSelector("span.group"));
    for(WebElement elem:elements){
      String name=elem.getText();
      int id=Integer.parseInt(elem.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }
  private Groups groupCache=null;

  public Groups all() {
    if(groupCache!=null){
      return new Groups(groupCache);
    }
    groupCache=new Groups();
    List<WebElement> elements=driver.findElements(By.cssSelector("span.group"));
    for(WebElement elem:elements){
      String name=elem.getText();
      int id=Integer.parseInt(elem.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);
  }
}
