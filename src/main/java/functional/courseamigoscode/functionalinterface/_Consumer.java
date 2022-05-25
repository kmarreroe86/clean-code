package functional.courseamigoscode.functionalinterface;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        /** Consumer: Represents and operation that accepts a single input argument and returns no result */
        Consumer<Customer> greetCustomer = (Customer customer) -> System.out.println("(Consumer) Hello " + customer.getName() +
                ", thanks for registering phone number " +
                customer.getPhoneNumber());

        Customer johnDoe = new Customer("Jonh Doe", "999-888-7777");
        greetCustomer.accept(johnDoe);

        /** BiConsumer: Represents and operation that accepts a two input argument and returns no result */
        BiConsumer<Customer, Boolean> greetCustomerV2 = (customer, showPhoneNumber) ->
                System.out.println("(BiConsumer) Hello " + customer.getName() +
                        ", thanks for registering phone number " +
                        (showPhoneNumber ? customer.getPhoneNumber() : "**********"));
        greetCustomerV2.accept(johnDoe, false);

    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.getName() +
                ", thanks for registering phone number " +
                customer.getPhoneNumber());
    }
}

@Data
@AllArgsConstructor
class Customer {
    private final String name;
    private final String phoneNumber;

    /*public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }*/
}


