package com.bykv.vk.openvk.component.video.c.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private final long f25162c;

    /* renamed from: w  reason: collision with root package name */
    private final long f25163w;
    private final long xv;

    public long c(int i4) {
        if (i4 <= 0) {
            return this.f25162c;
        }
        return Math.min(this.f25162c + (this.f25163w * i4), this.xv);
    }
}
