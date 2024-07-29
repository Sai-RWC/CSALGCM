package src;

// import src.BinaryHeap;
// import src.*;

/**
 * driver
 */
public class driver_extract {
  public static void main(String[] args) {

    // 0 => Binary Heap
    // 1 => Binomial Heap
    // 2 => Fibonacci Heap
    int operation = 1;

    // Initialize Binary Heap
    BinaryHeap heap = new BinaryHeap();

    // Initialize Binomial Heap
    BinomialHeap heapBinom = new BinomialHeap();

    // Initialize ReadFile class
    ReadFile file = new ReadFile("./data/random100_num.txt"); 

    // Import Fibonacci Heap
    FibonacciHeap heap_fibo = new FibonacciHeap();

    long startTime = System.nanoTime();

    switch (operation) {
      case 0:
        // BinaryHeap Runtime
        for (int i = 0; i < file.arrSize; i++) {
          heap.insert(file.arrIn[i]);
        }
        startTime = System.nanoTime();
        System.out.println("min: "+heap.extractMin());
        // heap.printHeap();
        break;

      case 1:
        // BinomialHeap Runtime
        for (int i = 0; i < file.arrSize; i++) {
          heapBinom.insert(file.arrIn[i]);
        }
        startTime = System.nanoTime();
        System.out.println("min: "+heapBinom.extractMin());
        break;

      case 2:
        for (int i = 0; i < file.arrSize; i++) {
          heap_fibo.insert(file.arrIn[i]);
        }
        startTime = System.nanoTime();
        System.out.println(heap_fibo.extractMin().key);
          
        break;

      default:
        break;
    }

    long endTime = System.nanoTime();

    long duration = endTime - startTime;

    System.out.println("Extract operation took "+duration);
  }
}

