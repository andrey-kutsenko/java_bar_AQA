package ua.stqa.aqa.mantis.appmanager;

import org.openqa.selenium.WebDriver;

public class RegistrationHelper {
  private final ApplicationManager app;
  private WebDriver driver;

  public RegistrationHelper(ApplicationManager app) {
    this.app=app;
    driver=app.getDriver();
  }

  public void start(String username, String email) {
    driver.get(app.getProperty("web.BaseURL")+"/signup_page.php");
   // driver.get("http://localhost/mantisbt-1.3.20/signup_page.php");
  }
}
