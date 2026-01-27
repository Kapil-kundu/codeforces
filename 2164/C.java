import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.io.*;

public class C {
	
	public static void takingInput(int arr[], int n, Scanner sc) {
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
	}
		
	public static void main(String[] ars) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[m];
			int c[] = new int[m];
			
			takingInput(a, n, sc);
			takingInput(b, m, sc);
			takingInput(c, m, sc);
			
			int bc[][] = new int[m][2];
			for(int i = 0; i < m; i++) {
			    bc[i][0] = b[i];
			    bc[i][1] = c[i];
			}
			
			Arrays.sort(bc, (x, y) -> Integer.compare(x[0], y[0]));
			
			PriorityQueue<Integer> swords = new PriorityQueue<>();
			Stack <Integer> notUsed = new Stack<>();
			
		  	for(int i = 0; i < n; i++) {
		  		swords.offer(a[i]);
		  	}
		  	
		  	int ind = 0, cnt = 0;
	  		for (int[] hp_prize: bc){
			    int hp = hp_prize[0], prize = hp_prize[1];
			    if (prize == 0) {
			    	continue;
			    }
			    //while (ind<n && a[ind]<hp) ind++;
			    //if (ind==n) break;
			    while (!swords.isEmpty() && swords.peek()<hp) {
			    	notUsed.push(swords.poll());
			    }
			    
			    if (swords.isEmpty()) break;
			    	//a[ind]=Math.max(a[ind], prize);
			    swords.offer(Math.max(swords.poll(), prize));
			    cnt++;
		    }
		    
		    while (!notUsed.isEmpty()) {
		    	swords.offer(notUsed.pop());
		    }
		    for (int[] hp_prize: bc){
		        int hp = hp_prize[0], prize=hp_prize[1];
		        if (prize != 0) {
		        	continue;
		        }
		        //while (ind<n && a[ind]<hp) ind++;
		        //if (ind==n) break;
		        while (!swords.isEmpty() && swords.peek()<hp) {
		        	swords.poll();
		        }
		        if (swords.isEmpty()) {
		        	break;
		        }
		        //ind++;
		        swords.poll();
		        cnt++;
		    }
			System.out.println(cnt);
		  
		  
		}
	}
}
			
			
			
			
			
			
