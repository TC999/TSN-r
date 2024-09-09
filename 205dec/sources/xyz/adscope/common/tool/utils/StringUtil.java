package xyz.adscope.common.tool.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StringUtil {
    public static String ListToString(List<String> list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (i4 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(list.get(i4));
            sb.append("\"");
        }
        sb.append("]");
        return sb.toString();
    }

    public static int getRandomValue(int i4) {
        return new Random().nextInt(i4);
    }

    public static Map<String, String> mapStringToMap(String str) {
        try {
            if (!TextUtils.isEmpty(str.trim()) && str.length() >= 2) {
                String[] split = str.substring(1, str.length() - 1).split(",");
                HashMap hashMap = new HashMap();
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length == 2) {
                        hashMap.put(split2[0].trim(), split2[1].trim());
                    } else {
                        LogUtil.e("StringUtil", "Invalid key-value pair: " + str2);
                    }
                }
                return hashMap;
            }
        } catch (Exception e4) {
            LogUtil.e("StringUtil", "Exception: " + e4);
        }
        return null;
    }

    public static String replaceM(Context context, String str, String str2) {
        return str;
    }

    public static String replaceStr(Context context, String str) {
        return replaceM(context, str, null);
    }

    public static float strToFloat(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0f;
            }
            return Float.parseFloat(str);
        } catch (Exception e4) {
            LogUtil.e("StringUtil", "e : " + e4);
            return 0.0f;
        }
    }

    public static int strToInt(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception e4) {
            LogUtil.e("StringUtil", "e : " + e4);
            return 0;
        }
    }
}
