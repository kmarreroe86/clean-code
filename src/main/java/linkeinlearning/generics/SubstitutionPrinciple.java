package linkeinlearning.generics;

import java.util.ArrayList;
import java.util.List;

public class SubstitutionPrinciple {
	
	static void build(Building building) {
		System.out.println(building);
	}
	
	static void buildList(List<Building> buildings) {
		for (Building building : buildings) {
			System.out.print(building + " ");
		}
	}

	public static void main(String[] args) {
		Building b = new Building();
		Office o = new Office();
		build(b);
		build(o);
		
		List<Building> buildings = new ArrayList<>();
		buildings.add(new Building());
		buildings.add(new Office());
		buildList(buildings);
		
		List<Office> offices = new ArrayList<>();
		offices.add(new Office());
		offices.add(new Office());
//		buildList(offices); // compile error. substitution principle doesn't apply.List<Office> is not subtype of List<Building>

	}

}

class Building {
	
	public String toString() {
		return "building";		
	}
}


class Office extends Building {
	
	public String toString() {
		return "office";
	}
}