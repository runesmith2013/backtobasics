package com.rob.java.b2b;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Stream.*;

public class StreamsTest {

    @Test
    public void testEmptyStream() {
        try (Stream<String> streamEmpty = empty()) {
        }

    }

    private Stream<String> streamOf(List<String> list) {
         return null;
        //        return list = !list.isEmpty() ? list.stream() : null;
    }

    @Test
    public void testStreamOfCollection() {
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> stream = collection.stream();


        Stream<String> streamOfArray = of("a","b","c");

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1,3);

        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        Stream<String> generated = generate(()->"element").limit(10);

        Stream<Integer> streamIterated = iterate(40, n-> n+2).limit(20);
    }

    @Test
    public void streamOfPrimitives() {
        IntStream intStream = IntStream.range(1,3);
        LongStream longStream = LongStream.range(1,3);

        Random random = new Random();
        DoubleStream doubleStream = random.doubles();

    }

    @Test
    public void streamOfString() {
        IntStream streamOfChars = "abc".chars();
    }


    @Test
    public void streamOfFile() throws IOException {
        Path path = Paths.get("C:\\file.txt");
        Stream<String> stream = Files.lines(path);

    }


    public void referencingAStream() {
        Stream<String> stream = of("a","b","c").filter(element-> element.contains("b"));

        //-- terminal operation
        Optional<String> anyElement = stream.findAny();

        //-- will trigger an illegalstateexception
        Optional<String> first = stream.findFirst();

        List<String> elements = of("a","b","c").filter(element->element.contains("b")).collect(Collectors.toList());
        Optional<String> any = elements.stream().findAny();
        Optional<String> first1 = elements.stream().findFirst();
    }

    public void streamPipeline() {
        //-- requires source, intermediate ops and terminal operations

        //-- intermediate returns a new modified stream
        Stream<String> onceModified = of("a","b","c").skip(1);

        Stream<String> twiceModified = of("abc","bcd","avc").skip(1).map(element -> element.substring(0,3));

        List<String> list = Arrays.asList("Abc1","abc2");
        long size = list.stream().skip(1).map(element-> element.substring(0,3)).sorted().count();


        Optional<String> strean = list.stream().filter(element-> {
            System.out.println("filter was called");
            return element.contains("a");
        }).map(element -> {
            System.out.println("map called");
            return element.toUpperCase();
        }).findFirst();


    }

    //-- reduces to a primitive
    @Test
    public void streamReduction() {
        OptionalInt reduced = IntStream.range(1,4).reduce((a,b) -> a+b);

        int reduceedTwoParam = IntStream.range(1,4).reduce(10, (a,b) -> a+b);
    }

    public void streamCollection() {
        List<Product> productList = Arrays.asList(new Product(1), new Product(2));
        productList.stream().map(Product::getName).collect(Collectors.toList());

        productList.stream().map(Product::getName).collect(Collectors.joining(",","[","]"));

        double averagePrice = productList.stream().collect(Collectors.averagingInt(Product::getPrice));

    }







}
