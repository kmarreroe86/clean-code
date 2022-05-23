package linkeinlearning.ioStreams;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the name, age and phone number: ");
		String name = scanner.next();
		int age = scanner.nextInt();
		Long phoneNumber = scanner.nextLong();
		Person person = new Person(name, age, phoneNumber);

	}

}

class Person {

	private String name;
	private int age;
	private long phoneNumber;

	public Person(String name, int age, long phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		System.out.println("Person Created. Name: " + name + ", Age: " + age + ", phone number: " + phoneNumber);
	}

}
