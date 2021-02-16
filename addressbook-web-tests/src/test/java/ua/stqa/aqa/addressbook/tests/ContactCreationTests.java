package ua.stqa.aqa.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{
  @Test(enabled = false)
  public void testContactCreation(){
    app.goTo().gotoHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData(),true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
