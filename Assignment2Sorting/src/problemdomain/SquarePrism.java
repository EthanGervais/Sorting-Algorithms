package problemdomain;

/**
 * Handles all Square Prism shapes.
 * 
 * @author Ethan Gervais
 *
 */
public class SquarePrism extends Polygon {
	private double side;
	private double height;
	
	/**
	 * The constructor for the SquarePrism class
	 * 
	 * @param side The cone's side length.
	 * @param height The cone's height.
	 */
	public SquarePrism(double side, double height) {
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
		double area = Math.pow(this.side, 2);
		return area;
	}

	/**
	 * Gets the volume of the prism.
	 * 
	 * @return The volume of the prism.
	 */
	@Override
	public double getVolume() {
		double volume = Math.pow(this.side, 2) * this.height;
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
