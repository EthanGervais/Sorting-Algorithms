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
			mergeSort(items, comparator, 0, 0);
		} else if (sortAlgorithm == 'q') {
			quickSort(items, comparator);
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

	private static void merge(Comparable[] items, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		double L[] = new double[n1];
		double R[] = new double[n2];

		for (int i = 0; i < n1; i++)
			L[i] = (double) items[l + i];

		for (int j = 0; j < n2; j++)
			R[j] = (double) items[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
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
			merge(items, l, m, r);
		}
	}

	private static void quickSort(Comparable[] items, Comparator comparator) {
		// Implement quick sort
	}
}