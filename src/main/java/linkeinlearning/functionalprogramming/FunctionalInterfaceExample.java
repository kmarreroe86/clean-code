package linkeinlearning.functionalprogramming;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {


        GreetingMessage gm = new GreetingMessage() {
            @Override
            public void greet(String msg) {
                System.out.println(msg);
            }
        };
        gm.greet("hello karel annonymous");


        // Lambda
        GreetingMessage gm2 = (msg) -> System.out.println(msg.toUpperCase());
        gm2.greet("hello karel using lambda");


        PrintMessage pm = () -> {
            System.out.println("Parameterless lambda");
        };
        pm.printMessage();

    }

}


/**
 * Only one abstract method (method with no body)
 */
@FunctionalInterface
interface GreetingMessage {
    void greet(String msg);
}


@FunctionalInterface
interface PrintMessage {
    void printMessage();
}
