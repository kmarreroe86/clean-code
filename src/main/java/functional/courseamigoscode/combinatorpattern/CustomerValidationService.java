package functional.courseamigoscode.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidationService {


    private boolean isValidEmail(String email) {
        return email.contains("@");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("09");
    }

    private boolean isAdult(LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears() >= 18;
    }

    public boolean isValid(Customer customer) {
        return isValidEmail(customer.getEmail()) &&
                isValidPhoneNumber(customer.getPhoneNumber()) &&
                isAdult(customer.getDateOfBirth());
    }
}
