package OneWeekPreparationKit.Day4.GridChallenge;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        String tempString;
        int n = grid.get(0).length();
        List<Character> tempArr;
        for (int i = 0; i < grid.size(); i++) {
            tempString = grid.get(i);
            tempArr = tempString.chars().mapToObj(c -> (char) c).collect(toList());
            tempArr.sort(Comparator.comparingInt(t0 -> t0));
            grid.set(i, tempArr.stream().map(Object::toString).reduce((acc, e) -> acc + e).get());
        }
        char tempCompare;
        for (int i = 0; i < n; i++) {
            tempCompare = grid.get(0).charAt(i);
            for (int j = 1; j < grid.size(); j++) {
                if (grid.get(j).charAt(i) < tempCompare) return "NO";
                else tempCompare = grid.get(j).charAt(i);
            }
        }
        return "YES";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
