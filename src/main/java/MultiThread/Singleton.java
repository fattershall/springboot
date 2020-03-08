package MultiThread;

/**
 * @author pengh
 */
public class Singleton {

    private static volatile Singleton singleton;
    private Singleton(){


    }


    public static Singleton getInstans(){
        if (singleton == null){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singleton.class){
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }

        }
        return singleton;
    }


}
