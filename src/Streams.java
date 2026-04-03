import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Streams {

    // mapping, filtering and collecting
    private static void one() {
        ArrayList<String> names = new ArrayList<>(List.of("Java", "Joe", "James", "Alice", "June"));
        long names_ = names.stream()
                .filter(n -> n.charAt(0) == 'J' && n.length() > 3)
                .count();
        System.out.println(names_);

        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> numbers_ = numbers.stream()
                .map(x -> x * 2)
                .toList();
        System.out.println(numbers_);

        ArrayList<String> words = new ArrayList<>(List.of("apple", "dog", "hello", "sky"));
        List<String> words_ = words.stream()
                .filter(w -> w.contains("e"))
                .map(String::toUpperCase)
                .toList();
        System.out.println(words_);

        ArrayList<Integer> nums =  new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> nums_ = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println(nums_);
    }

    // flat maps
    private static void two() {
        ArrayList<ArrayList<String>> groceries = new ArrayList<>(List.of(new ArrayList<>(List.of("Apple", "Banana")), new ArrayList<>(List.of("Milk", "Cheese"))));
        List<String> groceries_ = groceries.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(groceries_);

        ArrayList<String> unique =  new ArrayList<>(List.of("Java", "Code"));
        List<String> unique_ = unique.stream()
                .map(u -> u.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        System.out.println(unique_);
    }

    public static void main(String[] args) {

        Streams.two();
    }
}
