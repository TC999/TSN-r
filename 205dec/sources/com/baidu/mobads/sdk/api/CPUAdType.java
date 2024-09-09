package com.baidu.mobads.sdk.api;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum CPUAdType {
    FEED("feed"),
    INTERSTITIAL("int"),
    REWARDVIDEO("rvideo"),
    OTHER("custom");
    
    private final String value;

    CPUAdType(String str) {
        this.value = str;
    }

    public static CPUAdType parse(String str) {
        CPUAdType[] values;
        for (CPUAdType cPUAdType : values()) {
            if (cPUAdType.value.equalsIgnoreCase(str)) {
                return cPUAdType;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
