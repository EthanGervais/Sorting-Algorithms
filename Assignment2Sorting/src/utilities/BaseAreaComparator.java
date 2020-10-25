package utilities;

import java.util.Comparator;

import problemdomain.Polygon;

public class BaseAreaComparator implements Comparator<Polygon> { 
	
	@Override
    public int compare(Polygon a, Polygon b) {
    	double difference = a.getArea() - b.getArea();
    	return (int) difference;
    }
}