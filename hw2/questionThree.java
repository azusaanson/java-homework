import java.io.*;
import java.lang.*;
import java.util.*;


class questionThree {
	public static void main(String[] args) {
        int arr[] = {4, 8, 2, 5};
        selectionSort(arr);
        System.out.println("選択ソート: ");
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
	}

	public static void selectionSort(int[] arr) {
        int n = arr.length;
  
        for (int i=0; i<n-1; i++) {
            int minIdex = i;
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[minIdex]) {
                    minIdex = j;
                }
            }
            int temp = arr[minIdex];
            arr[minIdex] = arr[i];
            arr[i] = temp;
        }
    }
}
