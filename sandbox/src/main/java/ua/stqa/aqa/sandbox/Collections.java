package ua.stqa.aqa.sandbox;

import javax.security.auth.callback.LanguageCallback;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main (String[] args){
    String[] langs= {"Java","C","C++","Ruby"};

    List languages= Arrays.asList("Java","Python",1);


    for(Object l:languages){
      System.out.println("Я учу "+l);
    }

  }
}
