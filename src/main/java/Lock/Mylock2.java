package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * @author pengh
 */
public class Mylock2 implements Lock {

    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readlock = lock.readLock();
    Lock writelock = lock.writeLock();

    private Helper helper = new Helper();
    public class Helper extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            Thread currentThread = Thread.currentThread();
            if (state == 0){
                if(compareAndSetState(0,arg)){
                    setExclusiveOwnerThread(currentThread);
                    return true;
                }

            }
            else if (getExclusiveOwnerThread() == currentThread){
                setState(state ++);
                return true;
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(Thread.currentThread() != getExclusiveOwnerThread()){
                throw  new RuntimeException();
            }
            int state = getState() - arg;
            boolean flag = false;
            if (state == 0){
                setExclusiveOwnerThread(null);

                flag = true;
            }
            setState(state);

            return flag;
        }

         Condition newCondition(){
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }
}
