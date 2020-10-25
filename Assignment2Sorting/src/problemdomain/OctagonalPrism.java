package problemdomain;

public class OctagonalPrism extends Polygon {
	private double side;
	private double height;
	
	public OctagonalPrism(double side, double height) {
		this.side = side;
		this.height = height;
	}

	@Override
	public double getArea() {
		double area = 2 * (1 + Math.sqrt(2)) * Math.pow(this.side, 2);
		return area;
	}

	@Override
	public double getVolume() {
		double volume = this.getArea() * this.height;
		return volume;
	}

}
