package ua.stqa.aqa.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.ContactData;
import ua.stqa.aqa.addressbook.model.Groups;

import java.io.File;

public class ContactCreationTests extends TestBase{
  @Test
  public void testContactCreation(){
    Groups groups=app.db().groups();
    File photo=new File("src/test/resources/Me.png");
    ContactData newContact=new ContactData().withFirstname("test_name")
            .withLastname("test_lastname").withPhoto(photo).inGroup(groups.iterator().next());
    app.goTo().gotoHomePage();
    app.getContactHelper().initContactCreation();

    //app.getContactHelper().fillContactForm(new ContactData().withFirstname("test_name")
        //    .withLastname("test_lastname").withPhoto(photo),true);
    app.contact().fillContactForm(newContact,true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
  @Test // test
  public void testCurrentDir(){
    File currentDir=new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo=new File("src/test/resources/Me.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}

