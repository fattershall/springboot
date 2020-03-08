package java8.class2;

import java8.class1.Apple;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author pengh
 */
public class LambdaExpretion {

    public static void main(String[] args) {
        Comparator<Apple> apple = (o1, o2) -> o1.getColor().compareTo(o2.getColor());

        Function<String,Integer> func = s -> s.lastIndexOf(s);

        Predicate<Apple> predicate = apple2 -> apple2.getWeight() > 1000 ;
    }
}
