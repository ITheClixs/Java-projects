import java.util.Scanner;

public class Factorial {
	// Recursive factorial function
	public static int factorial(int n) {
		if (n == 0) {
			return 1; // Base case
		} else {
		    return n * factorial(n - 1);
		} 
	} 

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	System.out.print("whats the number for n? ");
	int n = scanner.nextInt();

	int result = factorial(n);
	System.out.println("the factorial of " + n + " is: " +result);
    }
}

