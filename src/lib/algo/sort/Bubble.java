package lib.algo.sort;

public class Bubble {

    /**
     * 배열의 인접 요소(adjacent element)를 비교하여 교환
     * @param arr
     * @return
     */
    public int[] sort(int[] arr){
        int tmp;
        for(int i=arr.length; i>0; i--) {
            for(int j=1; j<i; j++) {
                if(arr[j-1] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        return arr;
    }
}
