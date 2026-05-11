// Berkeley Clock Synchronization Algorithm (Short Version)

import java.util.*;

public class Berk {

    static int toSec(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    static String toTime(int t) {
        t = ((t % 86400) + 86400) % 86400;
        return (t / 3600) + ":" + ((t % 3600) / 60) + ":" + (t % 60);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calendar c = Calendar.getInstance();

        int master = toSec(
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                c.get(Calendar.SECOND));

        System.out.println("Master time: " + toTime(master));

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] node = new int[n];
        int[] diff = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter time for Node " + (i + 1) + " (h m s): ");
            node[i] = toSec(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        System.out.println("\n--- Time Differences ---");

        for (int i = 0; i < n; i++) {
            diff[i] = node[i] - master;
            sum += diff[i];
            System.out.println("Node " + (i + 1) + " difference: " + diff[i] + "s");
        }

        int avg = sum / (n + 1);

        System.out.println("\nAverage correction: " + avg + "s");

        System.out.println("\n--- Corrections ---");

        System.out.println("Master correction: " + avg + "s");

        for (int i = 0; i < n; i++) {
            System.out.println("Node " + (i + 1) + " correction: "
                    + (avg - diff[i]) + "s");
        }

        System.out.println("\n--- Synchronized Clocks ---");

        System.out.println("Master --> " + toTime(master + avg));

        for (int i = 0; i < n; i++) {
            System.out.println("Node " + (i + 1) + " --> "
                    + toTime(node[i] + (avg - diff[i])));
        }

        sc.close();
    }
}