package lib.algo;

import java.text.DecimalFormat;
import java.util.Random;

import static lib.algo.NumericUtlz.isNumeric;

public class StringUtlz {

    /**
     * 입력받은 input의 index값을 char형의 replace로 치환한다
     * @param input
     * @param index
     * @param replace
     * @return
     */
    public static String replaceChar(String input, int index, char replace) {
        return new StringBuilder(input.substring(0, index)).append(replace).append(input.substring(index+1)).toString();
    }

    /**
     * 입력받은 input의 index값을 String형의 replace로 치환한다
     * @param input
     * @param index
     * @param replace
     * @return
     */
    public static String replaceTo(String input, int index, String replace) {
        return new StringBuilder(input.substring(0, index)).append(replace).append(input.substring(index+1)).toString();
    }

    /**
     * 입력받은 input의 index값을 int형의 replace로 치환한다
     * @param input
     * @param index
     * @param replace
     * @return
     */
    public static String replaceToInt(String input, int index, int replace) {
        return new StringBuilder(input.substring(0, index)).append(replace).append(input.substring(index+1)).toString();
    }

    /**
     * 입력받은 Input의 값이 비었는지 체크
     * @param input
     * @return
     */
    public static boolean isBlank(String input) {
        return input == null || input.length() == 0 || input.trim().equals("");
    }

    /**
     * 입력받은 Input에서 index의 문자열이 널인지 체크, index가 넘어도 허용
     * @param input
     * @param index
     * @return
     */
    public static boolean isCharNull(String input, int index) {
        try {
            return input.charAt(index) == ' ';
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * 입력받은 input에서 index의 값을 대문자로 바꾼다
     * @param input
     * @param index
     * @return
     */
    public static String toUpperOne(String input, int index) {
        return replaceTo(input, index, input.substring(index,index+1).toUpperCase());
    }

    /**
     * 입력받은 input에서 index의 값을 소문자로 바꾼다
     * @param input
     * @param index
     * @return
     */
    public static String toLowerOne(String input, int index) {
        return replaceTo(input, index, input.substring(index,index+1).toLowerCase());
    }

    /**
     * 입력받은 input에서 index의 값이 대문자이면 소문자로, 소문자면 대문자로 바꾼다
     * @param input
     * @param index
     * @return
     */
    public static String toUpperOrLowerOne(String input, int index) {
        if(input.substring(index,index+1).toUpperCase().equals(input.substring(index,index+1)))
            return toLowerOne(input, index);
        else
            return toUpperOne(input, index);
    }

    /**
     * 입력받은 index에 있는 값의 1 더하고 9인경우 0으로 만든다
     * @param input
     * @param index
     * @return
     */
    public static String plusOneIndex(String input, int index) {
        if(isNumeric(input.substring(index,index+1)))
            return replaceToInt(input, index, Integer.parseInt(input.substring(index,index+1)) == 9 ? 0 : Integer.parseInt(input.substring(index,index+1))+1);
        else
            return input;
    }

    /**
     * 입력받은 index에 있는 값의 1 빼고 0인경우 9로 만든다
      * @param input
     * @param index
     * @return
     */
    public static String minusOneIndex(String input, int index) {
        if(isNumeric(input.substring(index,index+1)))
            return replaceToInt(input, index, Integer.parseInt(input.substring(index,index+1)) == 0 ? 9 : Integer.parseInt(input.substring(index,index+1))-1);
        else
            return input;
    }


    /**
     * length 자리수 만큼의 랜덤 키 생성
     * @param length
     * @return
     */
    public static String makeRandomKey(int length) {
        String en = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append(String.format("%c", en.charAt(r.nextInt(en.length()))));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String test = "4444";
        System.out.println(isCharNull(test, 1));
        System.out.println(isCharNull(test, 2));
        System.out.println(isCharNull(test, 3));
        System.out.println(isCharNull(test, 4));
        System.out.println(isCharNull(test, 5));
        System.out.println(minusOneIndex(test, 2));
        System.out.println(plusOneIndex(test, 2));
        System.out.println(makeRandomKey(5));
    }
}
