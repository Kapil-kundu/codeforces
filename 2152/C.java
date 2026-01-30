import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            while(q-- > 0) {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt();
                int countZeros = 0;
                int countOnes = 0;

                boolean satisfy = false;
                for(int i = l; i < r; i++) {
                    if(i > l) {
                        if(arr[i] == arr[i - 1]) {
                            satisfy = true;
                        }
                    }
                    if(arr[i] == 0) {
                        countZeros++;
                    } else {
                        countOnes++;
                    }
                    
                }

                if(countOnes % 3 == 0 && countZeros % 3 == 0) {
                    int OneCost = countOnes / 3;
                    int ZeroCost = countZeros / 3;
                    if(!satisfy) {
                        System.out.println(OneCost + ZeroCost + 1);
                    } else {
                        System.out.println(OneCost + ZeroCost);
                    }
                } else {
                    System.out.println("-1");
                }
            }

        }
    }
}