package problemdomain;

/**
 * This class handles all of the polygons from the input file.
 * 
 * @author Ethan Gervais
 *
 */
public abstract class Polygon implements Comparable<Polygon> {
	private double height;

	public abstract double getArea();

	public abstract double getVolume();

	/**
	 * The no-args constructor for the Polygon class.
	 */
	public Polygon() {

	}

	/**
	 * Compares the height of two polygons.
	 * 
	 * @param p The second polygon being compared.
	 * @return The difference in height between the two polygons.
	 */
	@Override
	public int compareTo(Polygon p) {
		return (int) (this.getHeight() - p.getHeight());
	}

	/**
	 * Gets the height of a polygon.
	 * 
	 * @return The height of the polygon.
	 */
	public double getHeight() {
		return this.height;
	}

}
