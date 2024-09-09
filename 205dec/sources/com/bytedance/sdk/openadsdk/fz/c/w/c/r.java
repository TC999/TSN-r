package com.bytedance.sdk.openadsdk.fz.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ys.w.w.fp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35876c;

    public r(Bridge bridge) {
        this.f35876c = bridge == null ? b.f24741d : bridge;
    }

    public void onError(int i4, String str) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.i(1, str);
        this.f35876c.call(124101, b4.l(), Void.class);
    }

    public void onRewardVideoAdLoad(fp fpVar) {
        b b4 = b.b(1);
        b4.h(0, fpVar);
        this.f35876c.call(124102, b4.l(), Void.class);
    }

    public void onRewardVideoCached() {
        this.f35876c.call(124104, b.b(0).l(), Void.class);
    }

    public void onRewardVideoCached(fp fpVar) {
        b b4 = b.b(1);
        b4.h(0, fpVar);
        this.f35876c.call(124103, b4.l(), Void.class);
    }
}
