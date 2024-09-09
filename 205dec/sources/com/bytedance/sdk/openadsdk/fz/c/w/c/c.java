package com.bytedance.sdk.openadsdk.fz.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35874c;

    public c(Bridge bridge) {
        this.f35874c = bridge == null ? b.f24741d : bridge;
    }

    public void onSplashLoadFail(com.bytedance.sdk.openadsdk.ys.w.w.c cVar) {
        b b4 = b.b(1);
        b4.h(0, cVar);
        this.f35874c.call(114103, b4.l(), Void.class);
    }

    public void onSplashLoadSuccess(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        b b4 = b.b(1);
        b4.h(0, wVar);
        this.f35874c.call(114102, b4.l(), Void.class);
    }

    public void onSplashRenderFail(com.bytedance.sdk.openadsdk.ys.w.w.w wVar, com.bytedance.sdk.openadsdk.ys.w.w.c cVar) {
        b b4 = b.b(2);
        b4.h(0, wVar);
        b4.h(1, cVar);
        this.f35874c.call(114105, b4.l(), Void.class);
    }

    public void onSplashRenderSuccess(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        b b4 = b.b(1);
        b4.h(0, wVar);
        this.f35874c.call(114104, b4.l(), Void.class);
    }
}
