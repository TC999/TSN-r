package com.bytedance.sdk.openadsdk.fz.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35878c;

    public ux(Bridge bridge) {
        this.f35878c = bridge == null ? b.f24741d : bridge;
    }

    public void c(int i4, String str) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.i(1, str);
        this.f35878c.call(143101, b4.l(), Void.class);
    }

    public void c(List<t> list) {
        b b4 = b.b(1);
        b4.h(0, list);
        this.f35878c.call(143102, b4.l(), Void.class);
    }
}
