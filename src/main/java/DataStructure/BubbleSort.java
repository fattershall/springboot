package DataStructure;

/**
 * @author pengh
 */
public class BubbleSort {

    int[] datas = null;


    public BubbleSort(int[] datas) {
        this.datas = datas;
    }

    public int[] Sort(int[] datas){
        int len = datas.length-1;
        for(int i=0;i<datas.length;i++){
            compareAndSort(datas,len--);
        }
        return datas;
    }

    public  int[] compareAndSort(int[] datas,int len){

        for(int i=0;i<len;i++){
            int temp ;
          if(datas[i] > datas[i+1])  {
            temp = datas[i+1];
            datas[i+1] = datas[i];
            datas[i] = temp;
          }
        }
        for(int i=0;i<datas.length;i++){
            System.out.print(datas[i]);
        }
        System.out.println("+++++++++++++++++++");
        return datas;
    }

    public static void main(String[] args) {
        int[] newdatas = {2,6,5,4,1,3};
        BubbleSort sort = new BubbleSort(newdatas);
        sort.Sort(newdatas);
        for(int i=0;i<newdatas.length;i++){
            System.out.print(newdatas[i]);
        }

    }
}
