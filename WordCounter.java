import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt the user to enter text or a file
        System.out.print("Enter 'text' or 'file' to input data: ");
        String source = scanner.nextLine().trim().toLowerCase();

        String text = "";

        // Step 2: Read the input text or file
        if (source.equals("text")) {
            System.out.print("Enter the text: ");
            text = scanner.nextLine();
        } else if (source.equals("file")) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                text = readFromFile(filePath);
            } catch (IOException e) {
                System.out.println("File not found or an error occurred while reading the file.");
                return;
            }
        } else {
            System.out.println("Invalid input. Please enter 'text' or 'file'.");
            return;
        }

        // Step 3: Split the text into words
        List<String> words = splitText(text);

        // Step 4: Initialize a counter variable
        int wordCount = words.size();

        // Step 5: Display the total count of words
        System.out.println("\nTotal Word Count: " + wordCount);
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
        }
        return text.toString();
    }

    private static List<String> splitText(String text) {
        String[] words = text.split("\\s+|\\p{Punct}");
        return Arrays.asList(words);
    }
}
