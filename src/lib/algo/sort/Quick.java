package lib.algo.sort;

public class Quick {

    /**
     * 일정 피벗을 정하고 다른 숫자들의 대소를 비교하여 정렬
     * 시간 복잡도 : 최선(nlogn), 최악(n^2)
     * @param arr
     * @return
     */
    public int[] sort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = partition(arr, low, high);
            sort(arr, low, mid-1);
            sort(arr, mid+1, high);
        }
        return arr;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        int tmp;
        while(low < high) {
            while(arr[low] < pivot && low < high) low++;
            while(arr[high] > pivot && low < high) high--;
            if(low < high) {
                tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
        return low;
    }
}
