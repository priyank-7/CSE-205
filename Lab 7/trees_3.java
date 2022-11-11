package com.company;

import java.util.Arrays;

class heap {

    public void min_heapify(int [] arr, int n, int i)
    {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            min_heapify(arr, n, smallest);
        }
    }

    public void heapSort(int [] arr, int n)
    {
        for (int i = n / 2 - 1; i >= 0; i--)
            min_heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            min_heapify(arr, i, 0);
        }
    }

}
public class trees_3 {
    public static void main(String[] args) {

        heap h = new heap();
        int [] arr = { 4, 6, 3, 2, 9 };
        h.heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }
}
