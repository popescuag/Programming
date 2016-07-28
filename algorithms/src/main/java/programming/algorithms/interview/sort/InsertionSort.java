package programming.algorithms.interview.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int toSort[] = { 2, 4, 9, 6, 23, 12, 34, 0, 1 };

		System.out.print("Array values BEFORE SORTING : ");
		printValues(toSort); // array before sort

		insertionSort(toSort); // sorting array using 'Insertion Sort Algorithm'

		System.out.print("Array values AFTER SORTING  : ");
		printValues(toSort); // array after sort
	}

	public static void insertionSort(int toSort[]) {
		for (int i = 0; i < toSort.length; i++) {
			int value = toSort[i];
			int j = i - 1;
			while (j >= 0 && toSort[j] > value) {
				toSort[j + 1] = toSort[j];
				j = j - 1;
			}
			toSort[j + 1] = value;
		}
	}

	public static void printValues(int toSort[]) {
		for (int k = 0; k < toSort.length; k++) {
			System.out.print(toSort[k] + " ");
		}
		System.out.println();
	}

}
