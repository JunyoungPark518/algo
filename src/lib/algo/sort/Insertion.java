package lib.algo.sort;

public class Insertion {

    /**
     * 값을 비교를 통해서 앞으로 최소값을 보내는 정렬
     * @param arr
     * @return
     */
    public int[] sort(int[] arr) {
        int tmp;
        for(int i=1; i<arr.length; i++) {
            for(int j=i; j>0; j--){
                if(arr[j-1] > arr[j]) {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
