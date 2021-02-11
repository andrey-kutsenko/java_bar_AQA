package ua.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.stqa.aqa.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    /*if(creation) {
      //new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      new Select(driver.findElement(By.cssSelector("[name='new_group']"))).selectByVisibleText(contactData.getGroup());
    } else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
       //              [name='new_group']            //select[@name='new_group']
*/
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void initContactModification() {
    click(By.cssSelector("tr:nth-child(2) > .center:nth-child(8) img")); //Se working !
     //click(By.cssSelector("[alt='Edit']"));    //from POM css working !
     // click(By.xpath(" //img[@alt='Edit']"));   //from POM xpath working !
  }

  public void submitContactModification() {
    //click(By.name("update")); By.cssSelector("input:nth-child(86)")
    click(By.cssSelector("input:nth-child(86)"));
  }
}
