package OneWeekPreparationKit.Day4.RecursiveDigitSum;

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
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */


    public static String supDig(String n) {
        if(n.length() == 1) return n;
        else {
            int np = 0;

            for(int i = 0; i < n.length(); i++) {
                np += Character.getNumericValue( n.charAt(i) );
            }

            return supDig(Integer.toString(np));
        }
    }

    public static int supDig(int n) {
        if(n / 10 == 0) return n;
        else {
            int r = 0;

            while(n > 0) {
                r += n % 10;
                n /= 10;
            }

            return supDig(r);
        }
    }

    public static int superDigit(String n, int k) {
        // Write your code here
        int pSum = Integer.parseInt(supDig(n));
        pSum *= k;

        return supDig(pSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
