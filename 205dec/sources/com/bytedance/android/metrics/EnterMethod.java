package com.bytedance.android.metrics;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum EnterMethod {
    NO_VALUE,
    VIDEO_CELL,
    VIDEO_HEAD,
    LIVE_CELL,
    LIVE_CARD;

    public String lowerName() {
        return name().toLowerCase();
    }
}
