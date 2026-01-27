import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String str = sc.next();
            int[] arr = new int[10];
            for(int i = 0; i < 10; i++) {
                int ph = (int)str.charAt(i) - '0';
                arr[ph]++;
            }
            String Beaut = "a";
            for(int i = 0; i < 10; i++){
                for(int j = 9 - i; j < 10; j++) {
                    if(arr[j] != 0) {
                        Beaut = Beaut + j;
                        arr[j]--;
                        break;
                    }
                }
            }
            String beautiful = Beaut.substring(1, 11);
			      System.out.println(beautiful);
        }
    }
}


