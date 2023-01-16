import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2667 {
    public static int N, Cnt;
    public static int[] deltaX = {1, 0, -1, 0};
    public static int[] deltaY = {0, -1, 0, 1};
    public static boolean[][] Visited;
    public static int[][] Map;
    public static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Map = new int[N][N];
        Visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                Map[i][j] = str.charAt(j) - '0';
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Map[i][j] != 0 && !Visited[i][j]) {
                    Cnt++;
                    priorityQueue.add(bfs(i, j));
                }
            }
        }

        System.out.println(Cnt);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
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

                if (nextX > -1 && nextY > -1 && nextX < N && nextY <N && Map[nextX][nextY] != 0 && !Visited[nextX][nextY]) {
                    Visited[nextX][nextY] = true;
                    cnt++;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

        return cnt;
    }
}