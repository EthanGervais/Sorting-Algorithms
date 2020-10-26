package problemdomain;

/**
 * Handles all Cone shapes.
 * 
 * @author Ethan Gervais
 *
 */
public class Cone extends Polygon {
	private double radius;
	private double height;

	/**
	 * The constructor for the Cone class
	 * 
	 * @param radius The cone's radius.
	 * @param height The cone's height.
	 */
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	/**
	 * Gets the area of the cone.
	 * 
	 * @return The area of the cone.
	 */
	@Override
	public double getArea() {
		double area = Math.PI * Math.pow(this.radius, 2);
		return area;
	}

	/**
	 * Gets the volume of the cone.
	 * 
	 * @return The volume of the cone.
	 */
	@Override
	public double getVolume() {
		double volume = (1.0 / 3) * Math.PI * Math.pow(this.radius, 2) * this.height;
		return volume;
	}

	/**
	 * Gets the height of the cone.
	 * 
	 * @return The height of the cone.
	 */
	@Override
	public double getHeight() {
		return this.height;
	}
}
