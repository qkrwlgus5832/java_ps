import static java.lang.Math.min;

public class 완전범죄 {
    class Solution {
        private boolean[][][] check = new boolean[41][121][121];

        private int answer = Integer.MAX_VALUE;

        void dfs(int[][] info, int index, int n, int m, int aSum, int bSum) {
            if (aSum >= n || bSum >= m) {
                return;
            }

            if (index == info.length) {
                answer = min(answer, aSum);
                return;
            }

            if (aSum + info[index][0] < n && !check[index][aSum + info[index][0]][bSum]) {
                check[index][aSum + info[index][0]][bSum] = true;
                dfs(info, index + 1, n, m, aSum + info[index][0], bSum);
            }

            if (bSum + info[index][1] < m && !check[index][aSum][bSum + info[index][1]]) {
                check[index][aSum][bSum + info[index][1]] = true;
                dfs(info, index + 1, n, m, aSum, bSum + info[index][1]);
            }
        }

        public int solution(int[][] info, int n, int m) {
            dfs(info, 0, n, m, 0, 0);

            if (this.answer == Integer.MAX_VALUE) {
                return -1;
            }
            return this.answer;
        }
    }

    public static void main(String[] args) {
        완전범죄 outer = new 완전범죄();
        완전범죄.Solution solution = outer.new Solution();

        solution.solution(new int[][]{{3, 3}, {3,3}}, 6, 1);
    }
}
