package com.baidu.mobads.sdk.api;

import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BaiduNativeFeedSession {
    private static HashMap<String, String> sessionHashMap = new HashMap<>();
    private static BaiduNativeFeedSession theInstance;

    private BaiduNativeFeedSession() {
    }

    public static synchronized BaiduNativeFeedSession getInstance() {
        BaiduNativeFeedSession baiduNativeFeedSession;
        synchronized (BaiduNativeFeedSession.class) {
            if (theInstance == null) {
                theInstance = new BaiduNativeFeedSession();
            }
            baiduNativeFeedSession = theInstance;
        }
        return baiduNativeFeedSession;
    }

    public int getSequenceId(int i4) {
        int i5 = 1;
        if (i4 < 1) {
            return 1;
        }
        try {
            if (sessionHashMap.containsKey(i4 + "")) {
                int parseInt = Integer.parseInt(sessionHashMap.get(i4 + "")) + 1;
                if (parseInt >= 1) {
                    i5 = parseInt;
                }
                sessionHashMap.put(i4 + "", i5 + "");
            } else {
                sessionHashMap.put(i4 + "", "1");
            }
        } catch (Exception unused) {
        }
        return i5;
    }
}
