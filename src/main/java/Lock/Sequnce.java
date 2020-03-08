package Lock;

/**
 * @author pengh
 */
public class Sequnce {

    private int value = 0;

    private  int getNextValue(){
        Mylock lock = new Mylock();
        lock.lock();

        value ++ ;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();

        return value;
    }

    public static void main(String[] args) {
        Sequnce s = new Sequnce();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {

                        System.out.println(s.getNextValue());
                    }
                }
            }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println(s.getNextValue());
                }
            }
        }).start();

    }
}
