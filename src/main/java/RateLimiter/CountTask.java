package RateLimiter;

import java.util.concurrent.RecursiveTask;

/**
 * @author pengh
 */
public class CountTask extends RecursiveTask {
    private static final int THREADHOLD = 10000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start ) < THREADHOLD;
        if (canCompute){
            System.out.println("计算过程中!");
            for(long i = start ;i< end ;i++){
                sum += i;
            }
        }
        else{
            //long step = (star)
        }
        return 2L;
    }
}
