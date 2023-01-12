import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953 {
    public static long A, B;
    public static boolean Check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dfs(A, 1);

        if (!Check) {
            System.out.println(-1);
        }
    }

    public static void dfs(long a, long cnt) {
        if (a == B) {
            Check = true;
            System.out.println(cnt);

            return;
        }

        if (a > B) {
            return;
        }

        dfs(2 * a, cnt + 1);
        dfs((10 * a) + 1, cnt + 1);
    }
}
