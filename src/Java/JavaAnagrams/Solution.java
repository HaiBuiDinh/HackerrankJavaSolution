package Java.JavaAnagrams;

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        } else {
            char[] ArrA = a.toLowerCase().toCharArray();
            char[] ArrB = b.toLowerCase().toCharArray();
            for (int i = 0; i < a.length() - 1; i++) {
                for (int j = i + 1; j < a.length(); j++) {
                    if (ArrA[i] < ArrA[j]) {
                        char temp = ArrA[i];
                        ArrA[i] = ArrA[j];
                        ArrA[j] = temp;
                    }

                    if (ArrB[i] < ArrB[j]) {
                        char temp1 = ArrB[i];
                        ArrB[i] = ArrB[j];
                        ArrB[j] = temp1;
                    }
                }
            }

            for (int i = 0; i < ArrA.length; i++) {
                if (ArrA[i] != ArrB[i])
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}