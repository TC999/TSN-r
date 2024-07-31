package com.baidu.idl.face.platform.p049ui.utils;

/* renamed from: com.baidu.idl.face.platform.ui.utils.IntentUtils */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class IntentUtils {
    private static IntentUtils instance;
    private String mBitmap;

    public static IntentUtils getInstance() {
        if (instance == null) {
            synchronized (IntentUtils.class) {
                if (instance == null) {
                    instance = new IntentUtils();
                }
            }
        }
        return instance;
    }

    public String getBitmap() {
        return this.mBitmap;
    }

    public void release() {
        if (instance != null) {
            instance = null;
        }
    }

    public void setBitmap(String str) {
        this.mBitmap = str;
    }
}
