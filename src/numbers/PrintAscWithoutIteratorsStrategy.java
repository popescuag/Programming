package numbers;


public class PrintAscWithoutIteratorsStrategy implements IPrintNumbersStrategy {
	@Override
	public void printNumbers(int n) {
		if (n > 0) {
			printNumbers(n - 1);
			System.out.println(n);
		}
	}

}
