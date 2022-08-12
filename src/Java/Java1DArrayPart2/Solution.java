package Java.Java1DArrayPart2;

import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game, int index) {
        // Return true if you can win the game; otherwise, return false.
        //dieu kien dung
        if (index < 0 || game[index] == 1) {
            return false;
        }

        if (index + 1 >= game.length || index + leap >= game.length) {
            return true;
        }

        game[index] = 1;

        return canWin(leap, game, index + leap)
                || canWin(leap, game, index + 1)
                || canWin(leap, game, index - 1);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            int count_zero = 0;
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
                if (game[i] == 1) count_zero++;
            }
            if (count_zero == 0 && leap > 0) {
                System.out.println("YES");
            } else {
                System.out.println((canWin(leap, game, 0)) ? "YES" : "NO");
            }
        }
        scan.close();
    }
}
