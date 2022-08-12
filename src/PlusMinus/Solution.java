package PlusMinus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double count0, countP, countN;
        count0 = countN = countP = 0;
        int length = arr.size();
        for(int i =0; i< length; i++) {
            if (arr.get(i) > 0) countP++;
            else if (arr.get(i) < 0) countN++;
            else count0++;
        }
        System.out.println((double)Math.round((countP/length)*1000000)/1000000);
        System.out.println((double)Math.round((countN/length)*1000000)/1000000);
        System.out.println((double)Math.round((count0/length)*1000000)/1000000);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
