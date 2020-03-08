package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author pengh
 */
public class MyReenterLock implements Lock {
    private boolean islocked = false;
    private Thread lockThread = null;
    private  int lockcount = 0;

    @Override
    public synchronized void lock() {
        Thread currentthread = Thread.currentThread();
        while (islocked && lockThread != currentthread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lockThread = currentthread;
        lockcount ++;
        islocked = true;
    }
    @Override
    public synchronized void unlock() {
        Thread currentthread = Thread.currentThread();
        if (lockThread == currentthread){
            lockcount--;
            if(lockcount == 0){
                islocked = false;
                notify();
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
