import java.util.*;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vals = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();

            if (!vals.contains(id)) {
                if (q.size() >= k) {
                    int cur = q.poll();
                    vals.remove(cur);
                }
                vals.add(id);
                q.add(id);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll());
        }

        Collections.reverse(res);
        System.out.println(res.size());
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
