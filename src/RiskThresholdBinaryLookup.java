import java.util.*;

public class RiskThresholdBinaryLookup {

    static int linearComparisons = 0;
    static int binaryComparisons = 0;

    // ================= LINEAR SEARCH =================
    public static boolean linearSearch(int[] arr, int target) {
        linearComparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            linearComparisons++;
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    // ================= BINARY SEARCH (Insertion Point) =================
    public static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        binaryComparisons = 0;

        while (low <= high) {
            binaryComparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low; // insertion index
    }

    // ================= FLOOR =================
    public static Integer floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer ans = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // ================= CEILING =================
    public static Integer ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer ans = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100}; // sorted
        int target = 30;

        // -------- LINEAR SEARCH --------
        boolean found = linearSearch(risks, target);
        System.out.println("Linear Search:");
        System.out.println("Found " + target + "? " + found);
        System.out.println("Comparisons: " + linearComparisons);

        // -------- BINARY SEARCH --------
        int insertIndex = insertionPoint(risks, target);
        Integer f = floor(risks, target);
        Integer c = ceiling(risks, target);

        System.out.println("\nBinary Search:");
        System.out.println("Insertion Index: " + insertIndex);
        System.out.println("Floor(" + target + "): " + f);
        System.out.println("Ceiling(" + target + "): " + c);
        System.out.println("Comparisons: " + binaryComparisons);
    }
}