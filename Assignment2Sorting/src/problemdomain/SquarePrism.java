package problemdomain;

public class SquarePrism extends Polygon {
	private double side;
	private double height;
	
	public SquarePrism(double side, double height) {
		this.side = side;
		this.height = height;
	}

	@Override
	public double getArea() {
		double area = Math.pow(this.side, 2);
		return area;
	}

	@Override
	public double getVolume() {
		double volume = Math.pow(this.side, 2) * this.height;
		return volume;
	}

}
