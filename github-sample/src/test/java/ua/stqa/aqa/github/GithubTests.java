package ua.stqa.aqa.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.aspects.Immutable;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("8edbb6fcaa751d8cc3b99649ba472b7633c76632");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("andrey-kutsenko", "java_bar_AQA"))
            .commits();
    for(RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String,String>().build())){
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
