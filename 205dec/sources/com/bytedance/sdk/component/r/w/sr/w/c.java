package com.bytedance.sdk.component.r.w.sr.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private int f30103c;

    /* renamed from: w  reason: collision with root package name */
    private int f30104w;

    c(int i4, int i5, long j4) {
        if (i5 >= i4) {
            this.f30103c = i4;
            this.f30104w = i5;
            return;
        }
        throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
    }

    public static c xv() {
        return new c(1, 100, 172800000L);
    }

    public int c() {
        return this.f30103c;
    }

    public int w() {
        return this.f30104w;
    }

    public static c c(int i4, int i5) {
        return new c(i4, i5, 172800000L);
    }

    public static c c(int i4, int i5, long j4) {
        return new c(i4, i5, j4);
    }
}
