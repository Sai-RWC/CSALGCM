package src;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
                          //
import java.io.IOException;
import java.util.ArrayList;

// https://www.w3schools.com/java/java_files_read.asp
public class ReadFile {

  ArrayList<Integer> arrIn = new ArrayList<Integer>();
  public String filePath;

  public ReadFile(String fPath) {
    
    // System.out.println(fPath);
    filePath = fPath;
    try {
      // File file = new File("../data/random100_num.txt");
      BufferedReader reader = new BufferedReader(new FileReader(fPath));
      try {
        // int num_elem = Integer.parseInt(reader.readLine());
        reader.readLine();
        while (reader.readLine() != null) {
          arrIn.add(Integer.parseInt(reader.readLine()));
        }
      } catch (IOException ex) {
        System.err.println(ex.getMessage());
      }

      try {
        reader.close();
      } catch (IOException ex) {
        System.err.println(ex.getMessage());
      }
    }
    catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage());
    }

  }

  public void printIn() {
    for (int i = 0; i < arrIn.size(); i++) {
      System.out.println(arrIn.get(i));
    }
    
  }


  // public static void main(String[] args) {
  //   try {
  //     File myObj = new File("./data/random100.txt");
  //     Scanner myReader = new Scanner(myObj);
  //     while (myReader.hasNextLine()) {
  //       String data = myReader.nextLine();
  //       System.out.println(data);
  //     }
  //     myReader.close();
  //   } catch (FileNotFoundException e) {
  //     System.out.println("An error occurred.");
  //     e.printStackTrace();
  //   }
  // }
}

