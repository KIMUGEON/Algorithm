import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9663 {
    public static int N, Cnt;
    public static boolean[][] Queen, Check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Queen = new boolean[N][N];
        Check = new boolean[N][N];

        bfs(0);

        System.out.println(Cnt);
    }

    public static void bfs(int row) {
        if (row == N) {
            Cnt++;

            return;
        }

        for (int col = 0; col < N; col++) {
            if (!Check[row][col]) {
                Queen[row][col] = true;
                Check[row][col] = true;
                attack(row, col);

                bfs(row + 1);

                Queen[row][col] = false;
                Check[row][col] = false;
                
                init();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (Queen[i][j]) {
                            attack(i, j);
                        }
                    }
                }
            }
        }
    }

    public static void attack(int row, int col) {
        for (int i = 0; i < N; i++) {
            Check[i][col] = true;
        }
        for (int i = 1; ; i++) {
            int nr = row + i;
            int nc = col - i;

            if (nr > N - 1 | nc < 0) {
                break;
            }

            Check[nr][nc] = true;
        }
        for (int i = 1; ; i++) {
            int nr = row + i;
            int nc = col + i;

            if (nr > N - 1 | nc > N - 1) {
                break;
            }

            Check[nr][nc] = true;
        }
    }
    
    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Check[i][j] = false;
            }
        }
    }
}