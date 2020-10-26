package problemdomain;

/**
 * Handles all Cylinder shapes.
 * 
 * @author Ethan Gervais
 *
 */
public class Cylinder extends Polygon {
	private double radius;
	private double height;

	/**
	 * The constructor for the Cylinder class
	 * 
	 * @param radius The cylinder's radius.
	 * @param height The cylinder's height.
	 */
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	/**
	 * Gets the area of the cylinder.
	 * 
	 * @return The area of the cylinder.
	 */
	@Override
	public double getArea() {
		double area = Math.PI * Math.pow(this.radius, 2);
		return area;
	}

	/**
	 * Gets the volume of the cylinder.
	 * 
	 * @return The volume of the cylinder.
	 */
	@Override
	public double getVolume() {
		double volume = Math.PI * Math.pow(this.radius, 2) * this.height;
		return volume;
	}

	/**
	 * Gets the height of the cylinder.
	 * 
	 * @return The height of the cylinder.
	 */
	@Override
	public double getHeight() {
		return this.height;
	}

}
