package linkeinlearning.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {

	static Character[] charArray = { 'h', 'e', 'l', 'l', 'o' };
	static Integer[] intArray = { 1, 2, 3, 4, 5 };
	static Boolean[] boolArray = { true, false, true };
	
	/**
	 * Declare local type variable <T> before the return type of the method
	 * */
	public static <T> List<T> arrayToList(T[] array, List<T> list) {
		for (T object : array) {
			list.add(object);
		}
		
		return list;
	}

	public static void main(String[] args) {
		List<Character> charList = arrayToList(charArray, new ArrayList<>());
		List<Boolean> intList = arrayToList(boolArray, new ArrayList<>());
		List<Integer> boolList = arrayToList(intArray, new ArrayList<>());
		
//		List<String> wrongList = arrayToList(intArray, new ArrayList<>());
//		System.out.println(wrongList.get(0));

	}

}
