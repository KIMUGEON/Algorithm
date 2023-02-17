import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1743 {
    public static int N, M, K, Cnt;
    public static int[] deltaX = {0, 1, 0, -1};
    public static int[] deltaY = {1, 0, -1, 0};
    public static boolean[][] Visited;
    public static int[][] Map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        Visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            Map[row][col] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Map[i][j] == 1 && !Visited[i][j]) {
                    int cnt = bfs(i, j);
                    Cnt = Math.max(cnt, Cnt);
                }
            }
        }

        System.out.println(Cnt);
    }

    public static int bfs(int row, int col) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        Visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + deltaX[i];
                int nextY = current[1] + deltaY[i];

                if (nextX > -1 && nextY > -1 && nextX < N && nextY < M && Map[nextX][nextY] == 1 && !Visited[nextX][nextY]) {
                    Visited[nextX][nextY] = true;
                    cnt++;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

        return cnt;
    }
}
