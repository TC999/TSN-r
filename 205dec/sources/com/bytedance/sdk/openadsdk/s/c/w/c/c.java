package com.bytedance.sdk.openadsdk.s.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36275c;

    public c(Bridge bridge) {
        this.f36275c = bridge == null ? b.f24741d : bridge;
    }

    public void onCancel() {
        this.f36275c.call(244103, b.b(0).l(), Void.class);
    }

    public void onSelected(int i4, String str, boolean z3) {
        b b4 = b.b(3);
        b4.e(0, i4);
        b4.i(1, str);
        b4.j(2, z3);
        this.f36275c.call(244102, b4.l(), Void.class);
    }

    public void onShow() {
        this.f36275c.call(244101, b.b(0).l(), Void.class);
    }
}
