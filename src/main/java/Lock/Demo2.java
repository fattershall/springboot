package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pengh
 */
public class Demo2 {

    private static  int signal = 0;
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public   void a(){
        lock.lock();
        while (signal != 0){
            try {
               a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("a");
        signal = 1;
         b.signal();
         lock.unlock();
    }

    public   void b(){
        lock.lock();
        while (signal != 1){
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("b");
        signal = 2;
        c.signal();
        lock.unlock();
    }
    public   void c(){
        lock.lock();
        while (signal != 2){
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("c");
        signal = 0;
        a.signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo2 demo = new Demo2();
        A a = new A(demo);
        B b = new B(demo);
        C c = new C(demo);
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();

    }

    static  class A implements  Runnable  {
        private Demo2 demo;
        public A(Demo2 demo){
         this.demo = demo;
        }


       @Override
       public synchronized void run() {
            while (true){
                demo.a();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


       }
   }
    static class B implements  Runnable  {
        private Demo2 demo;
        public B(Demo2 demo){
            this.demo = demo;
        }


        @Override
        public synchronized void run() {

            while (true){
                demo.b();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class C implements  Runnable  {
        private Demo2 demo;
        public C(Demo2 demo){
            this.demo = demo;
        }


        @Override
        public synchronized void run() {
            while (true){
                demo.c();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
