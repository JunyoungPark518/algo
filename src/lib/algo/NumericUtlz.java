package lib.algo;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class NumericUtlz {

    /**
     * 입력받은 문자가 숫자인지 판별함
     * @param input
     * @return
     */
    public static boolean isNumeric(String input){
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * input의 값이 숫자이면 가장 큰 값 반환
     * @param input
     * @return
     */
    public static String getMaxValue(String input) {
        if(!isNumeric(input))
            return "";
        try {
            Integer.parseInt(input);
            return String.valueOf(Integer.MAX_VALUE);
        } catch (Exception e) { }
        try {
            Long.parseLong(input);
            return String.valueOf(Long.MAX_VALUE);
        } catch (Exception e) { }
        try {
            Float.parseFloat(input);
            return String.valueOf(Float.MAX_VALUE);
        } catch (Exception e) { }
        try {
            Double.parseDouble(input);
            return String.valueOf(Double.MAX_VALUE);
        } catch (Exception e) { }
        return "";
    }

    /**
     * input의 값이 숫자이면 가장 작은 값 반환
     * @param input
     * @return
     */
    public static String getMinValue(String input) {
        if(!isNumeric(input))
            return "";
        try {
            Integer.parseInt(input);
            return String.valueOf(Integer.MIN_VALUE);
        } catch (Exception e) { }
        try {
            Long.parseLong(input);
            return String.valueOf(Long.MIN_VALUE);
        } catch (Exception e) { }
        try {
            Float.parseFloat(input);
            return String.valueOf(Float.MIN_VALUE);
        } catch (Exception e) { }
        try {
            Double.parseDouble(input);
            return String.valueOf(Double.MIN_VALUE);
        } catch (Exception e) { }
        return "";
    }


    /**
     * max 범위에서 랜덤값 계산
     */
    public static Double getDoubleRandomValue(Integer max){
        return Math.random() * max;
    }

    /**
     * max 범위에서 랜덤값 계산
     */
    public static Integer getIntegerRandomValue(Integer max){
        return Integer.parseInt(String.valueOf(Math.round(getDoubleRandomValue(max))));
    }

    /**
     * value의 값을 받아 point만큼 자리수로 표현
     * @param value
     * @param point
     * @return
     */
    public static Double toFixed(Double value, Integer point){
        return Double.parseDouble(String.format("%."+point+"f", value));
    }

    /**
     * Double의 값을 받아 Integer로 변환
     * @param value
     * @return
     */
    public static Integer getInteger(Double value){
        return Integer.parseInt(String.valueOf(value).split("\\.")[0]);
    }

    /**
     * value를 fill만큼의 자리수로 0을 채워서 반환
     * @param value
     * @param fill
     * @return
     */
    public static String fillZero(Integer value, Integer fill){
        return String.format("%0" + fill + "d", value);
    }

    /**
     * value의 세자리마다 Comma(,)를 붙여 반환
     * @param value
     * @return
     */
    public static String setComma(Object value){
        return new DecimalFormat("###,###").format(value);
    }


    /**
     * 확률 생성 함수
     * @param count 시도횟수
     * @param ratio 실제 확률
     * @return
     */
    public static Double generateRatio(long count, double ratio){
        AtomicLong matchCount = new AtomicLong();
        AtomicLong tryCount = new AtomicLong();

        LongStream.rangeClosed(1, count).parallel().forEach(i -> {
            tryCount.incrementAndGet();
            if(new Random().nextDouble() <= ratio){
                matchCount.incrementAndGet();
            }
        });

        return (double)matchCount.get()/(double)tryCount.get();
    }

    /**
     * 성공률 계산함수
     * @param ratio
     * @return
     */
    public static boolean isSuccess(Double ratio){
        return new Random().nextDouble() < ratio;
    }


    public static void main(String[] args) {
        System.out.println(getMaxValue("4.4028235E39"));
        System.out.println(getMinValue("4.4028235E39"));
    }

}
