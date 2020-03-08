package MultiThread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author pengh
 */
public class Demo5 {

    public static void main(String[] args) {
       /* Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
             System.out.println(Thread.currentThread().getName()+"runing ");
            }
        },0,1000);

        */
        ExecutorService threadpool = Executors.newFixedThreadPool(10);
        for (int i=0;i<1000;i++){
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"runing ");
                }
            });
        }
        threadpool.shutdown();

    }
}
