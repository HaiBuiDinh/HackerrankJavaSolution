package ProblemSolving.Algorithms.ModifiedKaprekarNumbers;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        boolean flag = false;//Denotes if a Kaprekar number has been found

        if(p == 1)//Handle the one case where a 1 digit square is a Kaprekar
        {
            System.out.print(p+" ");
            flag = true;
        }


        for(long i = p; i <= q; i++)
        {
            long squareLong = i * i;
            String squareStr = String.valueOf(squareLong);

            if(squareStr.length() > 1)
            {
                long left = Long.parseLong(squareStr.substring(0,(int)Math.ceil(squareStr.length()/2)));
                long right = Long.parseLong(squareStr.substring((int)Math.ceil(squareStr.length()/2), squareStr.length()));
                if(left+right == i)
                {
                    System.out.print(i+" ");
                    flag = true;
                }
            }
        }
        if(!flag)
        {
            System.out.println("INVALID RANGE");
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
