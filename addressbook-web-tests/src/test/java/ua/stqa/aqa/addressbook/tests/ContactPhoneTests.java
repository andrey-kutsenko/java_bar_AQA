package ua.stqa.aqa.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
  @Test
  public void testContactPhone(){
    app.goTo().gotoHomePage();
    ContactData contact=app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm=app.contact().InfoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    //assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
    //assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
    System.out.println(contact.getAllPhones());
    System.out.println(mergePhones(contactInfoFromEditForm));
  }
  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s)->!s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }
  public static String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
