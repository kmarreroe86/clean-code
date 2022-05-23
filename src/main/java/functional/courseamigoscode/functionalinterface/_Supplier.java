package functional.courseamigoscode.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {


        /** Supplier */
        Supplier<List<String>> dbConnection = () -> List.of("jdbc://localhost:5432/users");
        System.out.println("Supplier: " + dbConnection.get());
    }
}


// https://youtu.be/VRpHdSFWGPs?list=PL6dI99Y0A2Ooh-fXaQcxUxZKRQuc1pA83