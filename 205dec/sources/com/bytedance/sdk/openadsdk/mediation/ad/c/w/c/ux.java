package com.bytedance.sdk.openadsdk.mediation.ad.c.w.c;

import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ux extends com.bytedance.sdk.openadsdk.j.c.w.c.w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36042c;

    public ux(Bridge bridge) {
        super(bridge);
        this.f36042c = bridge == null ? b.f24741d : bridge;
    }

    public void c(View view, String str, int i4) {
        b b4 = b.b(3);
        b4.h(0, view);
        b4.i(1, str);
        b4.e(2, i4);
        this.f36042c.call(142102, b4.l(), Void.class);
    }

    public void w() {
        this.f36042c.call(142104, b.b(0).l(), Void.class);
    }

    public void c() {
        this.f36042c.call(142103, b.b(0).l(), Void.class);
    }
}
