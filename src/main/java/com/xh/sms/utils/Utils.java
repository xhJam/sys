package com.xh.sms.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Utils {
    public static final String DEFAULT_STRING = null;
    public static final int DEFAULT_INT = -1;




    public static boolean checkAllPreliminary(Map<String, String> map) {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if ("name".equals(key) || "gender".equals(key)) {
                if (map.get(key) == null) {
                    return false;
                }
            }
            if ("age".equals(key) || "ids".equals(key)) {
                if (byStringToInt(map.get(key)) <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int byStringToInt(String str) {
        int value;
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            value = DEFAULT_INT;
        }
        return value;
    }
}
