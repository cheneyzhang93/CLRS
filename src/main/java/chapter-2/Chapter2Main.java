import java.util.Arrays;

public class Chapter2Main {

    public static void main(String[] args) {
//        int[] A = new int[]{31, 41, 59, 26, 41, 58};
//        insertionSort(A);
//        System.out.println(Arrays.toString(A));

//        int[] a = new int[]{1, 0, 0};
//        int[] b = new int[]{1, 1, 1};
//        int[] c = add(a, b);
//        System.out.println(Arrays.toString(c));

//        int[] A = new int[]{31, 41, 59, 26, 41, 58};
//        selectSort(A);
//        System.out.println(Arrays.toString(A));

//        int[] A = new int[]{31, 41, 59, 26, 41, 58};
//        mergeSort(A, 0, A.length - 1);
//        System.out.println(Arrays.toString(A));

//        int[] A = new int[]{31, 41, 59, 26, 41, 58};
//        insertionSort2(A, A.length - 1);
//        System.out.println(Arrays.toString(A));

//        int[] A = new int[]{31, 41, 59, 26, 41, 58};
//        halfSearch(A, 58, 0, A.length - 1);
//        System.out.println(flag);

        int[] A = new int[]{26, 31, 41, 41, 58, 59};
        System.out.println(halfSearch1(A, 1));
    }

    public static void insertionSort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] < key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }

    public static int[] add(int[] a, int[] b) {
        int[] c = new int[a.length + 1];
        int bit = 0;

        int i = a.length - 1, j = i + 1;
        while (i >= 0) {
            int curr = 0;
            if (a[i] == 1 && b[i] == 1) {
                curr = 1;
                bit = 1;
            }
            if (a[i] == 1 || b[i] == 1) {
                curr = 1;
            }

            if (curr == 1 && bit == 0) {
                c[j] = 1;
            }
            if (curr == 0 && bit == 1) {
                c[j] = 1;
                bit = 0;
            }

            i--;
            j--;
        }
        c[0] = bit;

        return c;
    }

    public static void selectSort(int[] A) {

        for (int i = 1; i < A.length; i++) {

            int min = A[i - 1];
            int index = i - 1;
            for (int j = i; j < A.length; j++) {
                if (min > A[j]) {
                    index = j;
                    min = A[j];
                }
            }

            int temp = A[i - 1];
            A[i - 1] = A[index];
            A[index] = temp;
        }
    }

    public static void mergeSort(int[] A, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSort(A, p, q);
        mergeSort(A, q + 1, r);
        merge(A, p, q, r);
    }

    public static void merge(int[] A, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }

        int i = 0, j = 0, k = p;
        while (i < L.length && j < R.length) {
            if (L[i] > R[j]) {
                A[k] = R[j];
                j++;
            } else {
                A[k] = L[i];
                i++;
            }
            k++;
        }

        while (i < L.length) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < R.length) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void insertionSort2(int[] A, int n) {
        if (n < 1) {
            return;
        }
        insertionSort2(A, n - 1);
        insertion2(A, n);
    }

    public static void insertion2(int[] A, int n) {
        int key = A[n];
        int i = n - 1;
        while (i >= 0 && A[i] > key) {
            A[i + 1] = A[i];
            i = i - 1;
        }
        A[i + 1] = key;
    }

    static boolean flag = false;

    public static void halfSearch(int[] A, int n, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = (l + r) / 2;
        int key = A[i];
        if (n < key) {
            halfSearch(A, n, l, i);
        } else if (n > key) {
            halfSearch(A, n, i + 1, r);
        } else {
            flag = true;
        }
    }

    public static boolean halfSearch1(int[] A, int n) {

        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            int i = (l + r) / 2;

            if (A[i] == n) {
                return true;
            } else if (n < A[i]) {
                r = i;
            } else if (n > A[i]) {
                l = i + 1;
            }
        }

        return false;
    }

}
