import java.util.Arrays;
import java.util.PriorityQueue;

public class 단어퍼즐 {
    class Solution {
        class Node implements Comparable<Node> {
            int count;
            int index;

            Node(int count, int index) {
                this.count = count;
                this.index = index;
            }

            @Override
            public int compareTo(Node o) {
                if (this.count == o.count) {
                    return Integer.compare(o.index, this.index);
                }
                return Integer.compare(this.count, o.count);
            }
        }
        private int bfs(String[] strs, String t) {
            PriorityQueue<Node> queue = new PriorityQueue<Node>();
            queue.add(new Node(0, 0));

            int dp[] = new int[t.length() + 1];

            Arrays.fill(dp, -1);

            while(!queue.isEmpty()) {
                Node front = queue.poll();

                if (front.index == t.length()) {
                    return front.count;
                }
                for (int i=0; i<strs.length; i++) {
                    boolean flag = true;

                    for (int j=0; j<strs[i].length(); j++) {
                        if (front.index + j >= t.length() || strs[i].charAt(j) != t.charAt(front.index + j)) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        if (dp[front.index + strs[i].length()] == -1 || dp[front.index + strs[i].length()] > front.count + 1) {
                            dp[front.index + strs[i].length()] = front.count + 1;
                            queue.add(new Node(front.count + 1, front.index + strs[i].length()));
                        }
                    }
                }
            }
            return -1;
        }

        public int solution(String[] strs, String t) {
            return bfs(strs, t);
        }
    }

    public static void main(String[] args) {
        단어퍼즐 outer = new 단어퍼즐();
        단어퍼즐.Solution solution = outer.new Solution();
        System.out.println(solution.solution(new String[]{"ba","an","nan","ban","n"}, "banana"));
    }
}
