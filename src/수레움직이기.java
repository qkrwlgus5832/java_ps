import java.util.LinkedList;
import java.util.Queue;

public class 수레움직이기 {
    class Node {
        int redLocation;
        int blueLocation;
        int redVisited;
        int blueVisited;

        int count;

        public Node(int redLocation, int blueLocation, int redVisited, int blueVisited, int count) {
            this.redLocation = redLocation;
            this.blueLocation = blueLocation;
            this.redVisited = redVisited;
            this.blueVisited = blueVisited;
            this.count = count;
        }

        public void setRedLocation(int redLocation) {
            this.redLocation = redLocation;
        }

        public void setBlueLocation(int blueLocation) {
            this.blueLocation = blueLocation;
        }

        public void setRedVisited(int redVisited) { this.redVisited = redVisited;}

        public void setBlueVisited(int blueVisited) { this.blueVisited = blueVisited; }
    }

    class Solution {
        private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private boolean[][] check = new boolean[16][16];

        private boolean fallingCheck(int x, int y, int mazeSize, int mazeYSize, int[][] maze) {
            if (x < 0 || y < 0 || x >= mazeSize || y >= mazeYSize) {
                return false;
            }

            if (maze[x][y] == 5) {
                return false;
            }

            return true;
        }

        private boolean isVisitedCheck(int x, int y, int mazeYSize, int visitied) {
            int location = x * mazeYSize + y;

            if ((visitied & (1 << location)) != 0) {
                return true;
            }

            return false;
        }

        private int addVisit(int x, int y, int mazeYSize, int visitied) {
            int location = x * mazeYSize + y;

            return visitied | (1 << location);
        }

        private int bfs(int[][] maze, Node node) {
            LinkedList<Node> queue = new LinkedList<>();

            queue.add(node);

            check[node.redLocation][node.blueLocation] = true;

            while(!queue.isEmpty()) {
                Node front = queue.poll();

                int frontRedX = front.redLocation / maze[0].length;
                int frontRedY = front.redLocation % maze[0].length;
                int frontBlueX = front.blueLocation / maze[0].length;
                int frontBlueY = front.blueLocation % maze[0].length;
                int frontCount = front.count;

                if (maze[frontRedX][frontRedY] == 3 && maze[frontBlueX][frontBlueY] == 4)  {
                    return frontCount;
                }

                for (int i=0; i<4; i++) {
                    for (int j=0; j<4; j++) {
                        int nFrontRedX = frontRedX + dir[i][0];
                        int nFrontRedY = frontRedY + dir[i][1];
                        int nFrontRedLocation = nFrontRedX * maze[0].length + nFrontRedY;
                        int nFrontBlueX = frontBlueX + dir[j][0];
                        int nFrontBlueY = frontBlueY + dir[j][1];
                        int nFrontBlueLocation = nFrontBlueX * maze[0].length + nFrontBlueY;

                        if (maze[frontRedX][frontRedY] == 3) {
                            nFrontRedX = frontRedX;
                            nFrontRedY = frontRedY;
                            nFrontRedLocation = front.redLocation;
                        }

                        if (maze[frontBlueX][frontBlueY] == 4) {
                            nFrontBlueX = frontBlueX;
                            nFrontBlueY = frontBlueY;
                            nFrontBlueLocation = front.blueLocation;
                        }

                        if (!this.fallingCheck(nFrontRedX, nFrontRedY, maze.length, maze[0].length, maze)) {
                            continue;
                        }

                        if (!this.fallingCheck(nFrontBlueX, nFrontBlueY, maze.length, maze[0].length, maze)) {
                            continue;
                        }

                        if (nFrontRedX == nFrontBlueX && nFrontRedY == nFrontBlueY) {
                            continue;
                        }

                        if (maze[nFrontRedX][nFrontRedY] != 3 && isVisitedCheck(nFrontRedX, nFrontRedY, maze[0].length, front.redVisited)) {
                            continue;
                        }

                        if (maze[nFrontBlueX][nFrontBlueY] != 4 && isVisitedCheck(nFrontBlueX, nFrontBlueY, maze[0].length, front.blueVisited)) {
                            continue;
                        }

                        if (nFrontRedX == frontBlueX && nFrontRedY == frontBlueY && nFrontBlueX == frontRedX && nFrontBlueY == frontRedY) {
                            continue;
                        }

                        if (check[nFrontRedLocation][nFrontBlueLocation]) {
                            continue;
                        }

                        check[nFrontRedLocation][nFrontBlueLocation] = true;

                        int nRedVisitied = addVisit(nFrontRedX, nFrontRedY, maze[0].length, front.redVisited);
                        int nBlueVisitied = addVisit(nFrontBlueX, nFrontBlueY, maze[0].length, front.blueVisited);

                        queue.add(new Node(nFrontRedLocation, nFrontBlueLocation, nRedVisitied, nBlueVisitied, frontCount + 1));
                    }
                }
            }
            return 0;
        }
        public int solution(int[][] maze) {
            Node node = new Node(0, 0, 0, 0, 0);

            for (int i=0; i<maze.length; i++) {
                for (int j=0; j<maze[i].length; j++) {
                    if (maze[i][j] == 1) {
                        node.setRedLocation(i * maze[i].length + j);
                        node.setRedVisited(1 << (i * maze[i].length + j));
                    }
                    else if (maze[i][j] == 2) {
                        node.setBlueLocation(i * maze[i].length + j);
                        node.setBlueVisited(1 << (i * maze[i].length + j));
                    }
                }
            }

            return bfs(maze, node);
        }
    }

    public static void main(String[] args) {
        수레움직이기 outer = new 수레움직이기();
        수레움직이기.Solution solution = outer.new Solution();
        solution.solution(new int[][]{{1, 5}, {2, 5}, {4, 5}, {3, 5}});
    }
}
