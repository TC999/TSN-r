package com.bytedance.sdk.openadsdk.mediation.ad.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36039c;

    public c(Bridge bridge) {
        this.f36039c = bridge == null ? b.f24741d : bridge;
    }

    public void c(int i4, String str) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.i(1, str);
        this.f36039c.call(268013, b4.l(), Void.class);
    }

    public void w() {
        this.f36039c.call(268015, b.b(0).l(), Void.class);
    }

    public void c() {
        this.f36039c.call(268014, b.b(0).l(), Void.class);
    }
}
