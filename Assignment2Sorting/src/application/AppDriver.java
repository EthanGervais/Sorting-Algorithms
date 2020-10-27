/**
 * 
 */
package application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Comparator;

import problemdomain.*;
import utilities.*;

/**
 * This program reads in a file of polygons, a sorting method selection, and a
 * comparable type. It then outputs the time it took to sort the collection of
 * objects for each sorting algorithm, the first and last value, and every
 * thousandth value in between.
 * 
 * @author Ethan Gervais
 *
 */
public class AppDriver {

	public static void main(String[] args) throws IOException {
		File path = null;
		char sortType = 0;
		boolean isHeight = false;

		Comparator comparator = null;
		BaseAreaComparator areaCompare = new BaseAreaComparator();
		VolumeComparator volCompare = new VolumeComparator();

		for (String arg : args) {
			if (!arg.startsWith("-") || arg.length() < 3)
				continue;

			char option = Character.toLowerCase(arg.charAt(1));
			String value = arg.substring(2);

			switch (option) {
			case 'f':
				path = new File("res/" + value);
				System.out.println("File: " + value);
				break;
			case 's':
				sortType = value.toLowerCase().charAt(0);

				if (sortType == 'b') {
					System.out.println("Sort type: Bubble Sort");
				} else if (sortType == 's') {
					System.out.println("Sort type: Selection Sort");
				} else if (sortType == 'i') {
					System.out.println("Sort type: Insertion Sort");
				} else if (sortType == 'm') {
					System.out.println("Sort type: Merge Sort");
				} else if (sortType == 'q') {
					System.out.println("Sort type: Quicksort");
				} else if (sortType == 'z') {
					System.out.println("Sort type: Stupid Sort (Bogosort)");
				}

				break;
			case 't':
				if (value.toLowerCase().equals("a")) {
					comparator = areaCompare;
					System.out.println("Comparator: Base Area");
				} else if (value.toLowerCase().equals("v")) {
					comparator = volCompare;
					System.out.println("Comparator: Volume");
				} else if (value.toLowerCase().equals("h")) {
					comparator = areaCompare;
					isHeight = true;
					System.out.println("Comparator: Height");
				}
				break;
			default:
				System.out.println("Invalid option selected.");
			}

		}

		FileReader freader = new FileReader(path);

		StreamTokenizer token = new StreamTokenizer(freader);
		int next = token.nextToken();

		double arrSize = token.nval;
		next = token.nextToken();
		Comparable[] shapeArray = new Comparable[(int) arrSize]; // Set size of array to first number in file.

		int i = 0;
		while (next != StreamTokenizer.TT_EOF) {
			String shape = token.sval;
			next = token.nextToken();

			double height = token.nval;
			next = token.nextToken();

			double otherMeasurement = token.nval;
			next = token.nextToken();

			if (shape.equalsIgnoreCase("cone")) {
				Cone cone = new Cone(otherMeasurement, height);
				shapeArray[i] = cone;
			} else if (shape.equalsIgnoreCase("cylinder")) {
				Cylinder cylinder = new Cylinder(otherMeasurement, height);
				shapeArray[i] = cylinder;
			} else if (shape.equalsIgnoreCase("pyramid")) {
				Pyramid pyramid = new Pyramid(otherMeasurement, height);
				shapeArray[i] = pyramid;
			} else if (shape.equalsIgnoreCase("squareprism")) {
				PentagonalPrism sqrPrism = new PentagonalPrism(otherMeasurement, height);
				shapeArray[i] = sqrPrism;
			} else if (shape.equalsIgnoreCase("triangularprism")) {
				TriangularPrism trglPrism = new TriangularPrism(otherMeasurement, height);
				shapeArray[i] = trglPrism;
			} else if (shape.equalsIgnoreCase("pentagonalprism")) {
				PentagonalPrism pentaPrism = new PentagonalPrism(otherMeasurement, height);
				shapeArray[i] = pentaPrism;
			} else if (shape.equalsIgnoreCase("octagonalprism")) {
				OctagonalPrism octaPrism = new OctagonalPrism(otherMeasurement, height);
				shapeArray[i] = octaPrism;
			} else {
				System.out.println("No shape type detected.");
			}
			i++;
		}

		// Sorting and getting the time to sort.
		long start = System.currentTimeMillis();
		MyArrays.sort(sortType, shapeArray, comparator, isHeight);
		long end = System.currentTimeMillis();
		long timeElapsed = end - start;

		Polygon lastPoly = (Polygon) shapeArray[(int) (arrSize - 1)];

		// Displaying the values based on if the comparator is area, volume, or height.
		if (comparator.equals(areaCompare) && isHeight == false) {
			for (int j = 0; j < arrSize - 1; j += 1000) {
				Polygon nthPoly = (Polygon) shapeArray[j];
				if (j == 0) {
					System.out.printf("\nThe first value is: %.2f %n", nthPoly.getArea());
				} else {
					System.out.printf("The " + j + "th value is: %.2f %n", nthPoly.getArea());
				}
			}

			System.out.printf("The last value is: %.2f %n", lastPoly.getArea());
		} else if (comparator.equals(volCompare) && isHeight == false) {
			for (int j = 0; j < arrSize - 1; j += 1000) {
				Polygon nthPoly = (Polygon) shapeArray[j];
				if (j == 0) {
					System.out.printf("\nThe first value is: %.2f %n", nthPoly.getVolume());
				} else {
					System.out.printf("The " + j + "th value is: %.2f %n", nthPoly.getVolume());
				}
			}

			System.out.printf("The last value is: %.2f %n", lastPoly.getVolume());
		} else if (isHeight == true) {
			for (int j = 0; j < arrSize - 1; j += 1000) {
				Polygon nthPoly = (Polygon) shapeArray[j];
				if (j == 0) {
					System.out.printf("\nThe first value is: %.2f %n", nthPoly.getHeight());
				} else {
					System.out.printf("The " + j + "th value is: %.2f %n", nthPoly.getHeight());
				}
			}

			System.out.printf("The last value is: %.2f %n", lastPoly.getHeight());
		}

		System.out.printf("\nTime to sort in ms: " + timeElapsed);

	}

}
