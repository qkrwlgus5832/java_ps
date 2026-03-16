import java.util.LinkedList;

import static java.lang.Math.min;

public class GPS {
    class Solution {
        public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
            boolean graph[][] = new boolean[201][201];

            for (int i = 0; i < edge_list.length; i++) {
                graph[edge_list[i][0]][edge_list[i][1]] = true;
                graph[edge_list[i][1]][edge_list[i][0]] = true;
            }


            int maxValue = 100000;

            int dp[][] = new int[201][201];

            for (int i=0; i<k; i++) {
                for (int j=1; j<=n; j++) {
                    dp[i][j] = maxValue;
                }
            }

            dp[0][gps_log[0]] = 0;

            for (int t=1; t<gps_log.length; t++) {
                for (int previous=1; previous <=n; previous++) {
                    for (int next=1; next<=n; next++) {
                        if (next == gps_log[t]) {
                            if (graph[previous][next] && dp[t - 1][previous] != maxValue) {
                                dp[t][next] = min(dp[t][next], dp[t - 1][previous]);
                            } else if (previous == next && dp[t - 1][previous] != maxValue) {
                                dp[t][next] = min(dp[t][next], dp[t - 1][previous]);
                            }
                        } else {
                            if (graph[previous][next] && dp[t - 1][previous] != maxValue) {
                                dp[t][next] = min(dp[t][next], dp[t - 1][previous] + 1);
                            } else if (previous == next && dp[t - 1][previous] != maxValue) {
                                dp[t][next] = min(dp[t][next], dp[t - 1][previous] + 1);
                            }                        }
                    }
                }
            }

            if (dp[gps_log.length -1][gps_log[gps_log.length - 1]] == maxValue) {
                return -1;
            }
            return dp[gps_log.length-1][gps_log[gps_log.length -1]];
        }
    }

    public static void main(String[] args) {
        GPS outer = new GPS();
        GPS.Solution solution = outer.new Solution();
        System.out.println(solution.solution(8, 10,
                new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}},
                6, new int[]{1, 2, 3, 3, 6, 7}));
    }
}
