package utilities;

import java.util.Comparator;

import problemdomain.Polygon;

/**
 * Handles calculations for the base area of polygons.
 * 
 * @author Ethan Gervais
 *
 */
public class BaseAreaComparator implements Comparator<Polygon> {

	/**
	 * Compares the base area of two polygons.
	 * 
	 * @param a The first polygon being compared.
	 * @param b The second polygon being compared.
	 * @return The difference between the two polygons.
	 */
	@Override
	public int compare(Polygon a, Polygon b) {
		double difference = a.getArea() - b.getArea();
		return (int) difference;
	}
}