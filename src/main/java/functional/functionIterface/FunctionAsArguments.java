package functional.functionIterface;

import java.util.function.BiFunction;

public class FunctionAsArguments {

    public static void main(String[] args) {
        System.out.println("Passing add: " + MyMathOperation.combine2And3(MyMathOperation::add));
        System.out.println("Passing subtract: " + MyMathOperation.combine2And3(MyMathOperation::subtract));
        System.out.println("Passing lambda: " + MyMathOperation.combine2And3((x, y) -> x * y));
    }
}

class MyMathOperation {

    public static Integer add(int x, int y) {
        return x + y;
    }

    public static Integer subtract(int x, int y) {
        return x - y;
    }

    public static Integer combine2And3(BiFunction<Integer, Integer, Integer> combine) {

        return combine.apply(2, 3);
    }
}
