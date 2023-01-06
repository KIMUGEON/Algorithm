import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
    public static int N, Max, Min, Cnt;
    public static int[] deltaX = {0, 1, 0, -1};
    public static int[] deltaY = {1, 0, -1, 0};
    public static boolean[][] Visited;
    public static int[][] Map;

    public static class Node {
        int row, col;

        public Node(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                Max = Math.max(Max, Map[i][j]);
                Min = Math.min(Min, Map[i][j]);
            }
        }

        for (int n = Min; n < Max + 1; n++) {
            Visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!Visited[i][j] && Map[i][j]>n) {
                        cnt++;
                        bfs(i, j, n);
                    }
                }
            }
            Cnt = Math.max(Cnt,cnt);
        }
        System.out.println(Cnt);
    }

    public static void bfs(int row, int col, int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));
        Visited[row][col] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.row + deltaX[i];
                int nextY = current.col + deltaY[i];

                if (nextX > -1 && nextY > -1 && nextX < N && nextY < N && !Visited[nextX][nextY] && Map[nextX][nextY] > n) {
                    Visited[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY));
                }
            }
        }
    }
}
