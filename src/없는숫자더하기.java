import java.util.HashMap;
import java.util.Map;

class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 0;

        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i=0; i<numbers.length; i++) {
            int count = numberMap.getOrDefault(numbers[i], 0);
            numberMap.put(numbers[i], count + 1);
        }

        for (int i=1; i<=9; i++) {
            int count = numberMap.getOrDefault(numbers[i], 0);
            if (count == 0) {
                answer += i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}

