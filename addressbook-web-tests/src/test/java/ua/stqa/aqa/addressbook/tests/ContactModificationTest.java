package ua.stqa.aqa.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test_name - M", "test_surname - M",null),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
