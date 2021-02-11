package ua.stqa.aqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification (){
    app.getNavigationHelper().gotoGroupPage();
    int before=app.getGroupHelper().getGroupCount();
    if(! app.getGroupHelper().IsThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, "testc"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "after Mod", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();

    int after=app.getGroupHelper().getGroupCount();
    System.out.println(before);
    System.out.println(after);
    Assert.assertEquals(after,before);
  }
}
