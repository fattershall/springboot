package DataStructure;

/**
 * @author pengh
 */
public class MyCircleQueue {
    private int[] queueDatas;
    private int insertIndex = -1;
    private int deleteIndex = 0;
    private int itemLength = 0;

    public MyCircleQueue(int length) {
        queueDatas = new int[length];
    }

    public void insertData(int data){
        if (insertIndex == queueDatas.length -1) {
            insertIndex = -1;
        }
        insertIndex ++;
        queueDatas[insertIndex] = data;
        itemLength ++;

        if(itemLength > queueDatas.length){
            itemLength = queueDatas.length;
        }
    }

    public int removeData(){
        if(itemLength == 0){
            return 0;
        }

        int temp = queueDatas[deleteIndex];
        queueDatas[deleteIndex] = 0;
        if (deleteIndex == queueDatas.length -1 ){
            deleteIndex = 0;
        }
        deleteIndex ++;
        itemLength --;

        return temp;
    }

    public int peekFront(){
        return queueDatas[deleteIndex];
    }

    public boolean isEmpty(){
        return  itemLength == 0;
    }

    public boolean isFull(){
        return itemLength == queueDatas.length ;
    }

    public void printMsg(){
        System.out.println("===================>");
        for(int d : queueDatas){
            System.out.println("data is:"+d);
        }
    }

    public static void main(String[] args) {
        MyCircleQueue t = new MyCircleQueue(5);
        t.insertData(1);
        t.insertData(2);
        t.insertData(3);
        t.insertData(4);
        t.insertData(5);
        t.printMsg();
        t.removeData();
        int ret = t.removeData();
        System.out.println("ret is +"+ret);

        t.insertData(6);
        t.insertData(7);
        t.insertData(8);

        t.printMsg();


    }
}
