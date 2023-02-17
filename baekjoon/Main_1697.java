import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
    public static int N, K;
    public static boolean[] Visited = new boolean[1000001];

    public static class Node {
        int n, cnt;

        public Node(int n, int cnt) {
            super();
            this.n = n;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N, 0);
    }

    public static void bfs(int n, int cnt) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        Visited[n] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.n == K) {
                System.out.println(current.cnt);

                return;
            }

            if (current.n - 1 >= 0 && !Visited[current.n - 1]) {
                Visited[current.n - 1] = true;
                queue.add(new Node(current.n - 1, current.cnt + 1));
            }

            if (current.n + 1 <= 1000000 && !Visited[current.n + 1]) {
                Visited[current.n + 1] = true;
                queue.add(new Node(current.n + 1, current.cnt + 1));
            }

            if (current.n * 2 <= 1000000 && !Visited[current.n * 2]) {
                Visited[current.n * 2] = true;
                queue.add(new Node(current.n * 2, current.cnt + 1));
            }
        }
    }
}
