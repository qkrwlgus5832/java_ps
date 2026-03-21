import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 튜브의소개팅 {
    class Solution {
        class Node implements Comparable<Node> {
            int length;

            int i;

            int j;

            long timeSum;

            Node(int i, int j, int length, long timeSum) {
                this.i = i;
                this.j = j;
                this.length = length;
                this.timeSum = timeSum;
            }

            @Override
            public int compareTo(Node o) {
                if (this.length == o.length) {
                    return Long.compare(this.timeSum, o.timeSum);
                }
                return Integer.compare(this.length, o.length);
            }
        }

        private int[][] dir = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
        };

        private Node bfs(int m, int n, int s, int[][] time_map) {
            int[][] dp = new int[time_map.length][time_map[0].length];

            PriorityQueue<Node> queue = new PriorityQueue<Node>();
            queue.add(new Node(0, 0, 0, 0));

            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], -1);
            }

            dp[0][0] = 0;

            ArrayList<Node> result = new ArrayList<Node>();

            while (!queue.isEmpty()) {
                Node front = queue.poll();

                if (front.i == m - 1 && front.j == n - 1) {
                    result.add(front);
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int ni = front.i + dir[i][0];
                    int nj = front.j + dir[i][1];

                    if (ni < 0 || nj < 0 || ni >= time_map.length || nj >= time_map[0].length || time_map[ni][nj] == -1) {
                        continue;
                    }

                    if (dp[ni][nj] != -1 && dp[ni][nj] <= front.timeSum + time_map[ni][nj]) {
                        continue;
                    }

                    if (front.timeSum + time_map[ni][nj] > s) {
                        continue;
                    }

                    dp[ni][nj] = (int) (front.timeSum + time_map[ni][nj]);
                    queue.add(new Node(ni, nj, front.length + 1, front.timeSum + time_map[ni][nj]));
                }
            }

            result.sort((a, b) -> {
                if (a.length == b.length) {
                    return Long.compare(a.timeSum, b.timeSum);
                }

                return Integer.compare(a.length, b.length);
            });
            return result.get(0);
        }

        public int[] solution(int m, int n, int s, int[][] time_map) {
            Node node = bfs(m, n, s, time_map);
            return new int[]{node.length, (int) node.timeSum};
        }
    }

    public static void main(String[] args) {
        튜브의소개팅 outer = new 튜브의소개팅();
        튜브의소개팅.Solution solution = outer.new Solution();
        System.out.println(solution.solution(3, 3, 150, new int[][] {
                {0, 2, 99},
                {100, 100, 4},
                {1, 2, 0}
        }));
    }
}
