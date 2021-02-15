package ua.stqa.aqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size()==0) {
      app.group().create(new GroupData().withName("test"));
    }
  }

  @Test
  public void testGroupModification (){
    List<GroupData> before=app.group().list();
    int index=before.size()-1;
    GroupData group = new GroupData().withId(before.get(index).getId())
            .withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(index, group);
    List<GroupData> after=app.group().list();
    //int before=app.getGroupHelper().getGroupCount();
    //int after=app.getGroupHelper().getGroupCount();
    System.out.println(before.size());
    System.out.println(after.size());
    //Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(group);

    Comparator<? super GroupData> byId=(g1,g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(new HashSet<GroupData>(after),new HashSet<GroupData>(before));
    Assert.assertEquals(before,after);
  }


}
