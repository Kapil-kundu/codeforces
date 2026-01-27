import java.util.Scanner;

public class B {
    public static void main(String[] arsg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m == (n * n) - 1) { 
                System.out.println("NO");
            } else {
                int printedChar = 0;
                int cnt = 0;
                System.out.println("YES");
                int print = 0;
                int linePrinted = 0;
                while(printedChar != m) {
                    if(print == n - 1) {
                        System.out.println("U");
                        linePrinted++;
                        printedChar++;
                        print = 0;
                    } else {
                        System.out.print("U");
                        print++;
                        printedChar++;
                    }
                }
                int remainingPrintInLastPrinted = n - print;
                int remainingLineToPrint = n - linePrinted - 1;
                //System.out.println("Remaining Print in last printed = " + remainingPrintInLastPrinted);
                //System.out.println("Remaining Line to Print = " + remainingLineToPrint);
                for(int i = 0; i < remainingPrintInLastPrinted; i++) {
                    if(remainingLineToPrint > 0) {
                        System.out.print("D");
                    }
                }
                if(remainingLineToPrint == 0) {
                    for(int i = 0; i < remainingPrintInLastPrinted; i++) {
                        if(i == remainingPrintInLastPrinted - 1) {
                            System.out.println("L");
                        } else {
                            System.out.print("R");
                        }
                    }
                }
                System.out.println();
                for(int i = 0; i < remainingLineToPrint; i++) {
                    for(int j = 0; j < n; j++) {
                        if(j == n  - 1) {
                            System.out.println("L");
                        } else {
                            System.out.print("R");
                        }
                    }
                }
                
             }
        }
    }
}
                
