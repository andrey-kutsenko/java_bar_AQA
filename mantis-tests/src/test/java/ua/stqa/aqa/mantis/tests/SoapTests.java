package ua.stqa.aqa.mantis.tests;


import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.aqa.mantis.model.Issue;
import ua.stqa.aqa.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;

import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase {

  @Test(enabled = true)
  public void testGetProjects() throws RemoteException, MalformedURLException, ServiceException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for(Project project: projects){
      System.out.println(project.getName());
    }
  }
  @Test(enabled = true)
  public void testCreateIssue()throws RemoteException, MalformedURLException, ServiceException{
    Set<Project> projects = app.soap().getProjects();
    Issue issue=new Issue().withSummary("Test issue").
            withDescription("Test issue description").withProject(projects.iterator().next());
    Issue created=app.soap().addIssue(issue);
    Assert.assertEquals(issue.getSummary(),created.getSummary());



  }

}
