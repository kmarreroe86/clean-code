package linkeinlearning.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {

	public static void main(String[] args) {
		
		/**
		 * LinkedHashMap preserves the order
		 * */
		LinkedHashMap<String, Integer> phonebook = new LinkedHashMap<String, Integer>(4, 0.75f, true); // Access order. Most recent access element is put it in the last
//		LinkedHashMap<String, Integer> phonebook = new LinkedHashMap();
		phonebook.put("Kevin", 12345);
		phonebook.put("Jill", 98765);
		phonebook.put("Brenda", 123123);
		phonebook.put("Gary", 22222);
		System.out.println("Kevin's number: " + phonebook.get("Kevin"));

		System.out.println("\nList of contacts in phonebook:");
		for (Map.Entry<String, Integer> entry : phonebook.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

	}

}
