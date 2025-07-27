import static java.lang.Math.abs;

public class 키패드누르기 {
    public class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Solution {
        private char[][] phone = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'},
            {'*', '0', '#'},
        };

        private Pair getCoordi(char x) {
            for (int i=0; i<4; i++) {
                for (int j=0; j<3; j++) {
                    if (phone[i][j] == x) {
                        return new Pair(i,j);
                    }
                }
            }
            return new Pair(-1, -1);
        }


        int getDistance(Pair a, Pair b) {
            return abs(a.first - b.first) + abs(a.second - b.second);
        }

        public String solution(int[] numbers, String hand) {
            StringBuilder answer = new StringBuilder();

            char leftHand = '*';
            char rightHand = '#';

            for (int i=0; i<numbers.length; i++) {
                char x = (char) (numbers[i] + '0');

                if (numbers[i] % 3 == 1) {
                    leftHand = x;
                    answer.append('L');
                }

                else if (numbers[i] % 3 == 2 || numbers[i] == 0) {
                    Pair leftCoordi = getCoordi(leftHand);
                    Pair rightCoordi = getCoordi(rightHand);
                    Pair currentCoordi = getCoordi(x);

                    int leftDistance = getDistance(leftCoordi, currentCoordi);
                    int rightDistance = getDistance(rightCoordi, currentCoordi);

                    if (leftDistance == rightDistance) {
                        if (hand.equals("left")) {
                            leftHand = x;
                            answer.append('L');
                        }
                        else {
                            rightHand = x;
                            answer.append('R');
                        }
                    }
                    else if (leftDistance < rightDistance) {
                        leftHand = x;
                        answer.append('L');
                    }
                    else {
                        rightHand = x;
                        answer.append('R');
                    }

                }

                else if (numbers[i] % 3 == 0) {
                    rightHand = x;
                    answer.append('R');
                }
            }

            return answer.toString();
        }
    }

    public static void main(String[] args) {
        키패드누르기 outer = new 키패드누르기();
        Solution solution = outer.new Solution();

        solution.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
        "left"
        );
    }
}
