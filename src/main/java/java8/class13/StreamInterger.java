package java8.class13;

import java.util.stream.IntStream;

/**
 * @author pengh
 */
public class StreamInterger {
    public static void main(String[] args) {
        int a= 9;
        IntStream.rangeClosed(1,1000)
                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0 ).boxed()
                .map(r -> new int[]{a,r,(int)Math.sqrt(a*a+r*r)})
                .forEach(res->System.out.println("a="+res[0]+",b="+res[1]+",c="+res[2]));
    }
}
