package ua.stqa.aqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {
  @Test
  public void test0(){
    Equitation e=new Equitation(1,1,1);
    Assert.assertEquals(e.rootNumber(),0);
  }
  @Test
  public void test1(){
    Equitation e=new Equitation(1,2,1);
    Assert.assertEquals(e.rootNumber(),1);
  }
  @Test
  public void test2(){
    Equitation e=new Equitation(1,5,6);
    Assert.assertEquals(e.rootNumber(),2);
  }
  @Test
  public void testLinear(){
    Equitation e=new Equitation(0,5,6);
    Assert.assertEquals(e.rootNumber(),1);
  }
  @Test
  public void testConstant(){
    Equitation e=new Equitation(0,0,1);
    Assert.assertEquals(e.rootNumber(),0);
  }
  @Test
  public void testZero1(){
    Equitation e=new Equitation(0,0,0);
    Assert.assertEquals(e.rootNumber(),-1);
  }

}
