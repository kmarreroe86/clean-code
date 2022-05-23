package java8;

import java.util.Optional;

public class OptionalEx {

    public static void main(String[] args) {
        String s = null;
        Optional<String> kaka = Optional.ofNullable(s);

        String strFinal = kaka.orElseGet(() -> "empty string");
//        String strFinal = kaka.orElseGet(Main::someString);   // Same as above

        System.out.println(strFinal);

        // filter method
        String testStr = null /*"abc"*/;
        Optional<String> optionalStr = Optional.ofNullable(testStr);
        optionalStr.filter(el -> el.contains("abc"))
                .ifPresent(System.out::println);


        // map method provides a way to transform value in Optional from one type to another
        System.out.println("map method");
        String testStr2 = null/*" abc "*/;
        System.out.println("Original string: " + testStr2);
        Optional<String> optionalS = Optional.ofNullable(testStr2);
        optionalS.filter(el -> el.contains("abc"))
                .map(String::trim)
                .map(String::toUpperCase)
                .ifPresent(el -> System.out.println(el));


    }

    private static String someString() {
        return "empty string";
    }
}
