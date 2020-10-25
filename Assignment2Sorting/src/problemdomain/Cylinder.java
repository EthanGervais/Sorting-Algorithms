package problemdomain;

public class Cylinder extends Polygon {
	private double radius;
	private double height;

	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double getArea() {
		double area = Math.PI * Math.pow(radius, 2);
		return area;
	}

	@Override
	public double getVolume() {
		double volume = Math.PI * Math.pow(this.radius, 2) * this.height;
		return volume;
	}

}
