import java.util.Scanner;

public class Main_10974 {
    public static int N;
    public static boolean[] Visited;
    public static int[] Input;
    public static int[] Output;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Input = new int[N];
        Output = new int[N];
        Visited = new boolean[N];

        permutation(0);
    }

    public static void permutation(int depth) {
        if (depth == N) {
            print(Output);

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!Visited[i]) {
                Visited[i] = true;
                Output[depth] = i + 1;
                permutation(depth+1);
                Visited[i] = false;
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
