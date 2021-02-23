package ua.stqa.aqa.mantis.tests;


import org.testng.annotations.Test;
import ua.stqa.aqa.mantis.appmanager.HttpSession;
import java.io.IOException;
import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase{
  @Test
  public void testLogin() throws IOException {
    HttpSession session= app.newSession();
    assertTrue(session.login("administrator","1111"));
    //assertTrue(session.isLoggedInAs("administrator"));
  }
}
