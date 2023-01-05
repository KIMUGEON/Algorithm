import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726 {
    public static int M, N;
    public static int[] deltaX = {0, 0, 0, 1, -1};
    public static int[] deltaY = {0, 1, -1, 0, 0};
    public static int[][] Map;
    public static boolean[][][] Visited;
    public static Node Start, End;

    public static class Node {
        int row, col, dir, cnt;

        public Node(int row, int col, int dir, int cnt) {
            super();
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Map = new int[M + 1][N + 1];
        Visited = new boolean[M + 1][N + 1][5];

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < N + 1; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Start = new Node(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                0);

        st = new StringTokenizer(br.readLine());
        End = new Node(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                0);

        bfs();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(Start);

        Visited[Start.row][Start.col][Start.dir] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.row == End.row && current.col == End.col  && current.dir == End.dir) {
                System.out.println(current.cnt);

                return;
            }

            for (int i = 1; i <4; i++) {
                int nextX = current.row + deltaX[current.dir] * i;
                int nextY = current.col + deltaY[current.dir] * i;

                if (nextX > 0 && nextY > 0 && nextX < M + 1 && nextY < N + 1 && Map[nextX][nextY] != 1) {
                    if (!Visited[nextX][nextY][current.dir]) {
                        Visited[nextX][nextY][current.dir] = true;

                        queue.add(new Node(nextX, nextY, current.dir, current.cnt + 1));
                    }

                    continue;
                }

                break;
            }

            int[] dir = new int[2];

            switch (current.dir) {
                case 1:
                    dir[0] = 4;
                    dir[1] =3;

                    break;
                case 2:
                    dir[0] = 3;
                    dir[1] = 4;

                    break;
                case 3:
                    dir[0] = 1;
                    dir[1] = 2;

                    break;
                case 4:
                    dir[0] = 2;
                    dir[1] = 1;

                    break;
            }

            for (int d: dir) {
                if (!Visited[current.row][current.col][d]) {
                    Visited[current.row][current.col][d] = true;

                    queue.add(new Node(current.row, current.col, d, current.cnt + 1));
                }
            }
        }
    }
}
