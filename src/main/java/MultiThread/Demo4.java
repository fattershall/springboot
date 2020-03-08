package MultiThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author pengh
 */
public class Demo4 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("正在进行计算.....");
        Thread.sleep(2000);
        return Math.subtractExact(200,288);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(new Demo4());
        Thread t1 = new Thread(task);
        t1.start();

        Integer i = task.get();
        System.out.println("我先干点别点");
        System.out.println("result is " +i );

    }
}
