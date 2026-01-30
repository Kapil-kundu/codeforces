import java.util.*;

public class C {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){

            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n; i++) { 
                arr[i] = sc.nextInt();
            }
			
			int maxMex = 0;
            for(int i = 0; i < n; i++) {

                int x = -arr[i];

                Set<Integer> set = new HashSet<>();

                for(int num : arr) {
                    int val = num + x;
                    if(val >= 0) {
                        set.add(val);
                    }
                }

                int mex = 0;
                while(set.contains(mex)) {
                    mex++;
				}
                maxMex = Math.max(maxMex, mex);
            }

            System.out.println(maxMex);
        }
    }
}

