public class 콜라문제 {
    class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;

            int blankCoke = n;

            while (true) {
                if (blankCoke % a == 0) {
                    answer += (blankCoke / a) * b;
                    blankCoke = (blankCoke / a) * b;
                }
                else if (blankCoke > a) {
                    answer += (blankCoke / a ) * b;
                    blankCoke = ((blankCoke / a) * b) + (blankCoke % a);
                }
                else {
                    break;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        콜라문제 outer = new 콜라문제();
        콜라문제.Solution solution = outer.new Solution();
        solution.solution(3, 1, 20);

    }
}
