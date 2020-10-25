/**
 * 
 */
package application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

import problemdomain.*;
import utilities.*;

/**
 * @author Ethan Gervais
 *
 */
public class AppDriver {

	public static void main(String[] args) throws IOException {
		File path = null;
		char sortType = 0;

		for (String arg : args) {
			if (!arg.startsWith("-") || arg.length() < 3)
				continue;

			char option = Character.toLowerCase(arg.charAt(1));
			String value = arg.substring(2);

			switch (option) {
			case 'f':
				path = new File(value);
				break;
			case 's':
				sortType = value.toLowerCase().charAt(0);
				break;
			}

			System.out.println("Option: " + option + ", value: " + value);
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
		
		// Testing the sorting algorithms using the BaseAreaComparator
		BaseAreaComparator areaCompare = new BaseAreaComparator();
		VolumeComparator volCompare = new VolumeComparator();
		
//		Polygon poly = (Polygon) shapeArray[0];
//		Polygon poly2 = (Polygon) shapeArray[1];
//		Polygon poly3 = (Polygon) shapeArray[2];
//		Polygon poly4 = (Polygon) shapeArray[3];
//		
//		System.out.println("\nFirst 4 values before sorting: ");
//		System.out.println(poly.getArea());
//		System.out.println(poly2.getArea());
//		System.out.println(poly3.getArea());
//		System.out.println(poly4.getArea());
		
		long start = System.currentTimeMillis();
		MyArrays.sort(sortType, shapeArray, areaCompare);
		long end = System.currentTimeMillis();
		long timeElapsed = end - start;
		
//		poly = (Polygon) shapeArray[0];
//		poly2 = (Polygon) shapeArray[1];
//		poly3 = (Polygon) shapeArray[2];
//		poly4 = (Polygon) shapeArray[3];
//		
//		System.out.println("\nFirst 4 values after sorting: ");
//		System.out.println(poly.getArea());
//		System.out.println(poly2.getArea());
//		System.out.println(poly3.getArea());
//		System.out.println(poly4.getArea());
		
		Polygon lastPoly = (Polygon) shapeArray[(int) (arrSize - 1)];
		for (int j = 0; j < arrSize - 1; j += 1000) {
			Polygon nthPoly = (Polygon) shapeArray[j];
			System.out.println(nthPoly.getArea());
		}
		System.out.println(lastPoly.getArea());
		System.out.println("Time to sort in ms: " + timeElapsed);
		
		//System.out.println(shapeArray.length);

	}

}
