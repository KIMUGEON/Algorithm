import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    public static int N, M;
    public static int[] deltaX = {-1, 0, 1, 0};
    public static int[] deltaY = {0, 1, 0, -1};
    public static boolean[][] Visited;
    public static int[][] Map;

    public static class Node {
        int row, col, cnt;

        public Node(int row, int col, int cnt) {
            super();
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        Visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str1 = br.readLine();

            for (int j = 0; j < M; j++) {
                String[] str2 = str1.split("");

                Map[i][j] = Integer.parseInt(str2[j]);
            }
        }

        bfs(0,0);
    }

    public static void bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col, 1));

        Visited[row][col] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.row == N - 1 && current.col == M - 1) {
                System.out.println(current.cnt);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.row + deltaX[i];
                int nextY = current.col + deltaY[i];

                if (nextX > -1 && nextY > -1 && nextX < N && nextY < M
                        && Map[nextX][nextY] ==1 && !Visited[nextX][nextY]) {
                    Visited[nextX][nextY] = true;

                    queue.add(new Node(nextX, nextY, current.cnt + 1));
                }
            }
        }
    }
}