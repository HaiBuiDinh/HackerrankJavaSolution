package Java.JavaArraylist;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int number_of_line = scanner.nextInt();
        ArrayList<ArrayList> listArray = new ArrayList<>();
        for (int i = 0; i < number_of_line; i++) {
            int number_of_Integer = scanner.nextInt();
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            for (int j = 0; j < number_of_Integer; j++) {
                integerArrayList.add(new Integer(scanner.nextInt()));
            }
            listArray.add(integerArrayList);
            scanner.nextLine();
        }

        int number_of_query = scanner.nextInt();
        for (int i = 0; i < number_of_query; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (x < listArray.size() && y < listArray.get(x).size()) {
                System.out.println(listArray.get(x).get(y));
            } else {
                System.out.println("ERROR!");
            }
        }
        scanner.close();
    }
}
