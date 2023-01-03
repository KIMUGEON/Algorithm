import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {
    public static int R, C, SR, SC, ER, EC;
    public static int[] deltaX = {-1, 0, 1, 0};
    public static int[] deltaY = {0, 1, 0, -1};
    public static int[][] Visited;
    public static char[][] Map;

    public static Queue<Node> Water = new LinkedList<>();
    public static class Node {
        String type;
        int row, col, cnt;

        public Node(String type, int row, int col, int cnt) {
            super();
            this.type = type;
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Map = new char[R][C];
        Visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                Map[i][j] = str.charAt(j);

                if (Map[i][j] == 'S') {
                    SR = i;
                    SC = j;
                } else if (Map[i][j] == 'D') {
                    ER = i;
                    EC = j;
                } else if (Map[i][j] == '*') {
                    Water.add(new Node("Water", i, j, 0));
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        for (Node node: Water) {
            Visited[node.row][node.col] = 2;
            queue.add(new Node("Water", node.row, node.col, 0));
        }

        Visited[SR][SC] = 1;
        queue.add(new Node("Animal", SR, SC, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.type == "Animal" && current.row == ER && current.col == EC) {
                System.out.println(current.cnt);

                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.row + deltaX[i];
                int nextY = current.col + deltaY[i];

                if (nextX > -1 && nextY > -1 && nextX < R && nextY < C && Map[nextX][nextY] != 'X') {
                    if (current.type == "Water" && Visited[nextX][nextY] != 2 && Map[nextX][nextY] != 'D') {
                        Visited[nextX][nextY] = 2;
                        queue.add(new Node("Water", nextX, nextY, current.cnt + 1));
                    } else if (current.type == "Animal" && Visited[nextX][nextY] != 1 && Visited[nextX][nextY] != 2) {
                        Visited[nextX][nextY] = 1;
                        queue.add(new Node("Animal", nextX, nextY, current.cnt + 1));
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }
}