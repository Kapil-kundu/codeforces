import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            System.out.print(binSearch(a, in.nextInt()) + " ");
        }
    }

    public static int binSearch(Integer[] a, int key) {
        int index = 0, low = 0, high = a.length - 1, mid = (low + high) / 2;

        while (low <= high) {
            if (a[mid] <= key) {
                low = mid + 1;
                index = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return index;
    }
}