package lib.algo;

import java.util.*;

public class ParamUtlz {

    // Request Url에서 넘어온 params 체크
//    public static String getQueryStringLog(HttpServletRequest request) {
//        List<String> paramValueList = new ArrayList<>();
//        for (String paramKey : request.getParameterMap().keySet()) {
//            paramValueList.add(paramKey + "=" + String.join(",", request.getParameter(paramKey)));
//        }
//        return String.join("&", paramValueList);
//    }

    // IP 추출
//    public static String getIPAddress(HttpServletRequest request){
//        try{
//            String ip = request.getHeader("X-Forwarded-For");
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("Proxy-Client-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("WL-Proxy-Client-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("HTTP_CLIENT_IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getRemoteAddr();
//            }
//            int commaIndex = ip.indexOf(",");
//            if(commaIndex > 0){
//                return ip.substring(0,commaIndex);
//            }
//            else{
//                return ip;
//            }
//        }
//        catch(Exception e){
//            return "";
//        }
//    }

    /**
     * url에 담긴 파라미터들을 맵 구조로 반
     * @param url
     * @return
     */
    public static Map getParam(String url) {
        if(StringUtlz.isBlank(url))
            return Collections.emptyMap();

        return new HashMap(){{
            String[] pairs = url.split("&");
            Arrays.stream(pairs).forEach(pair -> {
                put(pair.split("=")[0], pair.split("=")[1]);
            });
        }};
    }
}
