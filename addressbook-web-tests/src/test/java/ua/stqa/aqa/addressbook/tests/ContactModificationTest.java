package ua.stqa.aqa.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test(enabled = false)
  public void testContactModification() {
    app.goTo().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(null,false);
    //app.getContactHelper().fillContactForm(new ContactData(1, "test_surname - M",null),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
