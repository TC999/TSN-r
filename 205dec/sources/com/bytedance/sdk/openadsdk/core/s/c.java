package com.bytedance.sdk.openadsdk.core.s;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum c {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);
    

    /* renamed from: f  reason: collision with root package name */
    private long f34522f;
    private long ux;

    c(int i4) {
        if (i4 >= 0 && i4 <= 63) {
            this.ux = 1 << i4;
            this.f34522f = i4;
            return;
        }
        throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
    }

    public long c() {
        return this.ux;
    }
}
