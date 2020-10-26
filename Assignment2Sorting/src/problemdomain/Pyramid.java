package problemdomain;

/**
 * Handles all Pyramid shapes.
 * 
 * @author Ethan Gervais
 *
 */
public class Pyramid extends Polygon {
	private double side;
	private double height;

	/**
	 * The constructor for the Pyramid class
	 * 
	 * @param radius The pyramid's radius.
	 * @param height The pyramid's height.
	 */
	public Pyramid(double side, double height) {
		this.side = side;
		this.height = height;
	}

	/**
	 * Gets the area of the pyramid.
	 * 
	 * @return The area of the pyramid.
	 */
	@Override
	public double getArea() {
		double area = Math.pow(this.side, 2);
		return area;
	}

	/**
	 * Gets the volume of the pyramid.
	 * 
	 * @return The volume of the pyramid.
	 */
	@Override
	public double getVolume() {
		double volume = (1.0 / 3) * Math.pow(this.side, 2) * this.height;
		return volume;
	}

	/**
	 * Gets the height of the pyramid.
	 * 
	 * @return The height of the pyramid.
	 */
	@Override
	public double getHeight() {
		return this.height;
	}

}
