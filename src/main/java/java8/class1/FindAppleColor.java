package java8.class1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengh
 */


public class FindAppleColor {

    @FunctionalInterface
    public interface AppleFileter{
        boolean filter(Apple apple);
        default String print(){
            System.out.println("2222");
            return "";
        }
    }

    public static List<Apple> findAppleFilter(List<Apple> apples,AppleFileter appleFileter){
        List<Apple> appleList = new ArrayList<>();
            for (Apple apple:apples){
                if(appleFileter.filter(apple)){
                    appleList.add(apple);
                }
            }
        return appleList;
    }

    public static class greenweight120 implements  AppleFileter{

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight() >= 120);
            


        }
    }

    public static List<Apple> findeGreenApples(List<Apple> apples){
           List<Apple> greenApples = new ArrayList<>();

            for (Apple apple:apples){
                if (apple.getColor().equals("green") ){
                    greenApples.add(apple);
                }
            }
        return greenApples;
    }
    public static List<Apple> findeApples(List<Apple> apples,String color){
        List<Apple> greenApples = new ArrayList<>();

        for (Apple apple:apples){
            if (apple.getColor().equals(color)){
                greenApples.add(apple);
            }
        }
        return greenApples;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green",150)
                ,new Apple("red",170),new Apple("green",200));
        //List<Apple> greenapples = findeGreenApples(apples);
      //  List<Apple> redapples = findeApples(apples, "red");
       // List<Apple> appleFilter = findAppleFilter(apples, new greenweight120());
//        List<Apple> appleFilter = findAppleFilter(apples, new AppleFileter() {
//             @Override
//             public boolean filter(Apple apple) {
//                 return "red".equals(apple.getColor()) && apple.getWeight() > 150 ;
//             }
//         });

        List<Apple> appleFilter = findAppleFilter(apples,(Apple apple)->{
            return apple.getColor().equals("green");
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("####"+Thread.currentThread().getName());
            }
        });
        thread.start();

        new Thread(()->System.out.println("@@@@"+Thread.currentThread().getName())).start();
        System.out.println(appleFilter);
    }
}
