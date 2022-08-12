package Java.JavaBigDecimal;

import java.math.BigDecimal;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        Comparator<String> stringComparator = (s1, t1) -> {
            BigDecimal a = new BigDecimal(s1);
            BigDecimal b = new BigDecimal(t1);
            return b.compareTo(a);
        };

        Arrays.sort(s, 0, n, stringComparator);

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}