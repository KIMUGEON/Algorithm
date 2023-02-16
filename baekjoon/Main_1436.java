import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1436 {
    public static int N, Num, Cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Num = 665;

        while (Cnt != N) {
            Num++;
            String str = Integer.toString(Num);

            if (str.contains("666")) {
                Cnt++;
            }
        }

        System.out.println(Num);
    }
}
