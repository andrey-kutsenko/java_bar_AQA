package ua.stqa.aqa.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hibernate.action.internal.CollectionRemoveAction;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ua.stqa.aqa.addressbook.appmanager.ApplicationManager;
import ua.stqa.aqa.addressbook.model.GroupData;
import ua.stqa.aqa.addressbook.model.Groups;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TestBase {
  Logger logger= LoggerFactory.getLogger(TestBase.class);
  protected static final ApplicationManager app =
          new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[]p){
    logger.info("Start test "+m.getName()+" with parameteres "+ Arrays.asList(p));
  }
  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop test "+m.getName());
  }

  public void verifyGroupListInUI() {
    if(Boolean.getBoolean("verifyUI")){
      Groups dbGroups=app.db().groups();
      Groups uiGroups=app.group().all();
      MatcherAssert.assertThat(uiGroups, CoreMatchers.equalTo(dbGroups.stream()
              .map ((g)->new GroupData().withId(g.getId())
                      .withName(g.getName())).collect(Collectors.toSet())));
    }

  }

}
