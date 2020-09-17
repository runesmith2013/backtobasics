package com.rob.java.b2b;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

public class LambdaTest {

    static class Human {
        String name;
         int age;

         public Human(String name, int age) {
             this.name = name;
             this.age = age;
         }

         public static int compareByAgeThenName(Human h1, Human h2) {
             return 0;
         }

    }

    class HumanComparator implements Comparator<Human> {

        @Override
        public int compare(Human o1, Human o2) {
            return o1.name.compareTo(o2.name);
        }
    }


    public void prelambdasort() {
           List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Rob", 100));
           Collections.sort(humans, new HumanComparator());

        Assert.assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }


    public void lambdaSort() {
        List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Rob", 100));

        //-- new sort API added in Java 8
        humans.sort((Human h1, Human h2) -> h1.name.compareTo(h2.name));

        humans.sort((h1, h2) -> h1.name.compareTo(h2.name));

        humans.sort(Human::compareByAgeThenName);
    }

    public void reverseSort() {
        List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Rob", 100));

        humans.sort(Collections.reverseOrder());
    }

    public void sortedStream() {
        List<String> letters = Arrays.asList("1","2");
        List<String> out = letters.stream().sorted().collect(Collectors.toList());

        List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Rob", 100));
       // humans.stream().sorted(Comparator.comparing(Human::compareByAgeThenName)).collect(Collectors.toList());

    }

    public void sortedReverse() {
        List<String> letters = Arrays.asList("1","2");
        letters.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        letters.stream().sorted().collect(Collectors.toList()).sort(Collections.reverseOrder());
    }


}
