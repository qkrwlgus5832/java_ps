import static java.lang.Math.min;

public class 최대공약수와최소공배수 {
    class Solution {
        private int greatestCommonValue(int n, int m, int minValue) {
            for (int i = minValue; i>=1; i--) {
                if (n % i == 0 && m % i == 0) {
                    return i;
                }
            }
            return 1;
        }

        private int leastCommonMultiple(int n, int m, int greatestCommonValue) {
            return (n / greatestCommonValue) * (m / greatestCommonValue) * greatestCommonValue;
        }

        public int[] solution(int n, int m) {
            int[] answer = {};

            int greatestCommonValue = greatestCommonValue(n, m, min(n, m));
            int leastCommonMultiple = leastCommonMultiple(n, m, greatestCommonValue);

            return new int[]{greatestCommonValue, leastCommonMultiple};
        }
    }
}
