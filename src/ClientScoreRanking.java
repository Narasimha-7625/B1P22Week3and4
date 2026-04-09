import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ":" + riskScore + "(" + accountBalance + ")";
    }
}

public class ClientScoreRanking {

    // Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        System.out.println("Bubble Sort (Ascending) - Swap Visualization:");

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    // Swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;

                    // Visualization
                    System.out.println("Swap: " + arr[j] + " <-> " + arr[j + 1]);
                }
            }

            if (!swapped) break;
        }

        System.out.println("Total Swaps: " + swaps);
        System.out.println("Sorted (Ascending): " + Arrays.toString(arr));
    }

    // Insertion Sort (Descending by riskScore, then accountBalance)
    public static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (Descending):");
        System.out.println(Arrays.toString(arr));
    }

    // Comparator: riskScore DESC, then accountBalance DESC
    public static int compare(Client c1, Client c2) {
        if (c1.riskScore != c2.riskScore)
            return Integer.compare(c1.riskScore, c2.riskScore);
        return Double.compare(c1.accountBalance, c2.accountBalance);
    }

    // Top 10 highest risk clients
    public static void topClients(Client[] arr) {
        System.out.println("\nTop High Risk Clients:");

        int limit = Math.min(10, arr.length);

        for (int i = 0; i < limit; i++) {
            System.out.println(arr[i].name + "(" + arr[i].riskScore + ")");
        }
    }

    public static void main(String[] args) {

        // Sample Input
        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 3000),
                new Client("clientB", 50, 4000)
        };

        // Clone arrays for separate sorting
        Client[] bubbleArr = clients.clone();
        Client[] insertionArr = clients.clone();

        // Bubble Sort (Ascending)
        bubbleSort(bubbleArr);

        // Insertion Sort (Descending)
        insertionSort(insertionArr);

        // Top Risk Clients
        topClients(insertionArr);
    }
}