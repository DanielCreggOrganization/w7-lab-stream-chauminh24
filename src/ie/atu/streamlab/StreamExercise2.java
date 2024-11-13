package ie.atu.streamlab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExercise2 {
    public static void main(String[] args) {
        String filePath = "src/ie/atu/streamlab/input.txt";  // Make sure this file exists

        try {
            // Read file and process its contents
            // long wordCount = Files.lines(Paths.get(filePath))  // Create stream of lines
            //     .flatMap(line -> Arrays.stream(line.split("\\s+")))  // Split into words
            //     .filter(word -> word.length() > 5)  // Keep words longer than 5 chars
            //     .map(String::toUpperCase)  // Convert to uppercase
            //     .peek(System.out::println)  // Print each word (intermediate operation)
            //     .count();  // Terminal operation: count words

            // System.out.println("\nTotal words processed: " + wordCount);

            long wordCount = Files.lines(Paths.get(filePath))
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(word -> word.contains("Ja"))
                .count();

            System.out.println("\nTotal words that contain \"Ja\": " + wordCount);

            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}