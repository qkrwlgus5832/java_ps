import java.util.Objects;

public class 숫자문자열과영단어 {
    class Solution {
        class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        private Pair getOriginNumber(String s) {
            if (s.startsWith("zero")) {
                return new Pair(0, 4);
            }
            if (s.startsWith("one")) {
                return new Pair(1, 3);
            }
            if (s.startsWith("two")) {
                return new Pair(2, 3);
            }
            if (s.startsWith("three")) {
                return new Pair(3, 5);
            }
            if (s.startsWith("four")) {
                return new Pair(4, 4);
            }
            if (s.startsWith("five")) {
                return new Pair(5, 4);
            }
            if (s.startsWith("six")) {
                return new Pair(6, 3);
            }
            if (s.startsWith("seven")) {
                return new Pair(7, 5);
            }
            if (s.startsWith("eight")) {
                return new Pair(8, 5);
            }
            if (s.startsWith("nine")) {
                return new Pair (9, 4);
            }
            return new Pair(-1, -1);
        }

        public int solution(String s) {
            int answer = 0;

            StringBuilder tmp = new StringBuilder();

            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <='9') {
                    if (tmp.length() > 0) {
                        int index = 0;

                        while (index < tmp.length()) {
                            Pair pair = getOriginNumber(tmp.substring(index));
                            answer = answer * 10 + pair.x;
                            index += pair.y;
                        }

                        tmp = new StringBuilder();
                    }
                    answer = answer * 10 + (s.charAt(i) - '0');
                }
                else {
                    tmp.append(s.charAt(i));
                }
            }

            if (tmp.length() > 0) {
                int index = 0;

                while (index < tmp.length()) {
                    Pair pair = getOriginNumber(tmp.substring(index));
                    answer = answer * 10 + pair.x;
                    index += pair.y;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        숫자문자열과영단어 outer = new 숫자문자열과영단어();
        숫자문자열과영단어.Solution solution = outer.new Solution();
        solution.solution("123");
    }
}
