package Lock;

import java.util.concurrent.Semaphore;

/**
 * @author pengh
 */
public class SemaphoreDemo {

    public void method(Semaphore semaphore) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+" 已经进入");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 已经完成");
        semaphore.release();
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
        SemaphoreDemo demo = new SemaphoreDemo();
        while(true){
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.method(semaphore);
            }
        }).start();

        }
    }
}
