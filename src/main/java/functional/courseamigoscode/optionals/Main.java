package functional.courseamigoscode.optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        var value = Optional.ofNullable(null)
                .orElseGet(() -> "Default value");
//                .orElseThrow(() -> new IllegalStateException("Not null supported"));

        System.out.println(value);

        Optional.ofNullable("null")
                .ifPresent(val -> {
                    var n = val.length();
                    System.out.println(n);
                });

        Optional.ofNullable("k@gmail.com")
                .ifPresentOrElse(
                        email -> System.out.println(email),
                        () -> System.out.println("Invalid email")
                );

    }
}

// https://youtu.be/VRpHdSFWGPs?list=PL6dI99Y0A2Ooh-fXaQcxUxZKRQuc1pA83&t=5480
