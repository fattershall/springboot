package Lock;

/**
 * @author pengh
 */
public class ReenterLockManul {
    private MyReenterLock lock = new MyReenterLock();

    public void a(){
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }
    public void b(){
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {

        ReenterLockManul r = new ReenterLockManul();
        new Thread(new Runnable() {
            @Override
            public void run() {
                r.a();
            }
        }).start();

    }
}
