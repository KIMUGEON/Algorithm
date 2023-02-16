import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303 {
    public static int N, M, White, Blue;
    public static int[] deltaX = {0, 1, 0, -1};
    public static int[] deltaY = {1, 0, -1, 0};
    public static boolean[][] Visited;
    public static char[][] Map;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new char[M][N];
        Visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                Map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!Visited[i][j]) {
                    if (Map[i][j] == 'W') {
                        White += Math.pow(bfs(i, j, Map[i][j]), 2);
                    } else {
                        Blue += Math.pow(bfs(i, j, Map[i][j]), 2);
                    }
                }
            }
        }

        System.out.println(White + " " + Blue);
    }

    public static int bfs(int row, int col, char color) {
        int cnt = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));

        Visited[row][col] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.row + deltaX[i];
                int nextY = current.col + deltaY[i];

                if (nextX > -1 && nextY > -1 && nextX < M && nextY < N && Map[nextX][nextY] == color && !Visited[nextX][nextY]) {
                    Visited[nextX][nextY] = true;
                    cnt++;
                    queue.add(new Node(nextX, nextY));
                }
            }
        }

        return cnt;
    }
}
