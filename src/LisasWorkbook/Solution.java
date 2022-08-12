package LisasWorkbook;

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
     * Complete the 'workbook' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY arr
     */

    public static int workbook(int n, int k, List<Integer> arr) {
        // Write your code here
        int pageNumber = 1;
        int specialProblems = 0;

        for (int i = 0; i < arr.size(); i++) {
            int problems = arr.get(i);
            int currentProblem = 1;
            while(problems > 0) {
                int pageProblems = problems;
                pageProblems -= k;
                if(pageProblems > 0) pageProblems = k;
                else pageProblems += k;
                while(pageProblems > 0) {
                    if(pageNumber == currentProblem) specialProblems++;
                    currentProblem++;
                    pageProblems--;
                }
                problems -= k;
                pageNumber++;
            }
        }
        return specialProblems;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
