package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.api.IAdInterListener;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public enum CPUAdType {
    FEED("feed"),
    INTERSTITIAL(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL),
    REWARDVIDEO(IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO),
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
