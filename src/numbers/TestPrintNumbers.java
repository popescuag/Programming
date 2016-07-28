package numbers;

public class TestPrintNumbers {

	public static void main(String[] args) {
		TestPrintNumbers testClass = new TestPrintNumbers();

		testClass.testPrintAscWithIterators(30);
		testClass.testPrintAscWithoutIterators(20);
		testClass.testPrintDescWithIterators(10);
		testClass.testPrintDescWithoutIterators(20);
	}
	
	public void testPrintAscWithIterators(int n) {
System.out.println("Asc with iterators");
		PrintNumbersContext<PrintAscWithIteratorsStrategy> context = new PrintNumbersContext<PrintAscWithIteratorsStrategy>();
		PrintAscWithIteratorsStrategy strategy = new PrintAscWithIteratorsStrategy();
		context.printNumbers(strategy, n);
System.out.println("================");
	}
	
	public void testPrintAscWithoutIterators(int n) {
System.out.println("Asc without iterators");
		PrintNumbersContext<PrintAscWithoutIteratorsStrategy> context = new PrintNumbersContext<PrintAscWithoutIteratorsStrategy>();
		PrintAscWithoutIteratorsStrategy strategy = new PrintAscWithoutIteratorsStrategy();
		context.printNumbers(strategy, n);
System.out.println("================");
	}
	
	public void testPrintDescWithIterators(int n) {
System.out.println("Desc with iterators");
		PrintNumbersContext<PrintDescWithIteratorsStrategy> context = new PrintNumbersContext<PrintDescWithIteratorsStrategy>();
		PrintDescWithIteratorsStrategy strategy = new PrintDescWithIteratorsStrategy();
		context.printNumbers(strategy, n);
System.out.println("================");
	}
	
	public void testPrintDescWithoutIterators(int n) {
System.out.println("Desc without iterators");
		PrintNumbersContext<PrintDescWithoutIteratorsStrategy> context = new PrintNumbersContext<PrintDescWithoutIteratorsStrategy>();
		PrintDescWithoutIteratorsStrategy strategy = new PrintDescWithoutIteratorsStrategy();
		context.printNumbers(strategy, n);
System.out.println("================");	
	}

}
