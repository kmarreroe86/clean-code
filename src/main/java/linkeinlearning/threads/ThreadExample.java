package linkeinlearning.threads;

public class ThreadExample {

	public static void main(String[] args) {
		
		ThreadTest t = new ThreadTest();
		t.setName("My first thread");
		t.start();
		
		ThreadTest t2 = new ThreadTest();
		t2.setName("My second thread");
		t2.start();

	}

}

class ThreadTest extends Thread {

	@Override
	public void run() {
		int i = 0;
		while(i <= 100) {
			System.out.println(i + " " + this.getName());
			i++;
		}
	}
}