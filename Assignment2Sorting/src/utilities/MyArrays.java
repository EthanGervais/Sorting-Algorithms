package utilities;

import java.util.*;

public class MyArrays {
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

	private static void merge(Comparable[] items, Comparator comparator, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		// Temporary arrays
		Comparable L[] = new Comparable[n1];
		Comparable R[] = new Comparable[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = items[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = items[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
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

	private static void mergeSort(Comparable[] items, Comparator comparator, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(items, comparator, l, m);
			mergeSort(items, comparator, m + 1, r);
			merge(items, comparator, l, m, r);
		}
	}

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

	private static void quickSort(Comparable[] items, Comparator comparator, int left, int right) {
		if (left < right) {
			int p = partition(items, comparator, left, right);
			quickSort(items, comparator, left, p - 1);
			quickSort(items, comparator, p + 1, right);
		}
	}

	private static boolean isSorted(Comparable[] items, Comparator comparator) {
		for (int i = 1; i < items.length; i++) {
			if (comparator.compare(items[i], items[i - 1]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void swap(Comparable[] items, int i, int j) {
		Comparable temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	
	private static void shuffle(Comparable[] items) {
		for (int i = 1; i < items.length; i++)
			swap(items, i, (int) (Math.random() * i));
	}
	
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