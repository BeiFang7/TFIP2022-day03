import java.util.ArrayList;

public class ArrayListExample{ //name of Class same as name of file

  public static void main (String[] args){
    
    System.out.println("Demo");
    
    //Create an ArrayList object
    ArrayList<String> myList = new ArrayList<String>(); 
    //MyIntArrayList myList = new MyIntArrayList() usual way of defining variables
    //Can fixed the type by inserting <String> or any other data types

    //Add items to it
    myList.add("apples");
    myList.add("oranges");

    //Loop over and print the items
    for (String item:myList){
      System.out.println("Item -> "+item);
    }

    //Remove "apples" from the list
    myList.remove("apples");

    //Print the no of item inside the list
    int count = myList.size();
    System.out.println(count);
    
  }
}