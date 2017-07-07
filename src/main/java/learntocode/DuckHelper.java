package headfirst.designpatterns.iterator.dinermergercafe;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DuckHelper {
    public static int compareByWeight(DuckDuck d1, DuckDuck d2) {
        return d1.getWeight() - d2.getWeight();
    }

    public static int compareByName(DuckDuck d1, DuckDuck d2) {
        return d1.getName().compareTo(d2.getName());
    }

    public static void main(String[] args) {
        Comparator<DuckDuck> byWeight = DuckHelper::compareByWeight;
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);

        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);

        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();

        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();

        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list); // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list); // [Magician]

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list1.replaceAll(x -> x * 2);
        System.out.println(list1); // [2, 4, 6]

        List<String> cats = Arrays.asList("Annie", "Ripley");
        for (String cat : cats)
            System.out.println(cat);

        cats.forEach(c -> System.out.println(c));
        cats.forEach(System.out::println);

        Map<String, String> favorites1 = new HashMap<>();
        favorites1.put("Jenny", "Bus Tour");
        favorites1.put("Jenny", "Tram");
        System.out.println(favorites1); // {Jenny=Tram}

/*        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}*/

/*        BiFunction<String, String, String> mapper = (v1, v2)
                -> v1.length() > v2.length() ? v1 : v2;

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");

        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);

        System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny); // Bus Tour
        System.out.println(tom); // Skyride*/

  /*      BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() >
                v2.length() ? v1 : v2;
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Sam", null);
        favorites.merge("Tom", "Skyride", mapper);
        favorites.merge("Sam", "Skyride", mapper);
        System.out.println(favorites); // {Tom=Skyride, Sam=Skyride}*/

        BiFunction<String, String, String> mapper = (v1, v2) -> null;
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Bus Tour");
        favorites.merge("Jenny", "Skyride", mapper);
        favorites.merge("Sam", "Skyride", mapper);
        System.out.println(favorites); // {Tom=Bus Tour, Sam=Skyride}

    }
}
