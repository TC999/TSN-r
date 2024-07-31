package com.baidu.mobads.sdk.api;

import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    public int getSequenceId(int i) {
        int i2 = 1;
        if (i < 1) {
            return 1;
        }
        try {
            if (sessionHashMap.containsKey(i + "")) {
                int parseInt = Integer.parseInt(sessionHashMap.get(i + "")) + 1;
                if (parseInt >= 1) {
                    i2 = parseInt;
                }
                sessionHashMap.put(i + "", i2 + "");
            } else {
                sessionHashMap.put(i + "", "1");
            }
        } catch (Exception unused) {
        }
        return i2;
    }
}
