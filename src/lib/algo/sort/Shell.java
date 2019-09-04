package lib.algo.sort;

public class Shell {

    /**
     * 삽입정렬의 단점을 보완하여 어느정도 거리가 떨어진 요소를 비교하여 교환하는 방식
     * @param arr
     * @return
     */
    public int[] sort(int[] arr) {
        int tmp;
        for(int h=arr.length/2; h>0; h/=2) {
            for(int i=0; i<h; i++) {
                for(int j=i+h; j<arr.length; j+=h) {
                    tmp = arr[j];
                    while(j>h-1 && arr[j-h] > tmp) {
                        arr[j] = arr[j-h];
                        j-=h;
                    }
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
