import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.min;

public class 지형편집 {
    class Pair {
        int height;
        int count;

        Pair(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public class Solution {
        public long solution(int[][] land, int P, int Q) {
            long answer = -1;

            ArrayList<Integer> landList = new ArrayList<Integer>();

            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[i].length; j++) {
                    landList.add(land[i][j]);
                }
            }

            Collections.sort(landList);

            ArrayList<Pair> map = new ArrayList<Pair>();

            int count = 0;

            for (int i=0; i < landList.size(); i++) {
                if (i > 0 && landList.get(i) > landList.get(i-1)) {
                    map.add(new Pair(landList.get(i-1), count));
                    count = 1;
                }
                else {
                    count++;
                }

                if (i == landList.size() - 1) {
                    map.add(new Pair(landList.get(i), count));
                }
            }

            long leftCountSum = 0;
            long rightCountSum = 0;

            long leftSum = 0;
            long rightSum = 0;

            boolean isFirst = false;
            int first = -1;

            for (Pair current : map) {
                if (isFirst == false) {
                    first = current.height;
                    isFirst = true;
                    continue;
                }

                rightCountSum += current.count;
                rightSum += (long) current.count * (current.height - first) * Q;
            }

            answer = leftSum + rightSum;

            Pair before = map.get(0);

            for (Pair current : map) {
                if (current.height == first) {
                    continue;
                }

                int gap = current.height - before.height;
                leftCountSum += before.count;

                leftSum += gap * leftCountSum * P;
                rightSum -= gap * rightCountSum * Q;

                rightCountSum -= current.count;

                answer = min(answer, leftSum + rightSum);

                before = current;
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        지형편집 outer = new 지형편집();
        지형편집.Solution solution = outer.new Solution();
        System.out.println(solution.solution(new int[][]{{1, 2}, { 2, 3 }}, 3, 2));
    }
}
