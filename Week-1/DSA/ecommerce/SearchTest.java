// SearchTest.java
import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        // Create sample products
        Product[] products = {
            new Product("P100", "Smartphone", "Electronics"),
            new Product("P205", "T-Shirt", "Clothing"),
            new Product("P050", "Coffee Mug", "Home"),
            new Product("P300", "Headphones", "Electronics"),
            new Product("P150", "Running Shoes", "Sports")
        };

        // Test linear search
        System.out.println("=== Linear Search ===");
        Product found = SearchAlgorithms.linearSearch(products, "P205");
        System.out.println("Found: " + (found != null ? found : "Not found"));

        // Prepare for binary search (requires sorted array)
        SearchAlgorithms.sortProducts(products);
        System.out.println("\nSorted Products:");
        Arrays.stream(products).forEach(System.out::println);

        // Test binary search
        System.out.println("\n=== Binary Search ===");
        found = SearchAlgorithms.binarySearch(products, "P205");
        System.out.println("Found: " + (found != null ? found : "Not found"));

        // Performance comparison
        System.out.println("\n=== Performance Analysis ===");
        System.out.println("Linear Search: O(n) - Slower for large datasets");
        System.out.println("Binary Search: O(log n) - Much faster for large datasets");
        System.out.println("But requires sorted data (O(n log n) sorting cost)");

        // Recommendation
        System.out.println("\n=== Recommendation ===");
        System.out.println("1. Use binary search for product IDs if data is pre-sorted");
        System.out.println("2. Use database indexing for flexible search queries");
        System.out.println("3. For fast lookups (O(1)), consider using HashMaps if searching by product ID frequently");
    }
}
