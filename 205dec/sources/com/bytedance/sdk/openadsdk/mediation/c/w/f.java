package com.bytedance.sdk.openadsdk.mediation.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36127c;

    public f(Bridge bridge) {
        this.f36127c = bridge == null ? b.f24741d : bridge;
    }

    public void c() {
        this.f36127c.call(270032, b.b(0).l(), Void.class);
    }

    public void c(xv xvVar) {
        b b4 = b.b(1);
        b4.h(0, xvVar);
        this.f36127c.call(270033, b4.l(), Void.class);
    }
}
