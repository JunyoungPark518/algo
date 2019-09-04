package lib.algo.sort;

public class Merge {

    int[] sorted = new int[8];

    /**
     * 여러 개의 정렬된 자료의 집합을 결합해 하나의 집합으로 만드는 정렬 방법
     * 분할(Divide)한 뒤 각 부분집합들에 대해 정렬한 후 다시 결합(Combine)하는 분할 정복(Divide and Conquer) 기법을 사용
     * @param arr
     * @return
     */
    public int[] sort(int[] arr, int m, int n) {
        int middle;
        if(m<n) {
            middle = (m+n)/2;
            sort(arr, m, middle);           // 앞 부분에 대한 분할 작업 수행
            sort(arr, middle+1, n);     // 뒷 부분에 대한 분할 작업 수행
            merge(arr, m, middle, n);       // 부분집합에 대하여 정렬과 병합 작업 수행
        }
        return arr;
    }

    public void merge(int[] arr, int m, int middle, int n) {
        int i = m;             // 첫 번째 부분집합의 시작 위치 설정
        int j = middle + 1;    // 두 번째 부분집합의 시작 위치 설정
        int k = m;             // 배열 sorted에 정렬된 원소를 저장할 위치 설정

        while (i <= middle && j <= n) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i];
                i++;
            } else {
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }
        if (i > middle) {
            for (int t = j; t <= n; t++, k++) {
                sorted[k] = arr[t];
            }
        }
        else {
            for (int t = i; t <= middle; t++, k++) {
                sorted[k] = arr[t];
            }
        }

    }
}
