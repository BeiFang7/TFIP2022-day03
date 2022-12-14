import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

//Files Demo

public class FilesDemo {

  public static void main (String[] args){
    String filePath = "src/demo.txt";
    ReadFile(filePath);
    WriteFile("src/output.txt");
  }

  //File Reader
  public static void ReadFile (String fname){

    //Path object
    Path pth = Paths.get(fname);
    
    //File object
    File fobj = pth.toFile(); //Shorten: File fobj = Paths.get(fname).toFile();

    //Check if file exists
    if (fobj.exists()){
      System.out.println("File exists");
    }else{
      System.out.println("File Not Found");
    }

    // FileReader fr; //if already define fr outside of try function, then need to close finally
    // BufferedReader bdf; //if already define fr outside of try function, then need to close finally

    //Reader Object
    try{
      
      // fr = new FileReader(fobj); //if already define fr outside of try function, then need to close finally
      // bdf = new BufferedReader(fr); //if already define fr outside of try function, then need to close finally
      
      FileReader fr = new FileReader(fobj); //define locally within try function
      BufferedReader bdf = new BufferedReader(fr); //define locally within try function
      
      // dont use fr.read() because it can only read integer, not string.

      // Use 
      // String line = bdf.readLine();
      // System.out.println("First line => " + line);

      // line = bdf.readLine();
      // System.out.println("Second line => "+ line);

      String line;
      while (null != (line = bdf.readLine())){ // means if read till end of file, it will stop reading
        System.out.println("> " + line);
      }

      bdf.close(); //to clean up or close the program, usually should put at the end under finally, but didnt want to expose the close to the previous program thus put here.

    }
    catch (FileNotFoundException e){ //error that FileReader will gives
      System.out.println("File Not Found. Please check input file" + e.getMessage());
    }
    catch (IOException e){
      System.out.println("Unable to read line: " + e.getMessage());
    } 
    // finally {bdf.close()}; //if already define fr outside of try function, then need to close finally
  }

  public static void WriteFile(String fname){
    try{
      FileWriter fw= new FileWriter(fname,false); //append mode / write mo
      // fw.write("apple\n"); //normal writer does not give spacing unless you add \n
      // fw.write("orange\n");
      // fw.write("pear\n");
      // fw.flush(); //to save the things you key into the file
      // fw.close(); 

      BufferedWriter bfw = new BufferedWriter (fw);
      bfw.write("apple\n"); //both are same, buffer writer and normal writer both does not give spacing unless you add \n
      bfw.write("orange\n");
      bfw.write("pear\n");
      bfw.flush();
      bfw.close();

    } catch (IOException e){
      System.out.println("Unable to write line: " +e.getMessage());
    }
  }
}
