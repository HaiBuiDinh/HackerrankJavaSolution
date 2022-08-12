package QueensAttackII;

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
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int tempR, tempC, result = 0;
        int rR = -1, rL = -1, rT = -1, rB = -1, rTR = -1, rTL = -1, rBR = -1, rBL = -1;
        int cR = -1, cL = -1, cT = -1, cB = -1, cTR = -1, cTL = -1, cBR = -1, cBL = -1;
        for (int i = 0; i < k; i++) {
            tempR = obstacles.get(i).get(0);
            tempC = obstacles.get(i).get(1);

            /* Right */
            if ((tempC < cR || cR == -1) && tempC > c_q && tempR == r_q) {
                cR = tempC;
                rR = tempR;
            }
            /* Left */
            if ((tempC > cL || rL == -1) && tempC < c_q && tempR == r_q) {
                cL = tempC;
                rL = tempR;
            }
            /* Top */
            if ((tempR < rT || rT == -1) && tempC == c_q && tempR > r_q) {
                cT = tempC;
                rT = tempR;
            }
            /* Bottom */
            if ((tempR > rB || rB == -1) && tempC == c_q && tempR < r_q) {
                cB = tempC;
                rB = tempR;
            }
            /* Top Right */
            if (tempR - r_q == tempC - c_q && tempC > c_q && tempR > r_q && (tempR < rTR && tempC < cTR || rTR == -1)) {
                cTR = tempC;
                rTR = tempR;
            }
            /* Top Left */
            if (tempR - r_q == c_q - tempC && tempC < c_q && tempR > r_q && (tempR < rTL && tempC > cTL || rTL == -1)) {
                cTL = tempC;
                rTL = tempR;
            }
            /* Bottom Right */
            if (r_q - tempR == tempC - c_q && tempR < r_q && tempC > c_q && (tempR > rBR && tempC < cBR || rBR == -1)) {
                cBR = tempC;
                rBR = tempR;
            }
            /* Bottom Left */
            if (r_q - tempR == c_q - tempC && tempR < r_q && tempC < c_q && (tempR > rBL && tempC > cBL || rBL == -1)) {
                cBL = tempC;
                rBL = tempR;
            }
        }
        //Calculate result
        /* Right */
        result += (cR != -1) ? (cR - c_q - 1) : n - c_q;
        /* Left */
        result += (cL != -1) ? (c_q - cL - 1) : c_q - 1;
        /* Top */
        result += (rT != -1) ? (rT - r_q - 1) : n - r_q;
        /* Bottom */
        result += (rB != -1) ? (r_q - rB - 1) : r_q - 1;
        /* Top Right */
        result += (rTR != -1) ? (cTR - c_q - 1) : Math.min(n - c_q, n - r_q);
        /* Top Left */
        result += (cTL != -1) ? (c_q - cTL - 1) : Math.min(c_q - 1, n - r_q);
        /* Bottom Right */
        result += (cBR != -1) ? (cBR - c_q - 1) : Math.min(n - c_q, r_q - 1);
        /* Bottom Left */
        result += (rBL != -1) ? (c_q - cBL - 1) : Math.min(c_q - 1, r_q - 1);

        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
