import java.util.ArrayList;
import java.util.HashMap;

public class HashMapExample {

  public static void main (String[] args){

    //Key / Value type
    //String / Integer

    HashMap<String,Integer> myMap = new HashMap <String,Integer>();

    //Add a key, value pair to it
    myMap.put("Bala",30);
    myMap.put("Ken",40);

    //Get the value if know the key
    String key = "Bala";
    System.out.println("Value for key = " + key + " -> " + myMap.get(key));

    //Assign a different value for a previous existing key
    myMap.put("Bala", 31);
    System.out.println("New Value for key = " + key + " -> " + myMap.get(key));

    //check if a key exists in map
    System.out.println("Check if Fred exists: " + myMap.containsKey("Fred"));


    //Change value using ArrayList<String> type

    //Key / Value type
    //String / ArrayList<String> (string of arraylist)
    HashMap<String,ArrayList<String>> userMap = new HashMap <String,ArrayList<String>>();

    //Add a key, value pair to it
    userMap.put("Bala",new ArrayList<>()); //to define new ArrayList as value that is empty
    userMap.put("Fred",new ArrayList<>());
    userMap.put("Ken",new ArrayList<>());


  }
}

