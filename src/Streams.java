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

    // sorting, joining and collecting
    private static void three() {
        ArrayList<Integer> scores =  new ArrayList<>(List.of(10, 50, 20, 40));
        List<Integer> scores_ = scores.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(scores_);

        ArrayList<String> colours = new ArrayList<>(List.of("Red", "Green", "Blue"));
        String colours_ = colours.stream()
                .collect(Collectors.joining("|"));
        System.out.println(colours_);

        ArrayList<String> words = new ArrayList<>(List.of("apple", "apple", "orange"));
        Set<String> words_ = words.stream()
                .collect(Collectors.toSet());
        System.out.println(words_);
    }

    // method instances
    private static void four() {
        ArrayList<Double> numbers = new ArrayList<>(List.of(4.0, 9.0, 16.0));
        List<Double> numbers_ = numbers.stream()
                .map(Math::sqrt)
                .toList();
        System.out.println(numbers_);

        ArrayList<String> words = new ArrayList<>(List.of("A", "", "B", ""));
        long words_ = words.stream()
                .filter(String::isEmpty)
                .count();
        System.out.println(words_);

        ArrayList<String> names = new ArrayList<>(List.of("Joe", "James", "Alice", "June"));
        LinkedList<String> names_ = names.stream()
                .collect(Collectors.toCollection(LinkedList::new));

        ArrayList<Integer> ids = new ArrayList<>(List.of(1, 2, 3, 4));
        ids.forEach(System.out::println);
    }

    // optionals
    private static void five() {
        ArrayList<Integer> onums = new ArrayList<>();
        Integer onums_ = onums.stream()
                .findFirst()
                .orElse(-1);
        System.out.println(onums_);

        Optional<String> status = Optional.of("active");
        status.ifPresent(System.out::println);

        Optional<String> email = Optional.of("USER@EXAMPLE.COM");
        email.map(String::toLowerCase).ifPresent(System.out::println);

        Optional<String> user = Optional.empty();
        user.orElseThrow(IllegalStateException::new);
    }

    // reducing
    private static void six() {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4));
        int nums_ = nums.stream().reduce(0, Integer::sum);
        System.out.println(nums_);
    }

    public static void main(String[] args) {

        Streams.six();
    }
}
