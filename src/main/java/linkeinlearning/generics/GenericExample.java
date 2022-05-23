package linkeinlearning.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

	public static void main(String[] args) {

		List names = new ArrayList();
		names.add("karel");
		names.add(7); // -> no error at compile time
		String n = (String) names.get(0); // needs of casting
		
		System.out.println(names);
		
		List<String> names2 = new ArrayList<String>();
		names2.add("karel");
//		names2.add(7); // -> compile time error
		
		System.out.println(names2);

	}

}
