package DataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengh
 */
public class Bags {

    public void bag(int[] as, int target, int nowindex, List<Integer> listresult){
        if(nowindex == as.length){
            return;
        }

        if(as[nowindex] > target){
            this.bag(as,target,++nowindex,listresult);
        }
        else if(as[nowindex] == target){
            listresult.add(as[nowindex]);
            System.out.println("result"+listresult.toString());
            listresult.clear();
        }
        else {
            listresult.add(as[nowindex]);
            this.bag(as,target-as[nowindex],++nowindex,listresult);

        }
    }

    public static void main(String[] args) {
        Bags bags = new Bags();
        int[] as = new int[]{11,8,7,5};
        for(int i=0;i<as.length;i++){
            bags.bag(as,12,i,new ArrayList<>());
        }

    }
}
