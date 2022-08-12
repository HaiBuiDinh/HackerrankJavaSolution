package Java.JavaEndOfFile;

import java.io.*;
import java.util.*;

public class Solution {

    private static Scanner in;

    public static void main(String[] argh) {
        in = new Scanner(System.in);
        int count = 0;
        while (in.hasNext()) {
            System.out.println(++count + " " + in.nextLine());
        }
        in.close();
    }

}
