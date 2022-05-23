package linkeinlearning.threads;

public class RunnableExample {

	public static void main(String[] args) {
		Thread t = new Thread(new RunnableTest());			
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while (i <= 100) {
					System.out.println(i + " " + Thread.currentThread().getName());
					i++;
				}				
			}
		});
		
		
		Runnable r = () -> {
			int i = 0;
			while (i <= 100) {
				System.out.println(i + " " + Thread.currentThread().getName());
				i++;
			}
		};		
		
		Thread t3 = new Thread(r);
		t3.setName("thread with lambda");
		
		t.start();
		t2.start();
		t3.start();
		
		

	}

}

class RunnableTest implements Runnable {

	@Override
	public void run() {
		int i = 0;
		while (i <= 100) {
			System.out.println(i + " " + Thread.currentThread().getName());
			i++;
		}
	}

}