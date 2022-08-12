package ProblemSolving.OneWeekPreparationKit.Day1.MiniMaxSum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int length = arr.size();
        long tempSum = 0;
        long maxSum = Long.MIN_VALUE;
        long minSum = Long.MAX_VALUE;
        for(int i = 0; i< length; i++) {
            for(int j = 0; j<length; j++) {
                if (j != i) {
                    tempSum+= arr.get(j);
                }
            }
            maxSum = Math.max(tempSum, maxSum);
            minSum = Math.min(tempSum, minSum);
            tempSum = 0;
        }

        System.out.print(minSum + " " + maxSum);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
