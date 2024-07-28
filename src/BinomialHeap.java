package src;
import java.util.Scanner;

public class BinomialHeap {

    private class Node {
        int key;
        int degree;
        Node parent;
        Node child;
        Node sibling;

        public Node(int key) {
            this.key = key;
            this.degree = 0;
            this.parent = null;
            this.child = null;
            this.sibling = null;
        }
    }

    private Node head;

    public BinomialHeap() {
        this.head = null;
    }

    public void insert(int key) {
        Node node = new Node(key);
        BinomialHeap tempHeap = new BinomialHeap();
        tempHeap.head = node;
        this.head = union(this, tempHeap).head;
    }

    public int findMin() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        Node y = null;
        Node x = head;
        int min = x.key;
        while (x != null) {
            if (x.key < min) {
                min = x.key;
                y = x;
            }
            x = x.sibling;
        }
        return min;
    }

    public int extractMin() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        Node minNode = head;
        Node minNodePrev = null;
        Node nextNode = minNode.sibling;
        Node nextNodePrev = minNode;

        while (nextNode != null) {
            if (nextNode.key < minNode.key) {
                minNode = nextNode;
                minNodePrev = nextNodePrev;
            }
            nextNodePrev = nextNode;
            nextNode = nextNode.sibling;
        }

        if (minNodePrev != null) {
            minNodePrev.sibling = minNode.sibling;
        } else {
            head = minNode.sibling;
        }

        Node child = minNode.child;
        Node temp = null;
        while (child != null) {
            Node next = child.sibling;
            child.sibling = temp;
            child.parent = null;
            temp = child;
            child = next;
        }

        BinomialHeap tempHeap = new BinomialHeap();
        tempHeap.head = temp;
        this.head = union(this, tempHeap).head;

        return minNode.key;
    }

    public void decreaseKey(Node node, int newKey) {
        if (newKey > node.key) {
            throw new IllegalArgumentException("New key is greater than current key");
        }

        node.key = newKey;
        Node y = node;
        Node z = y.parent;

        while (z != null && y.key < z.key) {
            int tempKey = y.key;
            y.key = z.key;
            z.key = tempKey;

            y = z;
            z = y.parent;
        }
    }

    public void delete(Node node) {
        decreaseKey(node, Integer.MIN_VALUE);
        extractMin();
    }

    private Node merge(BinomialHeap h1, BinomialHeap h2) {
        Node head1 = h1.head;
        Node head2 = h2.head;
        Node newHead;
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (head1.degree <= head2.degree) {
            newHead = head1;
            head1 = head1.sibling;
        } else {
            newHead = head2;
            head2 = head2.sibling;
        }

        Node tail = newHead;

        while (head1 != null && head2 != null) {
            if (head1.degree <= head2.degree) {
                tail.sibling = head1;
                head1 = head1.sibling;
            } else {
                tail.sibling = head2;
                head2 = head2.sibling;
            }
            tail = tail.sibling;
        }

        if (head1 != null) {
            tail.sibling = head1;
        } else {
            tail.sibling = head2;
        }

        return newHead;
    }

    private BinomialHeap union(BinomialHeap h1, BinomialHeap h2) {
        BinomialHeap newHeap = new BinomialHeap();
        newHeap.head = merge(h1, h2);

        if (newHeap.head == null) {
            return newHeap;
        }

        Node prevX = null;
        Node x = newHeap.head;
        Node nextX = x.sibling;

        while (nextX != null) {
            if ((x.degree != nextX.degree) ||
                (nextX.sibling != null && nextX.sibling.degree == x.degree)) {
                prevX = x;
                x = nextX;
            } else {
                if (x.key <= nextX.key) {
                    x.sibling = nextX.sibling;
                    link(nextX, x);
                } else {
                    if (prevX == null) {
                        newHeap.head = nextX;
                    } else {
                        prevX.sibling = nextX;
                    }
                    link(x, nextX);
                    x = nextX;
                }
            }
            nextX = x.sibling;
        }

        return newHeap;
    }

    private void link(Node y, Node z) {
        y.parent = z;
        y.sibling = z.child;
        z.child = y;
        z.degree++;
    }

    public void printHeap() {
        Node current = head;
        while (current != null) {
            System.out.println("Binomial Tree, B" + current.degree);
            printTree(current, 0);
            current = current.sibling;
            System.out.println();
        }
    }

    private void printTree(Node node, int indent) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println(node.key);
        printTree(node.child, indent + 1);
        printTree(node.sibling, indent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinomialHeap heap = new BinomialHeap();
        boolean continueInput = true;

        while (continueInput) {
            System.out.println("Enter an element to insert into the binomial heap:");
            int element = scanner.nextInt();
            heap.insert(element);

            System.out.println("Do you want to continue? (yes/no)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                continueInput = false;
            }
        }

        System.out.println("Current binomial heap:");
        heap.printHeap();

        System.out.println("Minimum key: " + heap.findMin());

        System.out.println("Extracting min...");
        System.out.println("Extracted min: " + heap.extractMin());

        System.out.println("Current binomial heap after extraction:");
        heap.printHeap();

        System.out.println("Minimum key after extraction: " + heap.findMin());
        scanner.close();
    }
}

