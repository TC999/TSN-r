package com.bytedance.sdk.openadsdk.gb.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35886c;

    public w(Bridge bridge) {
        this.f35886c = bridge == null ? b.f24741d : bridge;
    }

    public void c(int i4, com.bytedance.sdk.openadsdk.fp.c.c.w.c.c cVar) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.h(1, cVar);
        this.f35886c.call(122101, b4.l(), Void.class);
    }
}
