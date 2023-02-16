import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
    public static int N, M, V;
    public static boolean[] Visited;
    public static int[][] Map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        Map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            Map[row][col] = 1;
            Map[col][row] = 1;
        }

        Visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        Visited = new boolean[N + 1];
        bfs(V);
    }

    public static void dfs(int v) {
        Visited[v] = true;

        System.out.print(v + " ");

        for (int i = 1; i < N + 1; i++) {
            if (!Visited[i] && Map[v][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        Visited[v] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            System.out.print(current + " ");

            for (int i = 1; i < N + 1; i++) {
                if (!Visited[i] && Map[current][i] == 1) {
                    Visited[i] = true;

                    queue.add(i);
                }
            }
        }
    }
}
