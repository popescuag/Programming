package programming.algorithms.interview.numbers;

public class PrintDescWithoutIteratorsStrategy implements IPrintNumbersStrategy {
	@Override
	public void printNumbers(int n) {
		if (n > 0) {
			System.out.println(n);
			printNumbers(n - 1);
		}
	}
}
