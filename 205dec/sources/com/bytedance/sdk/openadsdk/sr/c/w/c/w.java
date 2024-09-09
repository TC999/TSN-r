package com.bytedance.sdk.openadsdk.sr.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36283c;

    public w(Bridge bridge) {
        this.f36283c = bridge == null ? b.f24741d : bridge;
    }

    public void onSplashCardClick() {
        this.f36283c.call(112102, b.b(0).l(), Void.class);
    }

    public void onSplashCardClose() {
        this.f36283c.call(112103, b.b(0).l(), Void.class);
    }

    public void onSplashCardReadyToShow(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        b b4 = b.b(1);
        b4.h(0, wVar);
        this.f36283c.call(121201, b4.l(), Void.class);
    }
}
