import java.util.ArrayList;

public class 삼총사 {
    class Solution {

        private int recursion(int[] number, ArrayList<Integer> current, int index, int count) {
            if (count == 3) {
                int sum = 0;
                for (int i=0; i<3; i++) {
                    sum += current.get(i);
                }
                if (sum == 0) {
                   return 1;
                }
                else {
                    return 0;
                }
            }

            int result = 0;

            for (int i=index; i<number.length; i++) {
                current.add(number[i]);
                result += recursion(number, current, i + 1, count + 1);
                current.remove(current.size() - 1);
            }

            return result;
        }

        public int solution(int[] number) {
            int answer = 0;
            return recursion(number, new ArrayList<>(), 0, 0);
        }

    }

    public static void main(String[] args) {
        삼총사 outer = new 삼총사();
        Solution solution = outer.new Solution();
        System.out.println(solution.solution(new int[]{-1, 1, -1, 1}));
    }
}