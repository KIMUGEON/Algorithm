import java.util.Arrays;
import java.util.Scanner;

public class Main_10972 {
    public static int N;
    public static int[] Arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Arr = new int[N];

        for (int i = 0; i < N; i++) {
            Arr[i] = sc.nextInt();
        }

        permutation();
    }

    public static void permutation() {
        int i = N - 1;

        while (i > 0 && Arr[i - 1] > Arr[i]) i--;

        if (i == 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(Arr, i, N);

        int j = i - 1;

        while (i < N && Arr[j] > Arr[i]) i++;

        swap(Arr, j, i);

        Arrays.sort(Arr,j + 1,N);

        print(Arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        } System.out.println();
    }
}
