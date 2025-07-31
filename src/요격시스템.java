import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 요격시스템 {
    class Solution {
        public int solution(int[][] targets) {
            Set<Integer> set = new HashSet<>();

            for (int i=0; i<targets.length; i++) {
                for (int j=targets[i][0]; j<=targets[i][1]; j++) {
                    set.add(j);
                }
            }

            return set.size();
        }
    }

    public static void main(String[] args) {
        요격시스템 outer = new 요격시스템();


    }
}