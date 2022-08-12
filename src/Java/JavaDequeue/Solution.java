package Java.JavaDequeue;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);

            if (deque.size() == m) {
                if (max < set.size()) {
                    max = set.size();
                }

                int first = (int) deque.remove();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }

        System.out.println(max);
        in.close();

    }
}
