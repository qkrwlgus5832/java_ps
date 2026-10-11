import java.util.Arrays;

public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] copyNums1 = Arrays.copyOfRange(nums1, 0, m);
            int[] copyNums2 = Arrays.copyOfRange(nums2, 0, n);

            int copyNum1Index = 0;
            int copyNum2Index = 0;

            for(int i=0; i<m + n; i++) {
                if (copyNum1Index >= m) {
                    nums1[i] = copyNums2[copyNum2Index];
                    copyNum2Index++;
                }
                else if (copyNum2Index >= n) {
                    nums1[i] = copyNums1[copyNum1Index];
                    copyNum1Index++;
                }
                else {
                    if (copyNums1[copyNum1Index] < copyNums2[copyNum2Index]) {
                        nums1[i] = copyNums1[copyNum1Index];
                        copyNum1Index++;
                    } else {
                        nums1[i] = copyNums2[copyNum2Index];
                        copyNum2Index++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        solution.merge(new int[]{1}, 1, new int[]{}, 0);

    }
}
