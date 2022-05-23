package functional.courseamigoscode.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        /** Predicate */
        Predicate<String> isPhoneNumberValid = (String phone) -> phone.startsWith("09") && phone.length() == 10;
        Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");

        System.out.println(isPhoneNumberValid.test("0997800962"));
        System.out.println(isPhoneNumberValid.test("0597800963"));
        System.out.println(isPhoneNumberValid.test("059780096"));

        System.out.println("isPhoneNumberValid.and(containsNumber3): " +
                isPhoneNumberValid.and(containsNumber3).test("0997800963"));

        System.out.println("isPhoneNumberValid.or(containsNumber3): "
                + isPhoneNumberValid.or(containsNumber3).test("0997800962"));


    }
}
