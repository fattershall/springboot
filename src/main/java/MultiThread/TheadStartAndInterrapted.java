package MultiThread;

/**
 * @author pengh
 */
public class TheadStartAndInterrapted extends  Thread {

    public static int i = 1;
    public TheadStartAndInterrapted(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(!isInterrupted())
        System.out.println(getName()+"方法被执行"+i++);
    }

    public static void main(String[] args) {
        TheadStartAndInterrapted t1 = new TheadStartAndInterrapted("t1");
        TheadStartAndInterrapted t2 = new TheadStartAndInterrapted("t2");
        t1.start();
        t2.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
            t2.interrupt();



    }
}
