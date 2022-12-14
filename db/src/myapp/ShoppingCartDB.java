package myapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartDB {
  
  public static final String LOGIN = "login"; //these strings will not change, minimise mistakes
  public static final String ADD = "add";
  public static final String LIST = "list";
  public static final String EXIT = "exit";
  public static final String USERS ="users";
  public static final String DELETE = "delete";
  public static final String SAVE = "save";
  
  public static final List<String> VALID_COMMANDS = Arrays.asList(LOGIN, ADD, LIST, EXIT, USERS, DELETE, SAVE); //define CONSTANTS publicly valid commands because not going to change anymore, will be fully UperrCase
  
  private CartDBInMemory db;

  public String currentUser;

  public String baseFolder;

  public ShoppingCartDB(){
    this.baseFolder = "db"; //default
    this.setup();
    this.db = new CartDBInMemory(this.baseFolder);
  }

  public ShoppingCartDB(String baseFolder){
    this.baseFolder = baseFolder;
    this.setup();
    this.db = new CartDBInMemory(this.baseFolder);
  }

  public void setup(){
    Path p = Paths.get(this.baseFolder);
    File f = p.toFile();
    if (f.isDirectory()){ //OR if (Files.isDirectory(p))
      //SKIP if directory already exists
    } else{
      //create the directory
      try{
        Files.createDirectory(p);
      } catch (IOException e){
        System.out.println("Error: "+e.getMessage());
      }
      
    }
  }


  public void startShell(){
    System.out.printf("Welcome to MultiUser Shopping Cart. \n> ");

    //Scanner - to get user input
    Scanner sc = new Scanner (System.in);
    String line;
    Boolean stop = false;

    while(!stop) { 
      line = sc.nextLine(); //scanner to read the entire line
      line = line.trim();
      System.out.println("> " + line);

      if(line.equalsIgnoreCase(EXIT)){
        System.out.println("Byebye!");
        stop = true;
        //break; //if dont have, will still run the ValidateInput line below because stop = true only goes out of the if look.
      }

      //Validate COmmand
      if(!this.ValidateInput(line)){
        System.out.printf("Invalid Input! \n> ");
      } else{
        System.out.printf("Processing: " + line + "\n> ");
        this.ProcessInput(line);
      }
    }
    sc.close();
  }
    //validate command
    //process command

  public boolean ValidateInput(String input){
    String[] parts = input.split(" ");
    String command = parts[0].trim();
    //Scanner lsc = new Scanner(input);
    //String command = lsc.next().trim(); //read the first word before space
    return VALID_COMMANDS.contains(command);
  }

  // Process command
  public void ProcessInput(String input){
    Scanner sc = new Scanner(input);
    String command = sc.next().trim(); //only take first word of the input

    if (command.equalsIgnoreCase(LOGIN)){ 

    }
    if (command.equalsIgnoreCase(LOGIN)){

    }
    switch (command){
      case LOGIN:
        String username = sc.nextLine().trim();
        this.LoginAction(username);
        System.out.println("Current loggin in user " + this.currentUser);
        break;
      case LIST:
        this.ListAction();
        break;
      case ADD:
        String[] items = sc.nextLine().trim().split(",");
        this.AddAction(items);
        break;
      case SAVE:
        this.SaveAction();
        break;
      case DELETE:
        break;
      case USERS:
        this.ListUsersAction();
        // read the keys on the hashmap OR
        // read the directory and list the users
        break;
      default:
        break;
    }

    sc.close();

  }

  public void LoginAction(String username){
    if(!this.db.userMap.containsKey(username)){
      this.db.userMap.put(username, new ArrayList<String>());
    } 
    this.currentUser = username;
  }

  public void AddAction(String[] items){
    for(String item:items){
      this.db.userMap.get(this.currentUser).add(item.trim()); //can put in a different file or class
    }
  }

  public void ListAction(){
    for (String item: this.db.userMap.get(this.currentUser)){
      System.out.println("Item -> " + item);

      }
    }

  public void ListUsersAction() {
    for (String key: this.db.userMap.keySet()) {
      System.out.println("-> " + key);
    }
  }

  public void SaveAction(){
    // Prepare the filePath = "db/<username>.db"
    String outputFilename = String.format("%s/%s.db",this.baseFolder, this.currentUser);
    // Save the contents for this user in Map to a file.
      
    try{
      FileWriter fw = new FileWriter(outputFilename);
      //Save contents for this user in Map to a file.
      for (String item: this.db.userMap.get(this.currentUser)){
        fw.write(item+"\n");
      }
      fw.flush();
      fw.close();
    } catch (IOException e){
      e.printStackTrace();
    }

  /*public void WriteFile(ArrayList<String> input){
    try{
      Files.write("src/myapp/output.txt",input);
    } catch (IOException e){
      System.out.println("Error:" + e.getMessage());
    }
  }*/
}
}

  //Command: login <username>
  //login function

  //Command: add <item1>,<item2>
  //Add items function: Push items for the current user

  //Command: list
  //list items functions: Show the Items added for the current user.

  //Command: users
  //list all the users in the system.

  //Command: save
  //save function: Dump the contents of current user to a file base_folder/username.db
