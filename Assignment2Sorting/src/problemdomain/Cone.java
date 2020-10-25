package problemdomain;

public class Cone extends Polygon {
	private double radius;
	private double height;
	
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double getArea() {
		double area = Math.PI * this.radius * (this.radius + Math.sqrt(Math.pow(this.radius, 2) + Math.pow(this.height, 2)));
		return area;
	}

	@Override
	public double getVolume() {
		double volume = (1/3) * Math.PI * Math.pow(this.radius, 2) * this.height;
		return volume;
	}
}