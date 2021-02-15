package ua.stqa.aqa.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.GroupData;
import ua.stqa.aqa.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size()==0) {
      app.group().create(new GroupData().withName("test"));
    }
  }

  @Test
  public void testGroupModification (){
    Groups before=app.group().all();
    GroupData modifiedGroup=before.iterator().next();
    //int index=before.size()-1;
    GroupData group = new GroupData().withId(modifiedGroup.getId())
            .withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(modifiedGroup);
    Groups after=app.group().all();
    //int before=app.getGroupHelper().getGroupCount();
    //int after=app.getGroupHelper().getGroupCount();
    System.out.println(before.size());
    System.out.println(after.size());
    //Assert.assertEquals(after.size(),before.size());

    //before.remove(modifiedGroup);
    //before.add(group);

/*    Comparator<? super GroupData> byId=(g1,g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<GroupData>(after),new HashSet<GroupData>(before));*/

    //Assert.assertEquals(before,after);
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
