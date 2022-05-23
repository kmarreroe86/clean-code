package linkeinlearning.generics;

import java.util.Arrays;

public class Varargs {
	
	private static void printShoppingList(String item1) {
		System.out.println(item1);
	}
	
//	private static void printShoppingList(String[] items) {
//		Arrays.stream(items).forEach(System.out::println);
//	}
	
	/**
	 * Same as pass a String[] or none
	 * */
	private static void printShoppingList(String... items) {

		Arrays.stream(items).forEach(System.out::println);
	}

	public static void main(String[] args) {
		String[] shoppingList = {"apple", "orange", "chesse"};
		printShoppingList(shoppingList);

		System.out.println("\nCalling with variable arguments: ");
		printShoppingList("beer", "meat", "tabaco", "rice");

	}

}
