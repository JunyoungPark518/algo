package kakao.k2017;

/**
 * https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * Question : https://jay-ji.tistory.com/13?category=732905
 */
public class Q6FriendsBlock {

    public String[] solution(String[] input) {
        String[] output = new String[input.length];

        // ROW
        while(remove(input) != 0) {

        }



        return output;
    }

    public int remove(String[] input){

        String xy1, xy2, xy3, xy4;
        boolean flag = false;
        for(int i=input[1].length()-1; i>0; i--) {
            for(int j=input.length-1; j>0; j--) {

                xy1 = input[i-1].substring(j-1, j);
                xy2 = input[i-1].substring(j, j+1);
                xy3 = input[i].substring(j-1, j);
                xy4 = input[i].substring(j, j+1);

                if(xy1.equals(xy2) && xy1.equals(xy3) && xy1.equals(xy4)) {
                    input[i-1] = input[i-1].replace(xy1, " ").replace(xy1, " ");
                    input[i] = input[i].replace(xy1, " ").replace(xy1, " ");
                    flag = true;
                }
            }

        }

        for(int k=0; k<6; k++)
            System.out.println("input[" + k + "] >>> " + input[k]);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");


        if(flag) {
            // x
            for(int i=0; i<input[0].length(); i++) {
                // y
                for(int j=0; j<input.length-2; j++) {
                    System.out.println("input[i+2].substring(j, j+1) >>> " + input[j].substring(i, i+1));
//                    if(" ".equals(input[i].substring(j, j+1))) {
//                        input[i] = input[i].replace(" ", input[i+2].substring(j, j+1));
//                        input[i+2] =
//                    }

                }

            }
//            remove(input);
        }

        for(int k=0; k<6; k++)
            System.out.println("input[" + k + "] >>> " + input[k]);


        return 0;
    }

    public static void main(String[] args) {
        String[] input = {
                  "TTTANT"
                , "RRFACC"
                , "RRRFCC"
                , "TRRRAA"
                , "TTMMMF"
                , "TMMTTJ"};

        String[] result = new Q6FriendsBlock().solution(input);
//        for(String s : result)
//            System.out.println(s);
    }
}
