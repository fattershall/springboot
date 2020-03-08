package MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author pengh
 */
public class Main {

    public static void main(String[] args) {

        ExecutorService threadpool = Executors.newFixedThreadPool(50);
        for (int i=0;i<50;i++){
            threadpool.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getName()+":"+Singleton.getInstans());

                }
            });
        }
        threadpool.shutdown();

    }
}
