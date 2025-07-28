import java.util.HashMap;
import java.util.Map;
import static java.lang.Math.*;

public class 숫자짝꿍 {
    class Solution {
        private void setMap(String input, Map<Integer, Integer> map) {
            for (int i=0; i<input.length(); i++) {
                int xNumber = (int) (input.charAt(i) -'0');
                int count = map.getOrDefault(xNumber, 0);
                map.put(xNumber, count + 1);
            }
        }

        private int getZeroCount(Map<Integer, Integer> xMap, Map<Integer, Integer> yMap) {
            return min(xMap.get(0), yMap.get(0));
        }

        public String solution(String X, String Y) {
            StringBuilder answer = new StringBuilder();

            Map<Integer, Integer> xMap = new HashMap<>();
            Map<Integer, Integer> yMap = new HashMap<>();

            setMap(X, xMap);
            setMap(Y, yMap);

            for (int i=9; i>=1; i--) {
                int xMapCount = xMap.getOrDefault(i, 0);
                int yMapCount = yMap.getOrDefault(i, 0);

                int commonCount = min(xMapCount, yMapCount);

                for (int j=0; j<commonCount; j++) {
                    answer.append(i);
                }
            }

            int commonZeroCount = getZeroCount(xMap, yMap);

            if (answer.length() > 0 && commonZeroCount > 0) {
                for (int i=0; i<commonZeroCount; i++) {
                    answer.append('0');
                }
            }
            else if (commonZeroCount > 0) {
                return "0";
            }

            if (answer.isEmpty()) {
                return "-1";
            }

            return answer.toString();
        }
    }

    public static void main(String[] args) {

    }
}
