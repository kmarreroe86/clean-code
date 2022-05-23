package functional.advanced;

public class Recursion {

    public static void main(String[] args) {
        countUp(0, 10);
    }

    static void countDown(Integer x) {
        if (x < 0) {
            System.out.println("Done!");
            return;
        }
        System.out.println(x);
        countDown(x - 1);
    }

    static void countUp(Integer x, Integer end) {
        if (x > end) {
            System.out.println("Done!");
            return;
        }
        System.out.println(x);
        countUp(x + 1, end);
    }
}
