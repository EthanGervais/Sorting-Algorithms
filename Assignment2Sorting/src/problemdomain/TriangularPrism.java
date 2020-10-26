package problemdomain;

/**
 * Handles all Triangular Prism shapes.
 * 
 * @author Ethan Gervais
 *
 */
public class TriangularPrism extends Polygon {
	private double side;
	private double height;

	/**
	 * The constructor for the TriangularPrism class
	 * 
	 * @param side The cone's side length.
	 * @param height The cone's height.
	 */
	public TriangularPrism(double side, double height) {
		this.side = side;
		this.height = height;
	}

	/**
	 * Gets the area of the prism.
	 * 
	 * @return The area of the prism.
	 */
	@Override
	public double getArea() {
		double area = (Math.pow(this.side, 2) * Math.sqrt(3)) / 4;
		return area;
	}

	/**
	 * Gets the volume of the prism.
	 * 
	 * @return The volume of the prism.
	 */
	@Override
	public double getVolume() {
		double volume = this.getArea() * this.height;
		return volume;
	}

	/**
	 * Gets the height of the prism.
	 * 
	 * @return The height of the prism.
	 */
	@Override
	public double getHeight() {
		return this.height;
	}

}
