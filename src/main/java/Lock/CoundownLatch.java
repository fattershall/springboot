package Lock;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author pengh
 */
public class CoundownLatch {



    public int getLine(){
        return 0;
    }
    public static List<String> ReadFile() throws IOException {
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("e:\\sum.txt"));
        String s = null;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            result.append(System.lineSeparator()+s);
            list.add(s);

        }
        
        return list;
    }

    public static int cal(String list, int linecount, CountDownLatch latch){
        int res =0;
        String[] temp = list.split(",");
//        for(String s :temp){
//            res += Integer.valueOf(s);
//        }
        res = Arrays.stream(temp).mapToInt(a-> Integer.valueOf(a)).sum();
        System.out.println("当前行的合计是"+res);
        latch.countDown();
        return res;
    }
    public static int sum(int[] temp){
        int res =0;
        for(int i=0;i<temp.length;i++){
            res += temp[i];
        }
        System.out.println("总和是"+res);
        return res;
    }

    public static void main(String[] args) {


        try {
        List<String> list =  ReadFile();
        int listcount = list.size();
        int[] temp  = new int[listcount];
        CountDownLatch c = new CountDownLatch(listcount);
        for(int i=0;i< listcount;i++){
             int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    temp[j] = cal(list.get(j),j,c);
                }
            }).start();
        }

        c.await();
        sum(temp);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
