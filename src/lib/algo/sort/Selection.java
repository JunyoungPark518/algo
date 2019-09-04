package lib.algo.sort;

public class Selection {

    /**
     * 최소값을 앞으로 보내는 정렬 - 안정성이 좀 떨어짐
     * @param arr
     * @return
     */
    public int[] sort(int[] arr) {
        int min, idx;
        for(int i=0; i<arr.length; i++) {
            min = arr[i];
            idx = i;
            for(int j=i+1; j<arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    idx = j;
                }
            }
            arr[idx] = arr[i];
            arr[i] = min;
        }

        return arr;
    }

}
