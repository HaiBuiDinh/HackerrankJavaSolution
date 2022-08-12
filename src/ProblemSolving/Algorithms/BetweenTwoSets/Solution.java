package ProblemSolving.Algorithms.BetweenTwoSets;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int max = a.stream().max(Comparator.comparing(Integer::valueOf)).get();
        int min = b.stream().min(Comparator.comparing(Integer::valueOf)).get();
        int length = min/max + 1;
        int count = 0;
        int tempValue;
        boolean isNeedContinue = true;
        for (int i = 1; i <= length; i++) {
            tempValue = max*i;
            isNeedContinue = true;
            if (tempValue > min) break;
            for (int j = 0; j < a.size(); j++) {
                if (tempValue % a.get(j) != 0) {
                    isNeedContinue = false;
                    break;
                }
            }
            if (!isNeedContinue) continue;
            for (int k = 0; k < b.size(); k++) {
                if (b.get(k) % tempValue != 0) {
                    isNeedContinue = false;
                    break;
                }
            }
            if (isNeedContinue) count++;
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
