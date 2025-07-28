import java.util.Arrays;

public class 예산 {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);

            for (int i=0; i <d.length; i++) {
                if (budget - d[i] >= 0) {
                    budget -= d[i];
                    answer++;
                }
                else {
                    break;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        예산 outer = new 예산();
        Solution solution = outer.new Solution();
        solution.solution(new int[]{1,3,2,5,4}, 9);
    }
}
