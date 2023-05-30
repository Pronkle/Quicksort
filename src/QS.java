import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class QS {
    // main
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int[] arr = new int[st.countTokens()];
        // creates array and fills with inputs
        for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
        // pw.println("STEP 1: Unsorted Array: " + Arrays.toString(arr));
        shuffleUp(arr);
        // pw.println("STEP 2: Shuffled Array: " + Arrays.toString(arr));
        quicksort(arr, 0, arr.length-1);
        pw.println("STEP 3: Final Sorted Array: " + Arrays.toString(arr));
        pw.close();
    }
    // shuffles the array given
    private static void shuffleUp(int[] arr){
        Random seed = ThreadLocalRandom.current();
        for(int i = arr.length-1; i > 0; i--){
            int index = seed.nextInt(i+1);
            swap(arr, index, i);
        }
    }
    // swaps values of given indexes
    private static void swap(int[] arr, int i, int j){
        int hold = arr[i];
        arr[i] = arr[j];
        arr[j] = hold;
    }

    private static void quicksort(int[] a, int low, int high){
        if(high <= low) return;
        // Above: termination condition for recursive quicksort
        int j = separateUp(a, low, high);
        quicksort(a, low, j-1);
        quicksort(a, j+1, high);
    }

    private static int separateUp(int[] a, int low, int high){
        int i = low, j = high + 1;
        int pivot = a[low];
        while(true){
            while(a[++i] < pivot) if (i == high) break;
            while(pivot < a[--j]) if (j == low) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }
}
