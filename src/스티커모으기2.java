import static java.lang.Math.max;

public class 스티커모으기2 {
    class Solution {
        private void recursion(int sticker[], int index, boolean isFirstUsed, int dp[][]) {
            if (index == sticker.length - 1) {
                if (isFirstUsed) {
                    dp[index][0] = max(dp[index-1][0], dp[index-1][1]);
                }
                else {
                    dp[index][1] = dp[index - 1][0] + sticker[index];
                }
                return;
            }

            dp[index][1] = dp[index - 1][0] + sticker[index];
            dp[index][0] = max(dp[index-1][0] , dp[index-1][1]);

            recursion(sticker, index + 1, isFirstUsed, dp);
        }
        public int solution(int sticker[]) {
            if (sticker.length == 1) {
                return sticker[0];
            }

            int[][] dp = new int[sticker.length][2];
            dp[0][1] = sticker[0];

            int[][] dp2 = new int[sticker.length][2];
            dp2[0][0] = 0;

            recursion(sticker, 1, true, dp);
            recursion(sticker, 1, false, dp2);

            return max(dp2[sticker.length -1][1], dp[sticker.length - 1][0]);
        }
    }

    public static void main(String[] args) {
        스티커모으기2 outer = new 스티커모으기2();
        스티커모으기2.Solution solution = outer.new Solution();
        solution.solution(new int[]{1, 2});
    }
}
