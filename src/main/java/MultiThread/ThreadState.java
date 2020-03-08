package MultiThread;

/**
 * @author pengh
 */
public class ThreadState implements Runnable {


    public static void main(String[] args) {
        ThreadState n = new ThreadState();
        Thread thread = new Thread(n);
        thread.start();

        Runnable runnable = () -> {

                while (true) {
                    synchronized (n) {
                    System.out.println("主线程开始了.....");

                    try {

                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    n.notifyAll();
                }

            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.start();


    }

    @Override
    public synchronized void run() {


        while (true) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("副的线程执行了.....");
        }

    }
}
