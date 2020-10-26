package problemdomain;

/**
 * Handles all Pentagonal Prism shapes.
 * 
 * @author Ethan Gervais
 *
 */
public class PentagonalPrism extends Polygon {
	private double side;
	private double height;
	
	/**
	 * The constructor for the PentagonalPrism class
	 * 
	 * @param side The cone's side length.
	 * @param height The cone's height.
	 */
	public PentagonalPrism(double side, double height) {
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
		double area = (5 * Math.pow(this.side, 2) * Math.tan(54)) / 4;
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
