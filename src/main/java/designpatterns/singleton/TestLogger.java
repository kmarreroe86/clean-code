package designpatterns.singleton;

public class TestLogger {

    public static void main(String[] args) {

        /*var log1 = Logger.getInstance();
        var log2 = Logger.getInstance();
        System.out.println(log1.hashCode());
        System.out.println(log2.hashCode());*/

        var myThread1 = new MyThread();
        myThread1.setName("Thread Test-1");

        var myThread2 = new MyThread();
        myThread2.setName("Thread Test-2");

        var myThread3 = new MyThread();
        myThread3.setName("Thread Test-3");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            var log = Logger.getInstance();
            System.out.println(Thread.currentThread().getName() + " with log: " + log.hashCode());
        }
    }
}
