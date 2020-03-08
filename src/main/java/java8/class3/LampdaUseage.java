package java8.class3;

import java8.class1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author pengh
 */
public class LampdaUseage {


    public static long findFunctionApple(List<Apple> source, Function<Apple, Long> func){

        long resuls= 0;
            for (Apple apple :source){
                resuls +=  func.apply(apple);
            }
        return resuls;
    }
    public static void findConsumerApple(List<Apple> source, Consumer<Apple> consumer){
        for(Apple apple:source){
           consumer.accept(apple);
        }
    }

    public static List<Apple> findPredictApple(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> results = new ArrayList<>();
        for(Apple apple:source){
            if (predicate.test(apple))
                results.add(apple);
        }
        return  results;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green",120),new Apple("green",150),new Apple("yellow",120));
        List<Apple> predictApple = findPredictApple(list, a -> {
            return a.getColor().equals("green");
        });
        System.out.println("predictApple"+predictApple);

        findConsumerApple(list,apple -> System.out.println(apple));

        Long resultweight = findFunctionApple(list , apple -> {return apple.getWeight();});
        System.out.println("resultweight"+resultweight);

        Long resultweight2= findFunctionApple(list, Apple::getWeight);
        System.out.println("resultweight2"+resultweight2);
        Supplier<String> s = String::new;
        System.out.println("s"+s.get().getClass());

    }
}
