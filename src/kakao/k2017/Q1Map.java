package kakao.k2017;

/**
 * https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * Question : https://jay-ji.tistory.com/13?category=732905
 */
public class Q1Map {


    public String[] solution(int[] arr1, int[] arr2){

        String[] result = new String[arr1.length];
        for(int i=0; i<arr1.length; i++) {
            String row = "";
            for(int j=0; j<5; j++) {
                if(fillZero(Integer.toBinaryString(arr1[i]), 5).charAt(j) == '1' || fillZero(Integer.toBinaryString(arr2[i]), 5).charAt(j) == '1')
                    row += "#";
                else
                    row += " ";
            }
            result[i] = row;
        }

        return result;
    }

    public String fillZero(String num, int len) {
        String ret = num;
        for(int i=0; i<len-num.length(); i++) {
            ret = "0" + ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] result  = new Q1Map().solution(arr1, arr2);
        for (String s : result) {
            System.out.println(s);
        }
    }

}
