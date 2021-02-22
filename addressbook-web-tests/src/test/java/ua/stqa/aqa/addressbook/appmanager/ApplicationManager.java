package ua.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
  private final Properties properties;
  WebDriver driver;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private String browser;
  private ContactHelper contactHelper;
  private DbHelper dbHelper;

  public ApplicationManager(String browser){

    this.browser = browser;
    properties=new Properties();
  }

  public void init() throws IOException {
    String target=System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

    dbHelper=new DbHelper();

    if (browser.equals(BrowserType.CHROME)){
      driver=new ChromeDriver();
    }
    else if(browser.equals(BrowserType.FIREFOX)){
      driver=new FirefoxDriver();
    }
    else if(browser.equals(BrowserType.IE)){
      driver=new InternetExplorerDriver();
    }
    //driver.get("http://localhost/addressbook/");
    driver.get(properties.getProperty("web.BaseURL"));
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper=new SessionHelper(driver);
    contactHelper=new ContactHelper(driver);
    //sessionHelper.login("admin", "secret");
    sessionHelper.login(properties.getProperty("web.adminlogin"),properties.getProperty("web.adminPassword"));


  }
  public void stop() {
    driver.quit();
  }

  public GroupHelper group() {
    return groupHelper;
  }
  public NavigationHelper goTo() {
    return navigationHelper;
  }
  public ContactHelper contact() {
    return contactHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
  public DbHelper db() {
    return dbHelper;
  }
}
