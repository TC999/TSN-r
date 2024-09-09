package com.bytedance.sdk.openadsdk.ys.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36461c;

    public c(Bridge bridge) {
        this.f36461c = bridge == null ? b.f24741d : bridge;
    }

    public void c(int i4, Map map) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.h(1, map);
        this.f36461c.call(100101, b4.l(), Void.class);
    }
}
