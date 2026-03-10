import java.util.Arrays;

public class 체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            boolean[] lostCheck = new boolean[n + 1];
            boolean[] reserveCheck = new boolean[n + 1];

            for (int i =0; i<lost.length; i++) {
                lostCheck[lost[i]] = true;
            }

            Arrays.sort(reserve);

            for (int i=0; i<reserve.length; i++) {
                if (lostCheck[reserve[i]]) {
                    lostCheck[reserve[i]] = false;
                    reserveCheck[i] = true;
                }
            }

            for (int i=0; i<reserve.length; i++) {
                if (reserveCheck[i]) {
                    continue;
                }

                if (reserve[i] - 1 >= 1 && lostCheck[reserve[i] - 1]) {
                    lostCheck[reserve[i] - 1] = false;
                }
                else if (reserve[i] + 1 <= n && lostCheck[reserve[i] + 1]) {
                    lostCheck[reserve[i] + 1] = false;
                }

            }


            for (int i=1; i<=n; i++) {
                if (!lostCheck[i]) {
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        체육복 outer = new 체육복();
        체육복.Solution solution = outer.new Solution();
        solution.solution(3, new int[]{3}, new int[]{1});
    }
}
