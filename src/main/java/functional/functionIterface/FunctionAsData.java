package functional.functionIterface;

public class FunctionAsData {

    public static void main(String[] args) {
        Boolean IS_DEVELOPMENT = false;
        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);

        System.out.println(dataLoader.loadPerson.apply());

    }

}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class DataLoader {
    public final NoArgFunction<Person> loadPerson;

    public DataLoader(Boolean isDevelopmentEnvironment) {
        loadPerson = isDevelopmentEnvironment ?
                this::loadPersonFake :
                this::loadPersonReal;
    }

    private Person loadPersonReal() {
        System.out.println("Loading Real Person...");
        return new Person("John Doe", 34);
    }

    private Person loadPersonFake() {
        System.out.println("Loading Fake Person...");
        return new Person("Jane Doe Fake", 30);
    }
}
