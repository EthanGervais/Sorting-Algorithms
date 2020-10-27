package utilities;

import java.util.*;

import problemdomain.Polygon;

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
	 * @param comparator    The user-chosen comparator that the items in the array
	 *                      will be compared to when sorting.
	 * @param isHeight      If comparing by height.
	 */
	public static void sort(char sortAlgorithm, Comparable[] items, Comparator<Polygon> comparator, boolean isHeight) {
		if (sortAlgorithm == 'b') {
			bubbleSort(items, comparator, isHeight);
		} else if (sortAlgorithm == 's') {
			selectionSort(items, comparator, isHeight);
		} else if (sortAlgorithm == 'i') {
			insertionSort(items, comparator, isHeight);
		} else if (sortAlgorithm == 'm') {
			mergeSort(items, comparator, 0, items.length - 1, isHeight);
		} else if (sortAlgorithm == 'q') {
			quickSort(items, comparator, 0, items.length - 1, isHeight);
		} else if (sortAlgorithm == 'z') {
			stupidSort(items, comparator, isHeight);
		}
	}

	/**
	 * Handles the implementation of the bubble sort.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 * @param isHeight   If comparing by height.
	 */
	private static void bubbleSort(Comparable[] items, Comparator comparator, boolean isHeight) {
		int n = items.length;
		Comparable temp;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (isHeight) {
					if (items[j].compareTo(items[j + 1]) < 0) {
						temp = items[j];
						items[j] = items[j + 1];
						items[j + 1] = temp;
					}
				} else {
					if (comparator.compare(items[j], items[j + 1]) < 0) {
						temp = items[j];
						items[j] = items[j + 1];
						items[j + 1] = temp;
					}
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
	 * @param isHeight   If comparing by height.
	 */
	private static void selectionSort(Comparable[] items, Comparator comparator, boolean isHeight) {
		int n = items.length;
		Comparable temp;
		int minIndex;

		for (int i = 0; i < n - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (isHeight) {
					if (items[j].compareTo(items[minIndex]) > 0)
						minIndex = j;
					temp = items[minIndex];
					items[minIndex] = items[i];
					items[i] = temp;
				} else {
					if (comparator.compare(items[j], items[minIndex]) > 0)
						minIndex = j;
					temp = items[minIndex];
					items[minIndex] = items[i];
					items[i] = temp;
				}
			}
		}
	}

	/**
	 * Handles the implementation of the insertion sort.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 * @param isHeight   If comparing by height.
	 */
	private static void insertionSort(Comparable[] items, Comparator comparator, boolean isHeight) {
		int n = items.length;
		Comparable key;

		for (int i = 1; i < n; i++) {
			key = items[i];
			int j = i - 1;

			if (isHeight) {
				while (j >= 0 && items[j].compareTo(key) < 0) {
					items[j + 1] = items[j];
					j = j - 1;
				}
			} else {
				while (j >= 0 && comparator.compare(items[j], key) < 0) {
					items[j + 1] = items[j];
					j = j - 1;
				}
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
	 * @param isHeight   If comparing by height.
	 */
	private static void merge(Comparable[] items, Comparator comparator, int left, int middle, int right,
			boolean isHeight) {
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
			if (isHeight) {
				if (L[i].compareTo(R[j]) >= 0) {
					items[k] = L[i];
					i++;
				} else {
					items[k] = R[j];
					j++;
				}
			} else {
				if (comparator.compare(L[i], R[j]) >= 0) {
					items[k] = L[i];
					i++;
				} else {
					items[k] = R[j];
					j++;
				}
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
	 * @param isHeight   If comparing by height.
	 */
	private static void mergeSort(Comparable[] items, Comparator comparator, int left, int right, boolean isHeight) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(items, comparator, left, middle, isHeight);
			mergeSort(items, comparator, middle + 1, right, isHeight);
			merge(items, comparator, left, middle, right, isHeight);
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
	 * @param isHeight   If comparing by height.
	 * @return The index at the beginning of the array.
	 */
	private static int partition(Comparable[] items, Comparator comparator, int left, int right, boolean isHeight) {
		Comparable pivot = items[left];
		int p = left;

		for (int r = left; r <= right; r++) {
			if (isHeight) {
				int comp = items[r].compareTo(pivot);

				if (comp > 0) {
					items[p] = items[r];
					items[r] = items[p + 1];
					items[p + 1] = pivot;

					p++;
				}
			} else {
				int comp = comparator.compare(items[r], pivot);

				if (comp > 0) {
					items[p] = items[r];
					items[r] = items[p + 1];
					items[p + 1] = pivot;

					p++;
				}
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
	 * @param isHeight   If comparing by height.
	 */
	private static void quickSort(Comparable[] items, Comparator comparator, int left, int right, boolean isHeight) {
		if (left < right) {
			int p = partition(items, comparator, left, right, isHeight);
			quickSort(items, comparator, left, p - 1, isHeight);
			quickSort(items, comparator, p + 1, right, isHeight);
		}
	}

	/**
	 * Checks if the array of polygons is sorted or not for the stupidSort method.
	 * 
	 * @param items      The array of unsorted polygons.
	 * @param comparator The comparator that the items in the array will be compared
	 *                   to when sorting.
	 * @param isHeight   If comparing by height.
	 * @return Returns true if the array is sorted, otherwise returns false.
	 */
	private static boolean isSorted(Comparable[] items, Comparator comparator, boolean isHeight) {
		for (int i = 1; i < items.length; i++) {
			if (isHeight) {
				if (items[i].compareTo(items[i - 1]) > 0) {
					return false;
				}
			} else {
				if (comparator.compare(items[i], items[i - 1]) > 0) {
					return false;
				}
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
	 * @param isHeight   If comparing by height.
	 */
	private static void stupidSort(Comparable[] items, Comparator comparator, boolean isHeight) {
		int counter = 0;
		while (!isSorted(items, comparator, isHeight)) {
			shuffle(items);
			counter++;
			System.out.println("Randomized " + counter + " times");
		}
		System.out.println("\nList sorted. Randomized " + counter + " times!");
	}
}