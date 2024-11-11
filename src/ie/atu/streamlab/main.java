package ie.atu.streamlab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        // System.out.println("Hello, Java Streams!");
        //TASK 2:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        numbers.stream().filter(n -> n%2 != 0).forEach(System.out::println);

        //TASK 3:
        List<String> fruits = Arrays.asList("apple", "banana", "grape", "kiwi", "orange", "mango");
        List<String> filteredFruits = fruits.stream()
                                            .filter(fruit -> fruit.length() > 4)
                                            .sorted()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        filteredFruits.forEach(fruit -> System.out.println(fruit));

        //TASK 4:
        class numberUtils {
            public static int doubleNumber(int num) {
                return num * 2;        
            }
            
        }
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.stream().map(numberUtils::doubleNumber).forEach(System.out::println);
        
        //TASK 5
        List<Integer> number05s = Arrays.asList(2, 4, 6, 8, 10);
        int product = number05s.stream()
                           .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

        int min = number05s.stream()
                           .reduce(Integer.MAX_VALUE, (a, b) -> Math.min(a, b));
        System.out.println("Min value: " + min);
        

        //TASK 6:
        String inputPath = "src/ie/atu/streamlab/input.txt";

        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long count = lines.filter(line -> line.contains("Java")).count();
            System.out.println("Lines containing \"Java\": " + count);

            double averageLength = Files.lines(Paths.get(inputPath))
                                                    .mapToInt(String::length)
                                                    .average()
                                                    .orElse(0.0);
            System.out.printf("Average line length: %.2f\n", averageLength);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
