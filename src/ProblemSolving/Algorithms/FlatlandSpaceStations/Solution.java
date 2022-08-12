package ProblemSolving.Algorithms.FlatlandSpaceStations;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] arr) {
        Arrays.sort(arr);
        int maxDistance = arr[0];
        for(int i = 1; i < arr.length; i++){
            int distance = (arr[i] - arr[i-1]) / 2;
            if(maxDistance < distance) maxDistance = distance;
        }
        int lastGap = (n-1) - arr[arr.length - 1];
        return Math.max(lastGap, maxDistance);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
