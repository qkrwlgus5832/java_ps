import java.util.Objects;

public class 공원산책 {
    class Solution {
        class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int[] solution(String[] park, String[] routes) {
            Pair start = new Pair(0, 0);

            for (int i=0; i<park.length; i++) {
                for (int j=0; j<park[i].length(); j++) {
                    if (park[i].charAt(j) == 'S') {
                        start.x = i;
                        start.y = j;
                    }
                }
            }

            int[][] dir = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
            };

            for (String route: routes) {
                String[] splited = route.split(" ");
                int count = Integer.parseInt(splited[1]);

                int dirIndex = -1;

                if (Objects.equals(splited[0], "N")) {
                    dirIndex = 0;
                }
                else if (Objects.equals(splited[0], "S")) {
                    dirIndex = 1;
                }
                else if (Objects.equals(splited[0], "W")) {
                    dirIndex = 2;
                }
                else if (Objects.equals(splited[0], "E")) {
                    dirIndex = 3;
                }

                boolean flag = true;

                for (int i=1; i<=count; i++) {
                    int ni = start.x + dir[dirIndex][0] * i;
                    int nj = start.y + dir[dirIndex][1] * i;

                    if (ni < 0 || nj < 0 || ni >= park.length || nj >= park[0].length() || park[ni].charAt(nj) == 'X') {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    start.x = start.x + dir[dirIndex][0] * count;
                    start.y = start.y + dir[dirIndex][1] * count;
                }
            }

            return new int[]{start.x, start.y};
        }
    }


    public static void main(String[] args) {
        공원산책 outer = new 공원산책();
        Solution solution = outer.new Solution();
        solution.solution(
            new String[]{"OSO", "OOO","OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"}
        );
    }
}
