import java.util.*;

public class AccountIDLookupinTransactionLogs {

    static int linearComparisons = 0;
    static int binaryComparisons = 0;

    // ================= LINEAR SEARCH =================
    public static int firstOccurrenceLinear(String[] arr, String target) {
        linearComparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            linearComparisons++;
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int lastOccurrenceLinear(String[] arr, String target) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            linearComparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }
        return index;
    }

    // ================= BINARY SEARCH =================
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        binaryComparisons = 0;

        while (low <= high) {
            binaryComparisons++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Count occurrences using binary search
    public static int countOccurrences(String[] arr, String target) {
        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if (first == -1) return 0;
        return last - first + 1;
    }

    public static int findFirst(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].compareTo(target) == 0) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int findLast(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].compareTo(target) == 0) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // -------- LINEAR SEARCH --------
        int first = firstOccurrenceLinear(logs, "accB");
        int last = lastOccurrenceLinear(logs, "accB");

        System.out.println("Linear Search:");
        System.out.println("First occurrence of accB: " + first);
        System.out.println("Last occurrence of accB: " + last);
        System.out.println("Comparisons: " + linearComparisons);

        // -------- SORT FOR BINARY SEARCH --------
        Arrays.sort(logs);
        System.out.println("\nSorted Logs: " + Arrays.toString(logs));

        // -------- BINARY SEARCH --------
        int index = binarySearch(logs, "accB");
        int count = countOccurrences(logs, "accB");

        System.out.println("\nBinary Search:");
        System.out.println("Index of accB: " + index);
        System.out.println("Count of accB: " + count);
        System.out.println("Comparisons: " + binaryComparisons);
    }
}