package MiniMaxSum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

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

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
