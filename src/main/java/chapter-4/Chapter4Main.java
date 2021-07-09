import java.util.Arrays;

public class Chapter4Main {

    public static void main(String[] args) {
        int[] A = new int[]{-2, -1, 3, -4, -5};
        System.out.println(Arrays.toString(findMaxSubArray(A, 0, A.length - 1)));
        System.out.println(Arrays.toString(findMaxSubArray2(A)));
    }

    static int maxLeft = 0;
    static int maxRight = 0;

    public static int[] findMaxCrossingSubArray(int[] A, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += A[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }

    public static int[] findMaxSubArray(int[] A, int low, int high) {
        if (low == high) {
            return new int[]{low, high, A[low]};
        } else {
            int mid = (low + high) / 2;
            int[] left = findMaxSubArray(A, low, mid);
            int[] right = findMaxSubArray(A, mid + 1, high);
            int[] crow = findMaxCrossingSubArray(A, low, mid, high);
            if (left[2] >= right[2] && left[2] >= crow[2]) {
                return left;
            } else if (right[2] >= left[2] && left[2] >= right[2]) {
                return right;
            } else {
                return crow;
            }
        }

    }

    public static int[] findMaxSubArray2(int[] A) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = A[i];
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                if (sum > max) {
                    max = sum;
                    left = i;
                    right = j;
                }
            }
        }
        return new int[]{left, right, max};
    }
}
