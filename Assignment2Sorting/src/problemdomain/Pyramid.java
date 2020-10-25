package problemdomain;

public class Pyramid extends Polygon{
	private double side;
	private double height;
	
	public Pyramid(double side, double height) {
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
		double volume = (1/3) * Math.pow(this.side, 2) * this.height;
		return volume;
	}

}