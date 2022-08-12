package ProblemSolving.Algorithms.ClimbingTheLeaderboard;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        List<Integer> newRanked;
        int tempScout;
        newRanked = ranked.stream().distinct().collect(toList());

        int currIndex = newRanked.size() - 1;

        for (int i = 0; i < player.size(); i++) {
            tempScout = player.get(i);
            for (int j = currIndex; j >= 0; j--) {
                if (tempScout == newRanked.get(j)) {
                    result.add(j + 1);
                    currIndex = j;
                    break;
                } else if (tempScout < newRanked.get(j)) {
                    newRanked.add(j+1, tempScout);
                    currIndex = j + 1;
                    result.add(j + 2);
                    break;
                } else {
                    if (j == 0) {
                        newRanked.add(j, tempScout);
                        currIndex = j;
                        result.add(1);
                    }
                }
            }
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
