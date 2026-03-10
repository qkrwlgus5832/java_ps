import java.util.HashMap;

public class 로또의최고순위와최저순위 {
    class Solution {
        private int getRank(int x) {
            if (x == 0 || x == 1) {
                return 6;
            }
            if (x == 2) {
                return 5;
            }
            if (x == 3) {
                return 4;
            }
            if (x == 4) {
                return 3;
            }
            if (x == 5) {
                return 2;
            }
            if (x == 6) {
                return 1;
            }
            else {
                return -1;
            }
        }

        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = {};

            HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

            for (int win_num: win_nums) {
                map.put(win_num, true);
            }

            int matchingCount = 0;
            int zeroCount = 0;

            for (int lotto : lottos) {
                if (map.containsKey(lotto)) {
                    matchingCount++;
                }
                else if (lotto == 0) {
                    zeroCount++;
                }
            }

            return new int[] {getRank(matchingCount + zeroCount), getRank(matchingCount)};
        }
    }

    public static void main(String[] args) {
        로또의최고순위와최저순위 outer = new 로또의최고순위와최저순위();
        로또의최고순위와최저순위.Solution solution = outer.new Solution();
        System.out.println(solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));
    }
}
