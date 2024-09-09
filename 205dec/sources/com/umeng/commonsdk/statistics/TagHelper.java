package com.umeng.commonsdk.statistics;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class TagHelper {
    private static Object lock = new Object();
    private static Map<String, String> moduleTags = new HashMap();

    public static void deleteModuleTag(String str) {
        synchronized (lock) {
            try {
                if (moduleTags.containsKey(str)) {
                    moduleTags.remove(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, String> getModuleTags() {
        HashMap hashMap = new HashMap();
        synchronized (lock) {
            try {
                if (moduleTags.size() > 0) {
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static void setModuleTag(String str, String str2) {
        synchronized (lock) {
            if (moduleTags.size() >= 30) {
                Log.e("UMLog", "\u4f20\u5165key-value\u952e\u503c\u5bf9\u4e2a\u6570\u5df2\u8fbe30\u4e2a\uff0csetModuleTag\u8c03\u7528\u65e0\u6548\u3002");
                return;
            }
            if (!moduleTags.containsKey(str)) {
                moduleTags.put(str, str2);
            }
        }
    }
}
