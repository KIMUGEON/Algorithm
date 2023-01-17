import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2960 {
    public static int N, K;
    public static int[] Map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map = new int[N + 1];

        int k = 1;

        for (int i = 2; i < N + 1; i++) {
            Map[i] = i;
        }

        out : for (int i = 2; i < N + 1; i++) {
            for (int j = i; j < N + 1; j += i) {
                if (Map[j] != 0) {
                    if (k == K) {
                        System.out.println(Map[j]);
                        break out;
                    }

                    k++;
                    Map[j] = 0;
                }
            }
        }
    }
}