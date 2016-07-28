package programming.algorithms.interview.numbers;

public class PrintNumbersContext<T extends IPrintNumbersStrategy> {
	public void printNumbers(T strategy, int n) {
		strategy.printNumbers(n);
	}
}
