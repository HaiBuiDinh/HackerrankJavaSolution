package Java.JavaLoopsII;

import java.util.*;
import java.io.*;
import java.math.*;


class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            for(int j = 0; j< n; j++){
                int result = a;
                for( int jj = 0; jj<= j; jj++) {
                    result = result + (int) (b * Math.pow(2, jj));
                }
                System.out.print(result + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
