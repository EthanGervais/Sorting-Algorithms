package problemdomain;

public abstract class Polygon implements Comparable<Polygon> {
	private double height;
	
	public abstract double getArea();
	public abstract double getVolume();
	
	public Polygon() {
		
	}

	@Override
	public int compareTo(Polygon o) {
		double difference = this.height - o.height;
		return (int) difference;
	}
	
	public double getHeight() {
		return this.height;
	}
	
}
