package java8.class12;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author pengh
 */
public class StreamMatch {

    public static void main(String[] args) {
        Stream<Integer> intsteam = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10});
//        boolean match = intsteam.allMatch(integer -> integer > 0 && integer < 19);
//        System.out.println(match);
        boolean match2 = intsteam.anyMatch(integer -> integer > 5 && integer < 9);
        System.out.println(match2);
    }
}
