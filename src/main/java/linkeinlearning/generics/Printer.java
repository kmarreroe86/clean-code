package linkeinlearning.generics;

public class Printer<T> {

    T data;

    public Printer(T data) {
        this.data = data;
    }

    public void print() {
        System.out.println(this.data);
    }
}
