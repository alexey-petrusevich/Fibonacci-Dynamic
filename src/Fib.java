import java.util.Arrays;
import java.util.Scanner;

public class Fib {

  /**
   * Returns a Fibonacci number using recursion.
   *
   * @param number given Fibonacci number
   * @return the value of the given Fibonacci number
   */
  private static long fibonacciRecursive(int number) {
    if (number == 0) {
      return 0;
    } else if (number == 1) {
      return 1;
    } else {
      return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }
  }


  /**
   * Returns a Fibonacci number using memoization.
   *
   * @param number given Fibonacci number
   * @return the value of the given Fibonacci number
   */
  private static long fibonacciNonRecursive(int number) {
    long[] fibs = new long[number + 1];
    Arrays.fill(fibs, -1);
    return fibonacciNonRecursiveHelper(number, fibs);
  }


  /**
   * A helper function for calculating a Fibonacci number using memoization.
   *
   * @param number given Fibonacci number
   * @param fibs an array of previously calculated Fibonacci numbers
   * @return the value of the given Fibonacci number
   */
  private static long fibonacciNonRecursiveHelper(int number, long[] fibs) {
    if (number == 0) {
      return 0;
    } else if (number == 1) {
      return 1;
    } else if (fibs[number] != -1) {
      return fibs[number];
    } else {
      fibs[number] = fibonacciNonRecursiveHelper(number - 1, fibs)
              + fibonacciNonRecursiveHelper(number - 2, fibs);
      return fibs[number];
    }
  }


  /**
   * Reads a Fibonacci number from standard input and returns as integer.
   *
   * @return Fibonacci number read from standard input
   */
  private static int readFib() {
    Scanner scanner = new Scanner(System.in);
    int fib = 0;
    try {
      System.out.print("Enter Fibonacci number: ");
       fib = Integer.parseInt(scanner.next());
       if (fib < 0) {
         throw new IllegalArgumentException();
       }
    } catch (Exception e) {
      System.out.println("Non-negative integers only");
      System.exit(1);
    }
    return fib;
  }


  public static void main(String[] args) {
    // read Fibonacci number from stdin
    int fibNumber = readFib();

    // time recursive Fibonacci
    long timeRecursive = System.currentTimeMillis();
    long fibRecursive = Fib.fibonacciRecursive(fibNumber);
    timeRecursive = System.currentTimeMillis() - timeRecursive;

    // time non-recursive Fibonacci
    long timeNonRecursive = System.currentTimeMillis();
    long fibNonRecursive = Fib.fibonacciNonRecursive(fibNumber);
    timeNonRecursive = System.currentTimeMillis() - timeNonRecursive;


    System.out.printf("Recursive Fibonacci(%d): %d\nNon-recursive Fibonacci(%d): %d\n",
            fibNumber, fibRecursive, fibNumber, fibNonRecursive);

    System.out.printf("Time recursive: %f s\nTime non-recursive %f s\n",
            timeRecursive / 1000.0, timeNonRecursive / 1000.0);
  }


}
