import java.util.*;

public class C {

    static class Triple {
        int val, i, j, k, cost;

        Triple(int val, int i, int j, int k) {
            this.val = val;
            this.i = i;
            this.j = j;
            this.k = k;
            this.cost = Math.min(j - i, k - j);
        }
    }

    static long solve(ArrayList<Integer> list) {
        int n = list.size();

        Map<Integer, TreeSet<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(list.get(i), x -> new TreeSet<>()).add(i);
        }

        PriorityQueue<Triple> pq =
                new PriorityQueue<>(Comparator.comparingInt(t -> t.cost));

        // Build initial triples
        for (int val : pos.keySet()) {
            TreeSet<Integer> set = pos.get(val);
            if (set.size() < 3) continue;

            Integer a = null, b = null;
            for (int c : set) {
                if (a != null && b != null) {
                    pq.add(new Triple(val, a, b, c));
                }
                a = b;
                b = c;
            }
        }

        boolean[] removed = new boolean[n];
        int remaining = n;
        long totalCost = 0;

        while (!pq.isEmpty()) {
            Triple t = pq.poll();

            if (removed[t.i] || removed[t.j] || removed[t.k]) continue;

            removed[t.i] = removed[t.j] = removed[t.k] = true;
            remaining -= 3;
            totalCost += t.cost;

            TreeSet<Integer> set = pos.get(t.val);
            set.remove(t.i);
            set.remove(t.j);
            set.remove(t.k);

            // Rebuild affected neighbors
            Integer x = set.lower(t.i);
            Integer y = set.higher(t.i);
            Integer z = (y != null) ? set.higher(y) : null;

            if (x != null && y != null && z != null) {
                pq.add(new Triple(t.val, x, y, z));
            }
        }

        return remaining == 0 ? totalCost : -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            while (q-- > 0) {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;

                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) list.add(arr[i]);

                System.out.println(solve(list));
            }
        }
        sc.close();
    }
}

