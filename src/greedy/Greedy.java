package greedy;

public class Greedy {
    /**
     * Return true if number can be expressed as a sum of all or part of numbers elements.
     * @param numbers
     * @param number
     * @return
     */
    public boolean canBuild(int[] numbers, int number) {
	boolean can = false;
	
	//sort the numbers
	for (int i = 0; i < numbers.length; i++) {  
	    int value = numbers[i];  
	    int j = i - 1;  
	    while (j >= 0 && numbers[j] > value) {  
		numbers[j + 1] = numbers[j];  
	        j = j - 1;  
	    }  
	    numbers[j + 1] = value;  
	}
	
	
	
	return can;
    }
}
