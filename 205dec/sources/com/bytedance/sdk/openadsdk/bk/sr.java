package com.bytedance.sdk.openadsdk.bk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum sr {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");
    
    private String ev;

    sr(String str) {
        this.ev = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ev;
    }
}
