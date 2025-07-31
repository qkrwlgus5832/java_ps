import java.util.*;
import static java.lang.Math.max;

public class 석유시추 {
    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Solution {
        private int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
        };

        void BFS(int x, int y, int[][] land, boolean[][] check, int index, Map<Integer, Integer> map) {
            Queue<Pair> queue = new LinkedList<>();
            check[x][y] = true;
            queue.add(new Pair(x,y));
            int count = 1;
            land[x][y] = index;

            while(!queue.isEmpty()) {
                Pair front = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int newX = front.x + dir[i][0];
                    int newY = front.y + dir[i][1];

                    if (newX < 0 || newY < 0 || newX >= land.length || newY >= land[0].length) {
                        continue;
                    }

                    if (!check[newX][newY] && land[newX][newY] >= 1) {
                        check[newX][newY] = true;
                        queue.add(new Pair(newX, newY));
                        count++;
                        land[newX][newY] = index;
                    }
                }

            }

            map.put(index, count);
        }

        public int solution(int[][] land) {
            boolean[][] check = new boolean[501][501];

            int index = 2;

            Map<Integer, Integer> countMap = new HashMap<>();

            for (int i=0; i<land.length; i++) {
                for (int j=0; j<land[i].length; j++) {
                    if (land[i][j] == 1 && !check[i][j]) {
                        BFS(i, j, land, check, index, countMap);
                        index++;
                    }
                }
            }

            int result = 0;

            for (int j=0; j<land[0].length; j++) {
                int sum = 0;
                Map<Integer, Boolean> map = new HashMap<>();

                for (int i=0; i<land.length; i++) {
                    if (land[i][j] >= 2 && !map.containsKey(land[i][j])) {
                        sum += countMap.get(land[i][j]);
                        map.put(land[i][j], true);
                    }
                }

                result = max(result, sum);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        석유시추 outer = new 석유시추();
        Solution solution = outer.new Solution();

        solution.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
    }
}
