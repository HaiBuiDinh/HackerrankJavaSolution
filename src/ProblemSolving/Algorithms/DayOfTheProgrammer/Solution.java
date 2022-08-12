package ProblemSolving.Algorithms.DayOfTheProgrammer;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    static boolean isLeap(int year){
        if(year<1918){
            if(year%4==0){
                return true;
            }else{
                return false;
            }
        }else{
            if(year%400==0 || (year%4==0 && year%100 != 0)){
                return true;
            }else{
                return false;
            }
        }

    }

    public static String dayOfProgrammer(int year) {
        // Write your code here
        if(year == 1918){
            return "26.09.1918";
        }
        if(isLeap(year)){
            return "12.09." + year;
        }else{
            return "13.09." + year;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
