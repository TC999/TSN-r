package com.bytedance.sdk.openadsdk.sr.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36284c;

    public xv(Bridge bridge) {
        this.f36284c = bridge == null ? b.f24741d : bridge;
    }

    public void onSplashClickEyeClick() {
        this.f36284c.call(113102, b.b(0).l(), Void.class);
    }

    public void onSplashClickEyeClose() {
        this.f36284c.call(113103, b.b(0).l(), Void.class);
    }

    public void onSplashClickEyeReadyToShow(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        b b4 = b.b(1);
        b4.h(0, wVar);
        this.f36284c.call(113101, b4.l(), Void.class);
    }
}
