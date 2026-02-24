// This is problem 4C = Registration System
/* 

In this problem we are given a String and we have to check if that string is 
repeated we have to increment at last index + 1 of that string

---------------Solution ------------------

we implemented a map which contains strings and frequency of that string
if that string already exists in map it output the same string with increment of freq
else it output OK and add string to the map with default freq 0

*/


import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String, Integer> map = new HashMap<>();
		String str;
		for(int i = 0; i < n; i++) {	
			str = sc.next();
			if(map.containsKey(str)) {
				int value = map.get(str);
				System.out.println(str + value);
				map.put(str, value + 1);
			} else {
				System.out.println("OK");
				map.put(str, map.getOrDefault(str, 0) + 1);
			}
		}

	}
}