import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {
    public static int T, L;
    public static int[] deltaX = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[] deltaY = {2, 1, -1, -2, -2, -1, 1, 2};
    public static boolean[][] Visited;
    public static int[][] Pos = new int[2][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            Visited = new boolean[L][L];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                Pos[i][0] = Integer.parseInt(st.nextToken());
                Pos[i][1] = Integer.parseInt(st.nextToken());
            }

            if (Pos[0][0] == Pos[1][0] && Pos[0][1] == Pos[1][1])
                System.out.println(0);
            else
                bfs(Pos[0][0], Pos[0][1]);
        }
    }

    public static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col, 0});
        Visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == Pos[1][0] && current[1] == Pos[1][1]) {
                System.out.println(current[2]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = current[0] + deltaX[i];
                int nextY = current[1] + deltaY[i];

                if (nextX > -1 && nextY > -1 && nextX < L && nextY <L && !Visited[nextX][nextY]) {
                    Visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY, current[2] + 1});
                }
            }
        }
    }
}