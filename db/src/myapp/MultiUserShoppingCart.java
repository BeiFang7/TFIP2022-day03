package myapp;

public class MultiUserShoppingCart{
  public static void main(String[] args){


    ShoppingCartDB cart = new ShoppingCartDB("cartdb"); //default folder: "db", using class ShoppingCartDB
    //cart.setup();
    cart.startShell();
    
  }
}