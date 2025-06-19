// SearchAlgorithms.java
import java.util.Arrays;
import java.util.Comparator;

public class SearchAlgorithms {

    // Linear search by productId
    public static Product linearSearch(Product[] products, String productId) {
        for (Product product : products) {
            if (product.getProductId().equalsIgnoreCase(productId)) {
                return product;
            }
        }
        return null;
    }

    // Binary search by productId (array must be sorted)
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].getProductId().compareToIgnoreCase(productId);
            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    // Sort products by productId (for binary search)
    public static void sortProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductId, String.CASE_INSENSITIVE_ORDER));
    }
}
