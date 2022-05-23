package linkeinlearning.collections;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<>();
		myList.add("A");
		myList.add("C");
		myList.add(1, "B");
		System.out.println(myList);
		
		myList.remove("C");
		System.out.println(myList);

	}

}
