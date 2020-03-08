package RateLimiter;

import com.google.common.util.concurrent.RateLimiter;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.concurrent.*;

/**
 * @author pengh
 */
public class RateLimiterDemo {

    public static void main(String[] args) {

       // RateLimiter limit = RateLimiter.create(100);

//        for(int i= 0;i< 100 ;i++){
//            if (!limit.tryAcquire()){
//                continue;
//            }
//            new Thread(()-> System.out.println(System.currentTimeMillis())).start();
//        }
    //    System.out.println(0x7fffffff);

        ExecutorService executorService = new ThreadPoolExecutor(5,5,0L,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()){

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
            }

            @Override
            protected void terminated() {
                super.terminated();
            }
        };
    }
}
