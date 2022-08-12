package Java.JavaSubarray;

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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int count_out = 0;

        for (int i = 1; i <= n; i++) {//độ lớn
            for (int j = 0; j < n; j++) { //máy chạy
                int sum_temp = 0;
                for (int k = j; k < i; k++) { //tính tổng thêm combo xét điều kiện
                    sum_temp += arr[k];
                }
                if (sum_temp < 0) count_out++;
            }
        }

        System.out.println(count_out);
    }
}
