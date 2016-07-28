package programming.algorithms.interview.numbers;

public class PrintDescWithIteratorsStrategy implements IPrintNumbersStrategy {

	@Override
	public void printNumbers(int n) {
		for (int i = n; i >=1; i--) {
			System.out.println(i);			
		}
	}

}
