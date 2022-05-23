package linkeinlearning.generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {

	/**
	 * ? extends Building2 -> wildcard ensuring the method accepts Building2 and any type that inherited Building2 
	 * */
	static void printBuildings(List<? extends Building2> buildings) {
		for (Building2 building : buildings) {
			System.out.print(building + " ");
		}
	}
	
	/**
	 * ? super House -> means you can pass a House or any type that is a supertype of the House type
	 * */
	static void addHouseToList(List<? super House> buildings) {
		buildings.add(new House());
	}
	
	
	public static void main(String[] args) {
		// List of buildings
        List<Building2> buildings = new ArrayList();
        buildings.add(new Building2());
        buildings.add(new Building2());
        printBuildings(buildings);
        
        // List of offices
        List<Office2> offices = new ArrayList();
        offices.add(new Office2());
        offices.add(new Office2());
        printBuildings(offices);

        // List of houses
        List<House> houses = new ArrayList();
        houses.add(new House());
        houses.add(new House());
        printBuildings(houses);
        
        addHouseToList(houses);
        addHouseToList(buildings);    
		
	}
	
}

class Building2 {
	public int numberOfRooms = 7;
	
	public String toString() {
		return "building";		
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}	
	
}


class Office2 extends Building2 {
	
	
	public String toString() {
		return "office";
	}
}

class House extends Building2 {
	public int numberOfRooms = 7;
	
	@Override
	public String toString() {		
		return "house";
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	
}