/**
 * test
 */
public class test {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
    }
    long endTime = System.currentTimeMillis();
    long runTime = endTime - startTime;
    System.out.println("Took " + runTime + "ms to run");
  }
}
