package MultiThread;

/**
 * @author pengh
 */
public class Demo3 implements Runnable {
    @Override
    public void run() {
        System.out.println("thread start");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Demo3());
        t1.start();

        new Thread(){

            @Override
            public void run() {
                System.out.println("thread2 is running");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread3 is running");
            }
        }).start();
    }
}
