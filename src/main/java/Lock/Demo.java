package Lock;

/**
 * @author pengh
 */
public class Demo {

    private static  int signal = 0;
    public synchronized  void a(){
        while (signal != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("a");
        signal = 1;
         notifyAll();
    }

    public synchronized  void b(){
        while (signal != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("b");
        signal = 2;
        notifyAll();
    }
    public synchronized  void c(){
        while (signal != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("c");
        signal = 0;
        notifyAll();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        A a = new A(demo);
        B b = new B(demo);
        C c = new C(demo);
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();

    }

    static  class A implements  Runnable  {
        private Demo demo;
        public A(Demo demo){
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
        private Demo demo;
        public B(Demo demo){
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
        private Demo demo;
        public C(Demo demo){
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
