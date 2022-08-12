package Java.JavaBigInteger;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        BigInteger a1 = new BigInteger(a);
        BigInteger b1 = new BigInteger(b);
        System.out.println(a1.add(b1));
        System.out.println(a1.multiply(b1));
        scanner.close();
    }
}
