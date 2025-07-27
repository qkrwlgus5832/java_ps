public class 카드뭉치 {
    static class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "";

            int card1Index = 0;
            int card2Index = 0;

            int goalIndex = 0;

            while(true) {
                if (goalIndex == goal.length) {
                    break;
                }

                if (card1Index < cards1.length && card2Index < cards2.length && !cards1[card1Index].equals(goal[goalIndex]) && !cards2[card2Index].equals(goal[goalIndex])) {
                    return "No";
                }
                else if (card1Index < cards1.length && cards1[card1Index].equals(goal[goalIndex])) {
                    card1Index++;
                    goalIndex++;
                }
                else if (card2Index < cards2.length && cards2[card2Index].equals(goal[goalIndex])) {
                    card2Index++;
                    goalIndex++;
                }
                else {
                    return "No";
                }
            }
            return "Yes";
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
            new String[] {"i", "water", "drink"},
            new String[] {"want", "to"},
            new String[] {"i", "want", "to", "drink", "water"}
        ));
    }
}