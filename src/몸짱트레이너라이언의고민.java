import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class 몸짱트레이너라이언의고민 {
    class Solution {
        class Point {
            int x;
            int y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Point)) return false;

                Point p = (Point) o;
                return x == p.x && y == p.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        private boolean isAnswer(int maxCount, int n, int k) {
            for (int start =0; start< n*n; start++) {
                ArrayList<Point> chosenList = new ArrayList<Point>();
                int startI = start / n;
                int startJ = start % n;

                chosenList.add(new Point(startI, startJ));

                for (int next=start+1; next<n*n; next++) {
                    int nextI = next / n;
                    int nextJ = next % n;

                    boolean flag = true;
                    for (Point chosen: chosenList) {
                        if (abs(chosen.x - nextI) + abs(chosen.y - nextJ) < k) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        chosenList.add(new Point(nextI, nextJ));
                    }
                }

                if (chosenList.size() >= maxCount) {
                    return true;
                }
            }
            return false;
        }

        private int binarySearch(int maxCount, int n, int startK, int endK) {
            if (startK == endK) {
                return startK;
            }

            if (startK + 1 == endK) {
                if (isAnswer(maxCount, n, endK)) {
                    return endK;
                }
                return startK;
            }

            if (isAnswer(maxCount, n, (startK + endK) / 2)) {
                return binarySearch(maxCount, n, (startK + endK) / 2, endK);
            }

            return binarySearch(maxCount, n, startK, (startK + endK) / 2 - 1);
        }

        public int solution(int n, int m, int[][] timetable) {
            Arrays.sort(timetable, Comparator.comparingInt(a -> a[0]));

            int[] countTimeTable = new int[1321];

            int maxCount = 0;

            for (int i=0; i<timetable.length; i++) {
                for (int j=timetable[i][0]; j<=timetable[i][1]; j++) {
                    countTimeTable[j]++;
                }
            }

            for (int i=600; i<=1320; i++) {
                maxCount = max(countTimeTable[i], maxCount);
            }

            if (maxCount == 0 || maxCount == 1) {
                return 0;
            }

            return binarySearch(maxCount, n, 1, 20);
        }
    }

    public static void main(String[] args) {
        몸짱트레이너라이언의고민 outer = new 몸짱트레이너라이언의고민();
        몸짱트레이너라이언의고민.Solution solution = outer.new Solution();
        System.out.println(solution.solution(2, 2, new int[][]{{600, 630}, {630, 700}}));
    }
}
