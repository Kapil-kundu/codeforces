import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

		int i = 0;
		int j = n - 1;
		long lastSumMatched = 0;
		long currentSumI = 0;
		long currentSumJ = 0;
		while(i < j) {
			currentSumI += arr[i];
			currentSumJ += arr[j];
			//System.out.println("currentSumI is " + currentSumI);
			//System.out.println("currentSumJ is " + currentSumJ);
			if(currentSumI == currentSumJ) {
				lastSumMatched = currentSumI;
				i++;
				j--;
				//System.out.println("I updated the value of lastSumMatched " + lastSumMatched);
			}
			if(currentSumI < currentSumJ) {
				i++;
				currentSumJ -= arr[j];
				//System.out.println(" I updated the value of i  " + i + " currentSumJ is " + currentSumJ);
			} else if(currentSumI > currentSumJ) {
				j--;
				currentSumI-=arr[i];
				//System.out.println("I updated the value of j " + j + "currentSumI is " + currentSumI);
			}
		}

		System.out.println(lastSumMatched);
	}
}