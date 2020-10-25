package problemdomain;

public class PentagonalPrism extends Polygon {
	private double side;
	private double height;
	
	public PentagonalPrism(double side, double height) {
		this.side = side;
		this.height = height;
	}

	@Override
	public double getArea() {
		double area = (5 * Math.pow(this.side, 2) * Math.tan(54)) / 4;
		return area;
	}

	@Override
	public double getVolume() {
		double volume = this.getArea() * this.height;
		return volume;
	}

}
