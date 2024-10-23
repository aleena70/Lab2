package Lab2;
import java.util.Arrays;
import java.util.Scanner;


public class TopKFrequentNumbers {
    // Static variable to store the input array
    private static int[] numbers;

    // Static method to find and print the top K frequent numbers
    public static void findTopKFrequent(int k) {
        int n = numbers.length;
        // Array to store the count of occurrences
        int[] count = new int[n];

        // Count occurrences for each number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (numbers[i] == numbers[j]) {
                    count[i]++;
                }
            }
        }

        // Create an array of indices to sort based on frequency and value
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort the indices based on count and then by number value
        Arrays.sort(indices, (a, b) -> {
            if (count[b] == count[a]) {
                return Integer.compare(numbers[b], numbers[a]); // Sort by number value
            }
            return Integer.compare(count[b], count[a]); // Sort by frequency
        });

        // Print the top K frequent numbers
        System.out.println("Top " + k + " frequent numbers:");
        for (int i = 0; i < k; i++) {
            System.out.println(numbers[indices[i]] + " (Frequency: " + count[indices[i]] + ")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Initialize the numbers array
        numbers = new int[n];

        // Input for the numbers in the array
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Input for K
        System.out.print("Enter the value of K: ");
        int k = scanner.nextInt();

        // Call the static method to find and print the top K frequent numbers
        findTopKFrequent(k);

        scanner.close();
    }
}