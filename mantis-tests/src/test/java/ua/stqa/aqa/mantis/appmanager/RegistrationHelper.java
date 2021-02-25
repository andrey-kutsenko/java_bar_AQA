package ua.stqa.aqa.mantis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    driver.get(app.getProperty("web.BaseURL")+"/signup_page.php");
   // driver.get("http://localhost/mantisbt-1.3.20/signup_page.php");
    type(By.name("username"),username);
    type(By.name("email"),email);
    click(By.cssSelector("input[value='Signup']"));
   // <input type="submit" class="button" value="Зарегистрироваться">  //input[@class='button']
  }
  public void finish(String confirmationLink, String password) {
    driver.get(confirmationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("input[value='Update User']"));
  }
}