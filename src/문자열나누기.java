public class 문자열나누기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            Character x = null;
            int xCount = 0;
            int xOtherCount = 0;

            for (int i=0; i<s.length(); i++) {
                if (x == null) {
                    x = s.charAt(i);
                    xCount = 1;
                }
                else {
                    if (s.charAt(i) == x) {
                        xCount++;
                    }
                    else {
                        xOtherCount++;
                    }
                }

                if (xCount == xOtherCount) {
                    answer++;
                    x = null;
                    xCount = 0;
                    xOtherCount = 0;
                }
            }

            if (x != null) {
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        문자열나누기 outer = new 문자열나누기();
        Solution solution = outer.new Solution();
        solution.solution("aaabbaccccabba");
    }
}
