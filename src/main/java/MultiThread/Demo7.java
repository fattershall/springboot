package MultiThread;

import java.util.Random;

/**
 * @author pengh
 */
public class Demo7 {

    public static void main(String[] args) {
        for(int i=0;i<5;i++){


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程执行");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"线程执行完毕");
            }
        }).start();
        }
        while(Thread.activeCount() != 2){
        System.out.println("当前数量:"+Thread.activeCount());
        }

        System.out.println("线程执行完毕................");
    }
}
