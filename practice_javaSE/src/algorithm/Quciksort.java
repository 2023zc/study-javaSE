package algorithm;

import java.util.Random;
import java.util.Scanner;

public class Quciksort {
    public static void swap(int[] arr, int x, int y) {
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int QuicksortPivoit(int[] arr, int l, int r) {   //随机快速排序获得基准值
        Random ran = new Random();
        int randindex = ran.nextInt(l, r + 1);
        swap(arr, randindex, l);
        int pivoit = l;
        int j = pivoit + 1;
        for (int i = j; i <= r; i++) {
            if (arr[i] <= arr[pivoit]) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, pivoit, j - 1);
        pivoit = j - 1;
        return pivoit;
    }

    public static void Quicksort(int[] arr, int l, int r) {    //随机快速排序
        if (l >= r) {
            return;
        }
        int pivoit = QuicksortPivoit(arr, l, r);
        Quicksort(arr, l, pivoit - 1);
        Quicksort(arr, pivoit + 1, r);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] arr = new int[100];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        Quicksort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
