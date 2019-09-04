import lib.algo.sort.Insertion;
import lib.algo.sort.Merge;
import lib.algo.sort.Quick;
import lib.algo.sort.Shell;

public class AlgoApp {

    public static void main(String[] args) {
        int[] arr = {9,4,3,10,5,8,7,1};

//        arr = new Bubble().sort(arr);
//        arr = new Selection().sort(arr);
//        arr = new Insertion().sort(arr);
        arr = new Shell().sort(arr);
        arr = new Merge().sort(arr, 0, arr.length-1);
//        arr = new Quick().sort(arr, 0, arr.length-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++)
            sb.append(arr[i] + " ");

        System.out.println(sb.toString());
    }
}
