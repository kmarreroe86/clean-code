package functional.functionIterface;

/**
 * Accepts three arguments A1, A2, A3 and return R
 * */
public interface TriFunction<A1, A2, A3, R> {

    R apply(A1 arg1, A2 arg2, A3 arg3);
}
