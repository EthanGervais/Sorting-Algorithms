package utilities;

import java.util.Comparator;

import problemdomain.Polygon;

/**
 * Handles calculations for the volume of polygons.
 * 
 * @author Ethan Gervais
 *
 */
public class VolumeComparator implements Comparator<Polygon> {

	/**
	 * Compares the volume of two polygons.
	 * 
	 * @param a The first polygon being compared.
	 * @param b The second polygon being compared.
	 * @return The difference in volume between the two polygons.
	 */
	@Override
	public int compare(Polygon a, Polygon b) {
		double difference = a.getVolume() - b.getVolume();
		return (int) difference;
	}
}