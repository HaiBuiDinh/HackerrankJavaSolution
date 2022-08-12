package ProblemSolving.Algorithms.CutTheSticks;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        result.add(arr.size());
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                return t0-t1;
            }
        });
        int tempValue = arr.get(0), tempCount = 0, total = arr.size();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == tempValue) tempCount++;
            else {
                result.add(total - tempCount);
                total -= tempCount;
                tempValue = arr.get(i);
                tempCount = 1;
            }
        }
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

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
