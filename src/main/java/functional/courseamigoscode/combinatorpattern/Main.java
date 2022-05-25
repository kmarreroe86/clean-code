package functional.courseamigoscode.combinatorpattern;

import java.time.LocalDate;

import static functional.courseamigoscode.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {

        var alice = new Customer("Alice", "alice@mail.com", "0908722334", LocalDate.of(2000, 1, 1));

        /*var validatorService = new CustomerValidationService();
        System.out.println(validatorService.isValid(alice));*/

        /** Using combinator patter */
        ValidationResult result =
                isEmailValid()
                        .and(isPhoneNumberValid())
                        .and(isAnAdult())
                        .apply(alice);

        System.out.println(result);
        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
