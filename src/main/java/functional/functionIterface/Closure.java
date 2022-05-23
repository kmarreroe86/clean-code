package functional.functionIterface;

public class Closure {

    public static void main(String[] args) {

        /** When a function is returned, it has access to the context in which its created */
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> {
            String name = "John";
            return () -> "Hello " + name;
        };

        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());


    }
}
