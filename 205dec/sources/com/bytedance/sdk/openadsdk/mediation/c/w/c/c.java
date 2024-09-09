package com.bytedance.sdk.openadsdk.mediation.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36123c;

    public c(Bridge bridge) {
        this.f36123c = bridge == null ? b.f24741d : bridge;
    }

    public void c(String str, com.bytedance.sdk.openadsdk.mediation.c.w.w.c cVar) {
        b b4 = b.b(2);
        b4.i(0, str);
        b4.h(1, cVar);
        this.f36123c.call(270029, b4.l(), Void.class);
    }

    public void c(int i4, String str) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.i(1, str);
        this.f36123c.call(270030, b4.l(), Void.class);
    }
}
