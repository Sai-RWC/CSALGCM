package src;

// import src.BinaryHeap;
// import src.*;

/**
 * driver
 */
public class driver {
  public static void main(String[] args) {

    // 0 => Binary Heap
    // 1 => Binomial Heap
    // 2 => Fibonacci Heap
    int operation = 2;

    // Initialize Binary Heap
    BinaryHeap heap = new BinaryHeap();

    // Initialize Binomial Heap
    BinomialHeap heapBinom = new BinomialHeap();

    // Initialize ReadFile class
    ReadFile file = new ReadFile("./data/random100_num.txt"); 

    // Initialize Fibonacci Heap
    FibonacciHeap heap_fibo = new FibonacciHeap();

    long startTime = System.nanoTime();

    switch (operation) {
      case 0:
        // BinaryHeap Runtime
        for (int i = 0; i < file.arrSize; i++) {
          heap.insert(file.arrIn[i]);
        }
        break;

      case 1:
        // BinomialHeap Runtime
        for (int i = 0; i < file.arrSize; i++) {
          heapBinom.insert(file.arrIn[i]);
        }
        break;

      case 2:
        // FibonacciHeap Runtime
        for (int i = 0; i < file.arrSize; i++) {
          heap_fibo.insert(file.arrIn[i]);
        }
        break;

      default:
        break;
    }
    long endTime = System.nanoTime();

    long duration = endTime - startTime;

    // duration in nano seconds
    System.out.println("Insert operation took "+duration);
  }
}
