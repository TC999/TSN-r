package com.bytedance.sdk.openadsdk.sr.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36282c;

    public c(Bridge bridge) {
        this.f36282c = bridge == null ? b.f24741d : bridge;
    }

    public void onSplashAdClick(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        b b4 = b.b(1);
        b4.h(0, wVar);
        this.f36282c.call(111102, b4.l(), Void.class);
    }

    public void onSplashAdClose(com.bytedance.sdk.openadsdk.ys.w.w.w wVar, int i4) {
        b b4 = b.b(2);
        b4.h(0, wVar);
        b4.e(1, i4);
        this.f36282c.call(111103, b4.l(), Void.class);
    }

    public void onSplashAdShow(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        b b4 = b.b(1);
        b4.h(0, wVar);
        this.f36282c.call(111101, b4.l(), Void.class);
    }
}
