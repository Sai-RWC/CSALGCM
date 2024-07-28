package src;

public class BinaryHeap {
    private static final int MAX_SIZE = 100002;
    private int[] heap;
    private int size;

    public BinaryHeap() {
        heap = new int[MAX_SIZE];
        size = 0;
    }

    // Returns the index of the parent node
    public static int parent(int i) {
        return (i - 1) / 2;
    }

    // Returns the index of the left child
    public static int leftChild(int i) {
        return 2 * i + 1;
    }

    // Returns the index of the right child
    public static int rightChild(int i) {
        return 2 * i + 2;
    }

    // Inserts an item at the appropriate position
    public void insert(int data) {
        if (size >= MAX_SIZE) {
            System.out.println("The heap is full. Cannot insert.");
            return;
        }

        // Insert the item at the end and then move it up
        heap[size] = data;
        size++;

        // Move up to maintain the heap property
        int i = size - 1;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    // Maintains the heap property by moving the item at index i downwards
    public void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        // Check if left child is smaller than current
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        // Check if right child is smaller than current and left child
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // Swap and continue heapifying if the smallest is not the current
        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }

    // Returns the minimum item from the heap
    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty.");
        }
        return heap[0];
    }

    // Removes and returns the minimum item from the heap
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty.");
        }
        int minItem = heap[0];

        // Replace the root with the last item and heapify
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);

        return minItem;
    }

    // Prints the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryHeap minHeap = new BinaryHeap();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(3);

        System.out.println("Heap after insertions:");
        minHeap.printHeap();

        System.out.println("Extracted min: " + minHeap.extractMin());

        System.out.println("Heap after extraction:");
        minHeap.printHeap();
    }
}

