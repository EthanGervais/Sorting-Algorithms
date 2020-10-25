package utilities;

import java.util.Comparator;

import problemdomain.Polygon;

public class VolumeComparator implements Comparator<Polygon> { 
	
    public int compare(Polygon a, Polygon b) {
    	double difference = a.getVolume() - b.getVolume();
    	return (int) difference;
    }
}