package ProblemSolving.OneWeekPreparationKit.Day3.CaesarCipher;

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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        List<Character> arr = s.chars().mapToObj(c -> (char) c).collect(toList());
        char temp;
        k = k%26;
        for (int i = 0; i < arr.size(); i++) {
            if ('A' <= arr.get(i) && arr.get(i) <= 'Z') {
                if (arr.get(i) + k > 'Z') {
                    temp = (char) (arr.get(i) + k - 'Z' + 'A' - 1);
                } else {
                    temp = (char) (arr.get(i) + k);
                }
                arr.set(i, temp);
            } else if ('a' <= arr.get(i) && arr.get(i) <= 'z') {
                if (arr.get(i) + k > 'z') {
                    temp = (char) (arr.get(i) + k - 'z' + 'a' - 1);
                } else {
                    temp = (char) (arr.get(i) + k);
                }
                arr.set(i, temp);
            }
        }

        String result = arr.stream().map(Object::toString).reduce((acc, e) -> acc + e).get();
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
