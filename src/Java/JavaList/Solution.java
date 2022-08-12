package Java.JavaList;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int numberOfQuery = scanner.nextInt();
        for (int i = 0; i < numberOfQuery; i++) {
            scanner.nextLine();
            String task = scanner.nextLine();
            if (task.equals("Insert")) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                list.add(index, value);
            }
            if (task.equals("Delete")) {
                int indexDelete = scanner.nextInt();
                list.remove(indexDelete);
            }
        }

        scanner.close();
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
