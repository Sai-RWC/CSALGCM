package src;

// import src.BinaryHeap;
import src.*;

/**
 * driver
 */
public class driver {
  public static void main(String[] args) {

    // 0 => Binary Heap
    // 1 => Binomial Heap
    // 2 => Fibonacci Heap
    int operation = 1;

    BinaryHeap heap = new BinaryHeap();

    ReadFile file = new ReadFile("./data/random100000_num.txt"); 
    // file.printIn();

    BinomialHeap heap_binom = new BinomialHeap();

    long startTime = System.nanoTime();
    switch (operation) {
      case 0:
        // BinaryHeap Runtime

        // long startTime = System.currentTimeMillis();
        for (int i = 0; i < file.arrIn.size(); i++) {
          heap.insert(file.arrIn.get(i));
        }
        break;
      case 1:

        // BinomialHeap Runtime
        for (int i = 0; i < file.arrIn.size(); i++) {
          heap_binom.insert(file.arrIn.get(i));
        }
        // long endTime = System.currentTimeMillis();
        break;

      default:
        break;
    }
    long endTime = System.nanoTime();


    long duration = endTime - startTime;

    System.out.println("Insert operation took "+duration+"ns");
  }
}
