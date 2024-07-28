package src;

import java.util.Collections;

// import src.BinaryHeap;
import src.*;

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

    

    ReadFile file = new ReadFile("./data/random100000_num.txt"); 

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
        // System.out.println("min: "+heap.extractMin());
        startTime = System.nanoTime();
        // heap.printHeap();
        break;

      case 1:
        // BinomialHeap Runtime
        for (int i = 0; i < file.arrSize; i++) {
          heapBinom.insert(file.arrIn[i]);
        }
        // long endTime = System.currentTimeMillis();
        // heapBinom.findMin();
        // System.out.println("min: "+heapBinom.extractMin());
        startTime = System.nanoTime();
        break;

      case 2:
        for (int i = 0; i < file.arrSize; i++) {
          heap_fibo.insert(file.arrIn[i]);
        }
        // System.out.println("node_count:"+heap_fibo.nodeCount);
        // System.out.println(heap_fibo.extractMin().key);
        startTime = System.nanoTime();
        for (int i = 0; i < file.arrSize; i++) {
        }
          
        break;

      default:
        break;
    }
    long endTime = System.nanoTime();


    long duration = endTime - startTime;

    System.out.println("Insert operation took "+duration+"ns");
  }
}

