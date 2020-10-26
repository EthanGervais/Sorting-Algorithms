package utilities;

import java.util.*;

/**
 * Handles the sorting methods.
 * 
 * @author Ethan Gervais
 *
 */
public class MyArrays {

	/**
	 * Chooses which sort to perform and what to compare it to based on user input.
	 * 
	 * @param sortAlgorithm The user-chosen sorting algorithm
	 * @param items         The array of unsorted polygons.
	 * @param comparator    The user-chosen comparator that the items in the array will be
	 *                      compared to when sorting.
	 */
	public static void sort(char sortAlgorithm, Comparable[] items, Comparator comparator) {
		if (sortAlgorithm == 'b') {
			bubbleSort(items, comparator);
		} else if (sortAlgorithm == 's') {
			selectionSort(items, comparator);
		} else if (sortAlgorithm == 'i') {
			insertionSort(items, comparator);
		} else if (sortAlgorithm == 'm') {
			mergeSort(items, comparator, 0, items.length - 1);
		} else if (sortAlgorithm == 'q') {
			quickSort(items, comparator, 0, items.length - 1);
		} else if (sortAlgorithm == 'z') {
			stupidSort(items, comparator);
		}
	}

	/**
	 * Handles the implementation of the bubble sort.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 */
	private static void bubbleSort(Comparable[] items, Comparator comparator) {
		int n = items.length;
		Comparable temp;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (comparator.compare(items[j], items[j + 1]) < 0) {
					temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Handles the implementation of the selection sort.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 */
	private static void selectionSort(Comparable[] items, Comparator comparator) {
		int n = items.length;
		Comparable temp;
		int minIndex;

		for (int i = 0; i < n - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (comparator.compare(items[j], items[minIndex]) > 0)
					minIndex = j;
				temp = items[minIndex];
				items[minIndex] = items[i];
				items[i] = temp;

			}
		}
	}

	/**
	 * Handles the implementation of the insertion sort.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 */
	private static void insertionSort(Comparable[] items, Comparator comparator) {
		int n = items.length;
		Comparable key;

		for (int i = 1; i < n; i++) {
			key = items[i];
			int j = i - 1;

			while (j >= 0 && comparator.compare(items[j], key) < 0) {
				items[j + 1] = items[j];
				j = j - 1;
			}

			items[j + 1] = key;
		}
	}

	/**
	 * Merging the separate arrays for the mergeSort method.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 * @param left       Beginning of the array.
	 * @param middle     The middle of the array.
	 * @param right      End of the array.
	 */
	private static void merge(Comparable[] items, Comparator comparator, int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;

		// Temporary arrays
		Comparable L[] = new Comparable[n1];
		Comparable R[] = new Comparable[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = items[left + i];
		for (int j = 0; j < n2; ++j)
			R[j] = items[middle + 1 + j];

		int i = 0, j = 0;

		int k = left;
		while (i < n1 && j < n2) {
			if (comparator.compare(L[i], R[j]) >= 0) {
				items[k] = L[i];
				i++;
			} else {
				items[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			items[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			items[k] = R[j];
			j++;
			k++;
		}
	}

	/**
	 * Handles the implementation of the merge sort.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 * @param left       Beginning of the array.
	 * @param right      End of the array.
	 */
	private static void mergeSort(Comparable[] items, Comparator comparator, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(items, comparator, left, middle);
			mergeSort(items, comparator, middle + 1, right);
			merge(items, comparator, left, middle, right);
		}
	}

	/**
	 * The partition for the quickSort method.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 * @param left       Beginning of the array.
	 * @param right      End of the array.
	 * @return The index at the beginning of the array.
	 */
	private static int partition(Comparable[] items, Comparator comparator, int left, int right) {
		Comparable pivot = items[left];
		int p = left;

		for (int r = left; r <= right; r++) {
			int comp = comparator.compare(items[r], pivot);
			if (comp > 0) {
				items[p] = items[r];
				items[r] = items[p + 1];
				items[p + 1] = pivot;

				p++;
			}
		}

		return p;
	}

	/**
	 * Handles the implementation of the quick sort.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 * @param left       Beginning of the array.
	 * @param right      End of the array.
	 */
	private static void quickSort(Comparable[] items, Comparator comparator, int left, int right) {
		if (left < right) {
			int p = partition(items, comparator, left, right);
			quickSort(items, comparator, left, p - 1);
			quickSort(items, comparator, p + 1, right);
		}
	}

	/**
	 * Checks if the array of polygons is sorted or not for the stupidSort method.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 * @return Returns true if the array is sorted, otherwise returns false.
	 */
	private static boolean isSorted(Comparable[] items, Comparator comparator) {
		for (int i = 1; i < items.length; i++) {
			if (comparator.compare(items[i], items[i - 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Swaps elements in the array of polygons.
	 * 
	 * @param items The array of polygons being sorted for the stupidSort method.
	 * @param i     An index of items being swapped.
	 * @param j     An index of items being swapped
	 */
	private static void swap(Comparable[] items, int i, int j) {
		Comparable temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	/**
	 * Shuffles the array randomly for the stupidSort method.
	 * 
	 * @param items The array of polygons being shuffled.
	 */
	private static void shuffle(Comparable[] items) {
		for (int i = 1; i < items.length; i++)
			swap(items, i, (int) (Math.random() * i));
	}

	/**
	 * Handles the implementation of the stupid sort, a.k.a. the bogo sort.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 */
	private static void stupidSort(Comparable[] items, Comparator comparator) {
		int counter = 0;
		while (!isSorted(items, comparator)) {
			shuffle(items);
			counter++;
			System.out.println("Randomized " + counter + " times");
		}
		System.out.println("\nList sorted. Randomized " + counter + " times!");
	}
}