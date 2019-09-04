package kakao;

public class KakaoTest1 {

    public static void main(String[] args) {

        //6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]
//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28};


        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
//        solution(5, arr1, arr2);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        solution(6, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] strArr1 = new String[n];
        String[] strArr2 = new String[n];

        for(int i=0; i<arr1.length; i++) {
            strArr1[i] = replace(Integer.toBinaryString(arr1[i]), n);
            strArr2[i] = replace(Integer.toBinaryString(arr2[i]), n);
            StringBuilder filled = new StringBuilder();
            for(int j=0; j<strArr1[i].length(); j++) {
                if (strArr1[i].charAt(j) == '#' || strArr2[i].charAt(j) == '#') {
                    filled.append('#');
                } else {
                    filled.append(' ');
                }
            }
            System.out.println(filled.toString());
            answer[i] = filled.toString();

        }
        return answer;
    }

    public static String replace(String str, int length){
        String blank = " ";
        String wall = "#";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append("0");
        }
        StringBuilder fill = new StringBuilder(sb.toString()).append(str);
        for(int i=0; i<str.length(); i++) {
            fill.deleteCharAt(0);
        }
        return fill.toString().replaceAll("0", blank).replaceAll("1", wall);
    }
    /**
     * String[] result = new String[n];
     *         for (int i = 0; i < n; i++) {
     *             result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
     *         }
     *
     *         for (int i = 0; i < n; i++) {
     *             result[i] = String.format("%" + n + "s", result[i]);
     *             result[i] = result[i].replaceAll("1", "#");
     *             result[i] = result[i].replaceAll("0", " ");
     *         }
     *
     *         return result;
     */
}
