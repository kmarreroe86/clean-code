package designpatterns.singleton;

public class Logger {

    private static volatile Logger instance;
    private static Object lock = new Object();


    private Logger() {
    }

    public static Logger getInstance() {
        Logger result = instance;
        if (result == null) {
            synchronized (lock) {
                result = instance;
                if (result == null) instance = result = new Logger();
            }
        }
        return result;
    }
}
