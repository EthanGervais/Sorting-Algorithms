package problemdomain;

public class TriangularPrism extends Polygon {
	private double side;
	private double height;
	
	public TriangularPrism(double side, double height) {
		this.side = side;
		this.height = height;
	}

	@Override
	public double getArea() {
		double area = (Math.pow(this.side, 2) * Math.sqrt(3)) / 4;
		return area;
	}

	@Override
	public double getVolume() {
		double volume = this.getArea() * this.height;
		return volume;
	}

}
