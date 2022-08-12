package ACMICPCTeam;

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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        int length = topic.size();
        int max = Integer.MIN_VALUE, count = 0, countMax = 0;
        List<Integer> result = new ArrayList<>();
        String temp, temp2;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length ; j++) {
                temp = topic.get(i);
                temp2 = topic.get(j);
                count = 0;
                for (int k = 0; k < temp.length(); k++) {
                    if (temp.charAt(k) == '1' || temp2.charAt(k) == '1') count++;
                }
                if (max < count) {
                    max = count;
                    countMax = 1;
                } else if (max == count) countMax++;
            }
        }
        result.add(max);
        result.add(countMax);
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

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
