package DataStructure;

/**
 * @author pengh
 */
public class HannoTower {

    public void Transfer(int topN,String src,String temp,String dest){
        if (topN == 1) {
            System.out.println(topN+"从"+src+"移动到"+dest);
        }
        else{
            Transfer(topN-1,src,dest,temp);
            System.out.println(topN+"从"+src+"移动到"+dest);

            Transfer(topN-1,temp,src,dest);
        }
    }

    public static void main(String[] args) {
        HannoTower t = new HannoTower();
        t.Transfer(10,"A","B","C");
    }
}
