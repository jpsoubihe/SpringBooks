package com.example.demo;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Java8Tester {

    interface lambdaf1 {
        void abstractFun1(String x);
    }

    interface lambdaf2 {
        void abstractFun2(int x);
    }


    public static void main(String args[]) {
        // lambda expressions
        lambdaf2 l1 = (int x) -> System.out.println(2 * x);

        lambdaf1 l2 = (String x) -> System.out.println(x);

        l1.abstractFun2(5);

        l2.abstractFun1("Hello");

        // BiFunction

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;

        BiFunction<Integer, Integer, Integer> sub = (x, y) -> x - y;

        System.out.println("Adição: " + add.apply(3, 4));
        System.out.println("Subtração: " + sub.apply(4, 3));

        Car car = new Car();

        car.setAno(2010);
        car.setBrand("Ford");
        car.setModel("Ka");

        Soundcard soundcard = new Soundcard();

        soundcard.setModel("Pioneer");
        soundcard.setYear(2018);
        car.setSoundcard(soundcard);

        Usb myUSB = new Usb(2000, "SanDisk");
        soundcard.setUsb(myUSB);
        Optional<Usb> usb = Optional.of(myUSB);
        Optional<String> sound1 = Optional.of(car.getBrand());
        Optional<Soundcard> sound2 = Optional.ofNullable(car.getSoundcard());

//        System.out.println(sound1.isPresent());
////        System.out.println(sound2.isPresent());
////        System.out.println(usb.isPresent());

        List<Usb> devices = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            devices.add(new Usb(2000, "Modelo " + i));
        Usb d = new Usb(2000, "Modelo 1");
        Optional<List<Usb>> u = Optional.of(devices);
        devices.add(d);
        u.filter(a -> devices.contains(d)).ifPresent(value -> System.out.println("OK"));

        //Collections
        List<Integer> numbers = new LinkedList<>();// instantiates a null Linked List (Arrays.asList() works here too)
        Set<Integer> num = new HashSet<>(); // instantiates a null set

        Set<String> texts = new HashSet<>(Arrays.asList("João", "Marina", "Guilherme", "Bruno", "Bernardo")); //enunciates a pre-defined set
        texts.add("João");
        texts.add("Gustavo");
        System.out.println(texts);

        num.add(1);
        num.add(4);
        num.add(2);
        num.add(2);
        System.out.println(num);

        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(2);
        System.out.println(numbers);

        //String s = null;
        String s = "Hello";

        //Optional + methods
        Optional<String> os0 = Optional.of(s); // if null -> nullpointer exception
        Optional<String> os1 = Optional.ofNullable(s); // if null -> Optional.empty()
        System.out.println(os1); // prints what's the container Optional -> Optional['something']
        System.out.println(os1.get()); // prints the content of the container Optional -> 'something'
        System.out.println(os1.isPresent()); // checks if the optional content is present (!= null)
        //System.out.println(os1.isEmpty()); // checks if the optional content is null (== null)

        //Optional + filter
        User u1 = new User();

        Optional<String> uo = Optional.empty();
        System.out.println(uo.isPresent());
        uo = Optional.ofNullable(u1.getName());
        System.out.println(uo.isPresent()); //checks if there is something (a String) in the Optional container
        boolean a = uo.filter(b -> b.equals("João")).isPresent(); //checks if the content in the Optional equals João. Note that we've changed the type of the Optional to <String>
        System.out.println(a);

        //filter
        Optional<String> us = Optional.ofNullable(u1.getName());
        uo.filter(b -> b.equals("João")).ifPresent(c -> u1.setName(null)); //checks if the content in the Optional equals João. Note that we've changed the type of the Optional to <String>
        String str = Optional.ofNullable(u1.getName()).orElse("Carlos"); //if u1.getName() returns null then str = "Carlos"... Note that the function orElse needs a parameter while orElseGet() requires a Supplier method to execute
        System.out.println(str);

        //map
        Optional<Set<String>> so = Optional.ofNullable(texts); //First, we instantiate an Optional to the type we're going to analyze
        int size = so.map(Set::size).orElse(0); //then we evalluate the property that the Optional content gives us. On this case if size == null (the set is empty) size = 0
        System.out.println(size);

        //map
        Optional<User> optionalUser = Optional.ofNullable(u1);
        int age = optionalUser.map(User::getAge).orElse(0);
        System.out.println(age);

        //map with filter
        u1.setAge(8);
        optionalUser.map(User::getAge).filter(g -> g > 5).ifPresent(st -> System.out.println("Idade maior que 5")); //In this line we anlyse the age of the user contained on the Optional container. The filter filters the ages higher than 5

        //flat map


        //Streams
        String[] array = new String[]{"a", "b", "c"};
        List<String> listS = Arrays.asList("asgeg", "adeff", "cmmt");
        Stream<String> stream = Arrays.stream(array);
        stream = Stream.of(array);
        listS.stream().filter(h -> h.startsWith("a")).forEach(System.out::println); //turn listS in a data stream and  then manipulate the present content
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream().filter(k -> k.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println); //prints the elements that starts in c in crescent order

        Stream.of("fhiwhfw", "dbiwbfi3wf", "dib3bfw", "foibfofb", "lwhod", "odwndondf").filter(r -> r.contains("fo")).map(String::length).forEach(System.out::println); //another way is to reference manually the data stream and then manipulate it

        Set<Integer> si = new HashSet<>(Arrays.asList(10, 5, 9, 4, 2, 6));

        int[] intarray = new int[]{10, 5, 9, 4, 2, 6};
        Arrays.stream(intarray).average().ifPresent(System.out::println);

        si.stream().map(Integer::intValue).forEach(System.out::print);
        System.out.println();

        Stream.of("Operation1", "Operation2", "Operation3", "Operation4", "Operation5").map(v -> v.substring(9)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println); //we can manipulate general streams to manage primitive streams, extracting some of their content

        Stream.of("e1", "e2", "e3", "e4").filter(f -> {
            System.out.println("elemento " + f);
            return true;
        });  // intermediate operations are only executed if a terminal operation is present
        Stream.of("e1", "e2", "e3", "e4").filter(f -> {
            System.out.println("elemento " + f);
            return true;
        }).forEach(System.out::println);

        myList.stream().map(n -> {
            System.out.println("map :" + n);
            return n.toUpperCase();
        }).filter(h -> {
            System.out.println("filter: " + h);
            return h.substring(1).equals("1");
        }).forEach(y -> System.out.println("ForEach: " + y)); //the order of the methods processing a stream MATTERS!!

        Stream<String> listStream = myList.stream().filter(i -> i.startsWith("a")); //In some cases we can reuse streams, but they're tricky
        boolean b = listStream.anyMatch(j -> j.endsWith("3")); //anyMatch or noneMatch returns a boolean variable. Pay attention to the PREDICATES that gives us a criteria to match!
        //boolean b = listStream.noneMatch(o -> o.endsWith("1"));
        System.out.println(b);


        // Collect -> streams possibilite us to create collections of other elements belonging to the stream
        List<User> uList = Stream.of(new User("0aB4", "João", 23), new User("9Iu5", "Guilherme", 28), new User("8Ht5", "Bruno", 30), new User("7ty4", "Gustavo", 45)).filter(x -> x.name.startsWith("G")).collect(Collectors.toList());
        System.out.println(uList.toString());

        // we can create a single object reuniting each one of the filttered ones
        String persons = Stream.of(new User("0aB4", "João", 23), new User("9Iu5", "Guilherme", 28), new User("8Ht5", "Bruno", 30), new User("7ty4", "Gustavo", 45)).map(g -> g.getName()).collect(Collectors.joining(" and ", "In Germany ", " are cool"));
        System.out.println(persons);

        List<User> listMap = new ArrayList<>(Arrays.asList(new User("0aB4", "João", 23), new User("9Iu5", "Guilherme", 28), new User("8Ht5", "Bruno", 30), new User("7ty4", "Gustavo", 45)));

        //Map<Integer,List<String>> varmap = listMap.stream().collect(Collectors.groupingBy());
//        varmap.forEach((age,p) -> System.out.format("age: %d User: %s", age,p));

        // we can set a stream to a list or a set of elements and then process other methods within
        Double avgAge = listMap.stream().collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println(avgAge);
        IntSummaryStatistics averageAge = listMap.stream().collect(Collectors.summarizingInt(p -> p.getAge()));
        System.out.println(averageAge);


        Map<Integer, String> map = listMap.stream().collect(Collectors.toMap(p -> p.age, p -> p.name, (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);

        // until now we were utilizing pre determined colectors by class Collectors. Now let's build some of them
        // It consists by iterating on a list collecting some information that you want, it's a customizable collector that works like the ones we used above
        Collector<User, StringJoiner, String> userCollector = Collector.of(
                () -> new StringJoiner("|"), //Supplier -> gives the application a StringJoiner, that for our case is enough
                (k, l) -> k.add(l.name.toUpperCase()), //Accumulator -> adds to the StringJoiner the name of each User l
                StringJoiner::merge, // Combiner -> merge everything into a single object (Adds the contents of the given {@code StringJoiner} without prefix and suffix as the next element if it is non-empty
                StringJoiner::toString); // Enables a string to receive the collection

        String xa = listMap.stream().collect(userCollector);
        System.out.println(xa);
    }


}

