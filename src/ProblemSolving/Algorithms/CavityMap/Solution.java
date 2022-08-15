package ProblemSolving.Algorithms.CavityMap;

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
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
        // Write your code here
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Integer currValue = 0, tempValue = 0;
        boolean needChange = false;
        List<List<Character>> result = new ArrayList<>();
        int length = grid.size();
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            String s = grid.get(i);
            List<Integer> tempList = s.chars().map(c -> c -'0').boxed().collect(toList());
            map.add(tempList);
            List<Character> tempChar = s.chars().mapToObj(c -> (char)c).collect(toList());
            result.add(tempChar);
        }
        for (int i = 1; i < length-1; i++) {
            for (int j = 1; j < length - 1 ; j++) {
                currValue = map.get(i).get(j);
                needChange = true;
                for (int k = 0; k < 4; k++) {
                    tempValue = map.get(i+dx[k]).get(j+dy[k]);
                    if (tempValue >= currValue) {
                        needChange = false;
                        break;
                    }
                }
                if (needChange) result.get(i).set(j, 'X');
            }
        }

        for (int i = 0; i < length; i++) {
            grid.set(i, result.get(i).stream().map(String::valueOf).collect(joining()));
        }

        return grid;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

