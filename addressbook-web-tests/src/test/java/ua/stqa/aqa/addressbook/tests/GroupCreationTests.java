package ua.stqa.aqa.addressbook.tests;// Generated by Selenium IDE

import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, "testc"));
  }

}