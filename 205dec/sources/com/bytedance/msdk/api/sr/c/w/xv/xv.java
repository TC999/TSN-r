package com.bytedance.msdk.api.sr.c.w.xv;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv {

    /* renamed from: c  reason: collision with root package name */
    private final String f27621c;
    private final int sr;
    private final String ux;

    /* renamed from: w  reason: collision with root package name */
    private final String f27622w;
    private final int xv;

    public xv(String str, String str2, int i4, int i5, String str3) {
        this.f27621c = str;
        this.f27622w = str2;
        this.xv = i4;
        this.sr = i5;
        this.ux = str3;
    }

    public ValueSet c() {
        b a4 = b.a();
        a4.i(8003, this.f27621c);
        a4.i(2, this.f27622w);
        a4.e(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes, this.xv);
        a4.e(8094, this.sr);
        a4.i(8547, this.ux);
        return a4.l();
    }

    public int w() {
        return this.xv;
    }
}
