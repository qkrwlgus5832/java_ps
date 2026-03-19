import java.util.*;

public class 리틀프렌즈사천성 {
    class Solution {
        class Point {
            int i;
            int j;
            boolean isDirectionChanged = false;
            int direction = -1;

            Point(int i, int j) {
                this.i = i;
                this.j = j;
            }

            Point(int i, int j, boolean isDirectionChanged, int direction) {
                this.i = i;
                this.j = j;
                this.isDirectionChanged = isDirectionChanged;
                this.direction = direction;
            }
        }

        private boolean bfs(char start, Point point, char[][] board) {
            LinkedList<Point> queue = new LinkedList<Point>();

            int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},};

            boolean check[][][] = new boolean[board.length + 1][board[0].length + 1][4];

            queue.add(point);

            while(!queue.isEmpty()) {
                Point front = queue.poll();

                for (int i1=0; i1<4; i1++) {
                    int ni = front.i + dir[i1][0];
                    int nj = front.j + dir[i1][1];

                    boolean isDirectionChanged = front.isDirectionChanged;
                    int direction = front.direction;

                    if (i1 == direction || !isDirectionChanged) {
                        if (ni < 0 || nj < 0 || ni >= board.length || nj >= board[0].length) {
                            continue;
                        }

                        if (board[ni][nj] == start && !(ni == point.i && nj == point.j)) {
                            board[ni][nj] = '.';
                            board[point.i][point.j] = '.';
                            return true;
                        }

                        if (board[ni][nj] != '.') {
                            continue;
                        }

                        if (i1 == direction && !check[ni][nj][i1]) {
                            check[ni][nj][i1] = true;
                            queue.add(new Point(ni, nj, isDirectionChanged, i1));
                        }

                        else if (isDirectionChanged == false && !check[ni][nj][i1]) {
                            check[ni][nj][i1] = true;
                            queue.add(new Point(ni, nj, direction != -1, i1));
                        }
                    }
                }
            }
            return false;
        }

        public String solution(int m, int n, String[] board) {
            StringBuilder answer = new StringBuilder();

            TreeMap<Character, Point> map = new TreeMap<>();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length(); j++) {
                    char current = board[i].charAt(j);
                    if (current >= 'A' && current <= 'Z' && !map.containsKey(current)) {
                        map.put(current, new Point(i, j));
                    }
                }
            }

            boolean check[] = new boolean[26];

            char[][] boardArray = new char[board.length][];

            for (int i=0; i< board.length; i++) {
                boardArray[i] = board[i].toCharArray();
            }

            for (int i = 0; i < map.size(); i++) {
                boolean flag = false;

                for (Map.Entry<Character, Point> entry : map.entrySet()) {
                    if (bfs(entry.getKey(), entry.getValue(), boardArray) && !check[entry.getKey() - 'A']) {
                        flag = true;
                        check[entry.getKey() - 'A'] = true;
                        answer.append(entry.getKey());
                        break;
                    }
                }

                if (!flag) {
                    return "IMPOSSIBLE";
                }
            }
            return answer.toString();
        }
    }

    public static void main(String[] args) {
        리틀프렌즈사천성 outer = new 리틀프렌즈사천성();
        리틀프렌즈사천성.Solution solution = outer.new Solution();
        System.out.println(solution.solution(4, 4, new String[]{
                "M...M...DU", "....AR...R", "...E..OH.H", ".....O....", ".E..A..Q..", "Q....LL.*.", ".D.N.....U", "GT.T...F..", "....FKS...", "GN....K..S"
        }));
    }
}
