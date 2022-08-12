package ProblemSolving.Algorithms.AppendAndDelete;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        final int sL = s.length();
        final int tL = t.length();

        int lastCommon = -1;
        while(lastCommon + 1 < sL && lastCommon + 1 < tL && s.charAt(lastCommon+1) == t.charAt(lastCommon+1)) {
            lastCommon++;
        }

        if(lastCommon == -1) { // If strings are different
            if(k >= tL + sL) { // If k more then target lenght and remainder is even
                return "Yes";
            } else {
                return "No";
            }
        } else {
            int sDiff = sL - lastCommon - 1;
            int tDiff = tL - lastCommon - 1;
            if(k >= tL + sL) {
                return "Yes";
            } else if(k >= sDiff + tDiff && (k - sDiff -tDiff)%2 == 0) {
                return"Yes";
            } else {
                return"No";
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
