package src;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// https://www.w3schools.com/java/java_files_read.asp
public class ReadFile {

  // ArrayList<Integer> arrIn = new ArrayList<Integer>();
  public int[] arrIn;
  public int arrSize;
  public String filePath;

  public ReadFile(String fPath) {
    
    // System.out.println(fPath);
    filePath = fPath;
    try {
      // File file = new File("../data/random100_num.txt");
      BufferedReader reader = new BufferedReader(new FileReader(fPath));
      try {
        arrSize = Integer.parseInt(reader.readLine());
        // String firstLine = reader.readLine();
        // System.out.println("firstLine: "+firstLine);
        arrIn = new int[arrSize];
        // while (reader.readLine() != null) {
        //   // arrIn.add(Integer.parseInt(reader.readLine()));
        // }
        for (int i = 0; i < arrSize; i++) {
          arrIn[i] = Integer.parseInt(reader.readLine());
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

  // public void printIn() {
  //   for (int i = 0; i < arrSize; i++) {
  //     System.out.println(arrIn[i]);
  //   }
  //   
  // }


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

