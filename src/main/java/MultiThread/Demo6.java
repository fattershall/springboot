package MultiThread;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author pengh
 */
public class Demo6 {

    public static int add(List<Integer> values){
        //return values.parallelStream().mapToInt(a -> a).sum();
        return values.parallelStream().reduce((a,b)-> a + b).get();
    }

    public static void main(String[] args) {
        List<Integer> vaules = Arrays.asList(10,30,50,20,60);

         Optional.of(add(vaules)).ifPresent(System.out::println);


    }
}
