package ProblemSolving.Algorithms.TimeConversion;

import java.io.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String tempHour;
        if(s.contains("PM")) {
            tempHour = s.substring(0, 8);
            String[] times = tempHour.split(":");
            if (times[0].matches("12")) {
                return times[0] + ":" + times[1] + ":" + times[2];
            }
            times[0] = String.valueOf(Integer.parseInt(times[0]) + 12);
            return times[0] + ":" + times[1] + ":" + times[2];
        } else { //contain AM
            tempHour = s.substring(0, 8);
            String[] times = tempHour.split(":");
            if (times[0].matches("12")){
                times[0] = "00";
                return times[0] + ":" + times[1] + ":" + times[2];
            }
            return s.substring(0, 8);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
