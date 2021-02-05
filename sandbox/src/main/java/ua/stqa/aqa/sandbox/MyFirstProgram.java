package ua.stqa.aqa.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("Andrey");
    hello("World");


    Square s=new Square(9);
    Rectangle r=new Rectangle(5,8);




    System.out.println(r.area());
    System.out.println(s.area());
  }
  public static void hello(String somebody){
    System.out.println("Hello, "+somebody+"!");
  }



}