package src;

// import src.BinaryHeap;
import src.*;

/**
 * driver
 */
public class driver {
  public static void main(String[] args) {

    BinaryHeap heap = new BinaryHeap();

    ReadFile file = new ReadFile("./data/random75000_num.txt"); 
    file.printIn();

    
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < file.arrIn.size(); i++) {
      heap.insert(file.arrIn.get(i));
    }
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    System.out.println("Insert operation took "+duration+"ms");
  }
}
