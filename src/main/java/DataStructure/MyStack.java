package DataStructure;

/**
 * @author pengh
 */
public class MyStack {
    int[] datas = null;
    int dataindex = -1;

    public MyStack(int length) {
       datas = new int[length];
    }
    public void push(int data){
        dataindex ++;
        datas[dataindex] = data;
    }
    public int pop(){
        int ret = datas[dataindex];
        datas[dataindex] = 0;
        dataindex --;

        return ret;
    }
    public int peek(){
        return datas[dataindex];
    }
    public boolean isEmpty(){
        return dataindex == -1;
    }

    public boolean isFull(){
        return dataindex == datas.length -1;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(9);
        stack.push(5);
        for(int d : stack.datas){
            System.out.println(d);
        }
        System.out.println("===========>"+stack.isFull());
        System.out.println("===========>"+stack.pop());
        System.out.println("===========>"+stack.pop());
        System.out.println("===========>"+stack.pop());
       // System.out.println("===========>"+stack.pop());
      //  System.out.println("===========>"+stack.pop());
        System.out.println("===========>"+stack.isEmpty());
        for(int d : stack.datas){
            System.out.println(d);
        }
    }
}
