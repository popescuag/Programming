package programming.algorithms.interview.numbers;

public class PrintAscWithIteratorsStrategy implements IPrintNumbersStrategy {

	@Override
	public void printNumbers(int n) {
		for (int i = 1; i < n + 1; i++) {
System.out.println(i);
		}
	}

}
