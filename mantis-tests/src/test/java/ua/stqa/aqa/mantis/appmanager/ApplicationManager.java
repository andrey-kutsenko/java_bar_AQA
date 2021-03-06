package ua.stqa.aqa.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {

  private final Properties properties;
  private WebDriver driver;
  private String browser;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftp;
  private MailHelper mailHelper;
  private SoapHelper soapHelper;

  public ApplicationManager(String browser){
    this.browser = browser;
    properties=new Properties();
  }
  public void init() throws IOException {
    String target=System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
  }
  public void stop() {
    if(driver!=null){
      driver.quit();
    }
  }
  public HttpSession newSession(){
    return new HttpSession(this);
  }
  public String getProperty(String key){
    return properties.getProperty(key);
  }

  public RegistrationHelper registration() {
    if(registrationHelper ==null){
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }
  public FtpHelper ftp(){
    if(ftp==null){
      ftp=new FtpHelper(this);
    }
    return ftp;
  }
  public MailHelper mail(){
    if(mailHelper==null) {
      mailHelper = new MailHelper(this);
    }
    return mailHelper;
  }

  public SoapHelper soap(){
    if(soapHelper==null){
      soapHelper=new SoapHelper(this);
    }
    return soapHelper;
  }

  public WebDriver getDriver() {
    if(driver==null){
      if (browser.equals(BrowserType.CHROME)){
        driver=new ChromeDriver();
      }
      else if(browser.equals(BrowserType.FIREFOX)){
        driver=new FirefoxDriver();
      }
      else if(browser.equals(BrowserType.IE)){
        driver=new InternetExplorerDriver();
      }
      driver.get(properties.getProperty("web.BaseURL"));
    }
    return driver;
  }
}
