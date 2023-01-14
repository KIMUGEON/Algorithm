import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963 {
    public static int W, H, Cnt;
    public static int[] deltaX = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] deltaY = {1, 1, 0, -1, -1, -1, 0, 1};
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

        while (true) {
            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            Cnt = 0;

            if (W == 0 && H == 0) {
                break;
            }

            Map = new int[H][W];
            Visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < W; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (Map[i][j] == 1 && !Visited[i][j]) {
                        Cnt++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(Cnt);
        }
    }

    public static void bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));
        Visited[row][col] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = current.row + deltaX[i];
                int nextY = current.col + deltaY[i];

                if (nextX > -1 && nextY > -1 && nextX < H && nextY < W && Map[nextX][nextY] == 1 && !Visited[nextX][nextY]) {
                    Visited[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY));
                }
            }
        }
    }
}