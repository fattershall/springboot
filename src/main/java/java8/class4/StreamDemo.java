package java8.class4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengh
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("欧阳雪",18,"中国",'F'));
        personList.add(new Person("Tom",24,"美国",'M'));
        personList.add(new Person("Harley",22,"英国",'F'));
        personList.add(new Person("向天笑",20,"中国",'M'));
        personList.add(new Person("李康",22,"中国",'M'));
        personList.add(new Person("小梅",20,"中国",'F'));
        personList.add(new Person("何雪",21,"中国",'F'));
        personList.add(new Person("李康",22,"中国",'M'));

        personList.stream().filter(person -> person.getAge() > 20).forEach(System.out::println);

        System.out.println("++++++++++++++++++++++");

        Long chinaesenum = personList.parallelStream().filter(person -> person.getCountry().equals("中国")).count();
        System.out.println("num of china is "+chinaesenum);
    }
}
