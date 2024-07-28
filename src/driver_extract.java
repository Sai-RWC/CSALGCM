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
    int operation = 2;

    BinaryHeap heap = new BinaryHeap();

    // file.printIn();

    BinomialHeap heapBinom = new BinomialHeap();

    

    ReadFile file = new ReadFile("./data/random25000_num.txt"); 

    // GFG min_heap = new GFG(file.arrSize);

    FibonacciHeap heap_fibo = new FibonacciHeap();
    long startTime = System.nanoTime();


    // System.out.println("size: "+file.arrSize);

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
        // long endTime = System.currentTimeMillis();
        // heapBinom.findMin();
        startTime = System.nanoTime();
        System.out.println("min: "+heapBinom.extractMin());
        break;

      case 2:
        for (int i = 0; i < file.arrSize; i++) {
          heap_fibo.insert(file.arrIn[i]);
        }
        // System.out.println("node_count:"+heap_fibo.nodeCount);
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

