package util;

public class DataUtil {
    public static void swap(Object[] arr,int i, int j){
        Object tmp;
        tmp = arr[i];
        arr[i] = arr [j];
        arr[j] = tmp;
    }
    public static void swapByInt(int[] arr, int i, int j) {
        int tmp;
        tmp = arr[i];
        arr[i] = arr [j];
        arr[j] = tmp;
    }
}
