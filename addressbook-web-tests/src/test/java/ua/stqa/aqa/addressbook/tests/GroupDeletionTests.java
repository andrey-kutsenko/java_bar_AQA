package ua.stqa.aqa.addressbook.tests;// Generated by Selenium IDE

import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().IsThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, "testc"));
    }


    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}