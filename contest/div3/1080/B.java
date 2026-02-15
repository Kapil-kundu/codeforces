import java.util.*;

public class B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean visited[] = new boolean[n + 1];
            boolean flag = false;

            for (int i = 1; i <= n; i++) {

                if (!visited[i]) {

                    ArrayList<Integer> indices = new ArrayList<>();
                    ArrayList<Integer> values = new ArrayList<>();

                    int curr = i;
                    while (curr <= n && !visited[curr]) {
                        visited[curr] = true;
                        indices.add(curr);
                        values.add(arr[curr]);
                        curr = curr * 2;
                    }

                    Collections.sort(indices);
                    Collections.sort(values);

                    if (!indices.equals(values)) {
                        System.out.println("NO");
                        flag = true;
                        break;
                    }
                }
            }

            if (!flag) {
                System.out.println("YES");
            }
        }
    }
}
