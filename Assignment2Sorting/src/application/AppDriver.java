/**
 * 
 */
package application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

import problemdomain.*;
import utilities.BaseAreaComparator;
import utilities.MyArrays;

/**
 * @author Ethan Gervais
 *
 */
public class AppDriver {

	public static void main(String[] args) throws IOException {
		File path = null;

		for (String arg : args) {
			if (!arg.startsWith("-") || arg.length() < 3)
				continue;

			char option = Character.toLowerCase(arg.charAt(1));
			String value = arg.substring(2);

			if (option == 'f') {
				path = new File(value);
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
		
		BaseAreaComparator areaCompare = new BaseAreaComparator();
		
		Polygon poly = (Polygon) shapeArray[0];
		System.out.println(poly.getArea());
		
		MyArrays.sort('b', shapeArray, areaCompare);
		
		poly = (Polygon) shapeArray[0];
		System.out.println(poly.getArea());
		System.out.println(shapeArray.length);
	}

}
