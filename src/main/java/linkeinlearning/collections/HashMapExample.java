package linkeinlearning.collections;

import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) {

		/**
		 * HashMap doesn't keep the order
		 * */
		HashMap<String, Integer> phonebook = new HashMap<>();
		phonebook.put("Kevin", 12345);
		phonebook.put("Jill", 98765);
		phonebook.put("Brenda", 123123);
		phonebook.put("Brenda", 22222);
		phonebook.put(null, 000);
		System.out.println(phonebook);
		if (phonebook.containsKey("Brenda")) {
			phonebook.remove("Brenda");
		}
		phonebook.clear();
		System.out.println(phonebook);

	}

}
