package Java.JavaBitSet;

import java.util.*;

public class Solution {
    public static void printOut(BitSet a, BitSet b) {
        System.out.println(a.cardinality() + " " + b.cardinality());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BitSet B1 = new BitSet(n);
        BitSet B2 = new BitSet(n);

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            in.hasNext();
            String query = in.next();
            int a = in.nextInt();
            int b = in.nextInt();

            switch (query) {
                case "AND":
                    if (a == 1 && b == 2) {
                        B1.and(B2);
                    } else if (a == 2 && b == 1) {
                        B2.and(B1);
                    }
                    printOut(B1, B2);
                    break;
                case "OR":
                    if (a == 1 && b == 2) {
                        B1.or(B2);
                    } else if (a == 2 && b == 1) {
                        B2.or(B1);
                    }
                    printOut(B1, B2);
                    break;
                case "XOR":
                    if (a == 1 && b == 2) {
                        B1.xor(B2);
                    } else if (a == 2 && b == 1) {
                        B2.xor(B1);
                    }
                    printOut(B1, B2);
                    break;
                case "FLIP":
                    if (a == 1) {
                        B1.flip(b);
                    } else if (a == 2) {
                        B2.flip(b);
                    }
                    printOut(B1, B2);
                    break;
                case "SET":
                    if (a == 1) {
                        B1.set(b);
                    } else if (a == 2) {
                        B2.set(b);
                    }
                    printOut(B1, B2);
                    break;
            }
        }

    }
}



