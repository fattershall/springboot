package DataStructure;

/**
 * @author pengh
 */
public class Digui {

    public static int jiecheng(int num){

            if (num == 1){
                return 1;
            }


        return num * jiecheng( num -1) ;
    }

    public static int sum(int num){
        if(num == 1){
            return 1;
        }
        return num + sum(num -1);
    }

    public static void main(String[] args)
    {
        System.out.println(jiecheng(10));
        System.out.println(sum(100));
    }
}
