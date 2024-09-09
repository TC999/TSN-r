package com.bytedance.sdk.openadsdk.fz.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ys.w.w.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35877c;

    public sr(Bridge bridge) {
        this.f35877c = bridge == null ? b.f24741d : bridge;
    }

    public void onError(int i4, String str) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.i(1, str);
        this.f35877c.call(132101, b4.l(), Void.class);
    }

    public void onFullScreenVideoAdLoad(a aVar) {
        b b4 = b.b(1);
        b4.h(0, aVar);
        this.f35877c.call(132102, b4.l(), Void.class);
    }

    public void onFullScreenVideoCached() {
        this.f35877c.call(132104, b.b(0).l(), Void.class);
    }

    public void onFullScreenVideoCached(a aVar) {
        b b4 = b.b(1);
        b4.h(0, aVar);
        this.f35877c.call(132103, b4.l(), Void.class);
    }
}
