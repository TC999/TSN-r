package com.bytedance.c.w;

import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum xv {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE(AMPSConstants.AdType.AD_TYPE_NATIVE),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");
    

    /* renamed from: p  reason: collision with root package name */
    private String f26646p;

    xv(String str) {
        this.f26646p = str;
    }

    public String c() {
        return this.f26646p;
    }
}
