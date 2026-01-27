import java.util.*;

public class B {

    public static PriorityQueue<Integer> readHeap(int n, Scanner sc) {
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
        return pq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            PriorityQueue<Integer> Alice = readHeap(n, sc);
            PriorityQueue<Integer> Bob = readHeap(m, sc);

            boolean aliceTurn = true;

            while (true) {
                if (aliceTurn) {
                    int x = Alice.peek();
                    int y = Bob.peek();

                    if (y <= x) {
                        Bob.poll();
                        if (Bob.isEmpty()) {
                            System.out.println("Alice");
                            break;
                        }
                    } else {
                        Bob.poll();
                        Bob.add(y - x);
                    }
                } else {
                    int x = Bob.peek();
                    int y = Alice.peek();

                    if (y <= x) {
                        Alice.poll();
                        if (Alice.isEmpty()) {
                            System.out.println("Bob");
                            break;
                        }
                    } else {
                        Alice.poll();
                        Alice.add(y - x);
                    }
                }
                aliceTurn = !aliceTurn;
            }
        }
    }
}

