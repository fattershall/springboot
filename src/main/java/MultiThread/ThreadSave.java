package MultiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengh
 */
public class ThreadSave {
    private int value;

    //private AtomicInteger atomicInteger = new AtomicInteger(0);

    public  int getNext(){
        synchronized (ThreadSave.class){
            if(value > 0){
                return 1;
            }
            else if (value < 0){
                return -1;
            }
            else
                return value ++;
        }

    }
//    public int getAtomNext(){
//        return atomicInteger.incrementAndGet();
//    }

    public static void main(String[] args) {

//        ThreadSave  s = new ThreadSave();
//       new Thread(()->{
//           while(true){
//               System.out.println(Thread.currentThread().getName()+" "+ s.getAtomNext());
//               try {
//                   Thread.sleep(200);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//           }
//       }).start();
//        new Thread(()->{
//            while(true){
//                System.out.println(Thread.currentThread().getName()+" "+ s.getAtomNext());
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(()->{
//            while(true){
//                System.out.println(Thread.currentThread().getName()+" "+ s.getAtomNext());
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }
}
