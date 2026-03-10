import java.util.Arrays;
import java.util.TreeSet;
import static java.lang.Math.*;

class 캠핑 {
    class Solution {
        private boolean isAnswer(int[] before, int[] after) {
            if (before[0] == after[0] || before[1] == after[1]) {
                return false;
            }

            return true;
        }

        public int solution(int n, int[][] data) {
            int answer = 0;

            Arrays.sort(data, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }

                return Integer.compare(a[0], b[0]);
            });


            for (int i = 0; i < data.length; i++) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                int k = i + 1;

                for (int j = i + 1; j < data.length; j++) {
                    while (true) {
                        if (data[k][0] < data[j][0]) {
                            if (data[i][0] < data[k][0]) {
                                set.add(data[k][1]);
                            }
                            k++;
                        }
                        else {
                            break;
                        }
                    }
                    if (isAnswer(data[i], data[j])) {
                        Integer celling = set.ceiling(min(data[i][1], data[j][1]) + 1);

                        if (celling == null || celling >= max(data[i][1], data[j][1])) {
                            answer++;
                        }
                    }
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        캠핑 outer = new 캠핑();
        캠핑.Solution solution = outer.new Solution();
        solution.solution(4, new int[][]{{0, 0}, {1, 1}, {0, 2}, {2, 0}});
    }
}
