package com.bytedance.sdk.openadsdk.mediation.c.w.c;

import android.os.Bundle;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w extends com.bytedance.sdk.openadsdk.q.c.w.c.c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36125c;

    public w(Bridge bridge) {
        super(bridge);
        this.f36125c = bridge == null ? b.f24741d : bridge;
    }

    public void c(int i4, String str) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.i(1, str);
        this.f36125c.call(131106, b4.l(), Void.class);
    }

    public void w() {
        this.f36125c.call(131108, b.b(0).l(), Void.class);
    }

    public void xv() {
        this.f36125c.call(131109, b.b(0).l(), Void.class);
    }

    public void c() {
        this.f36125c.call(131107, b.b(0).l(), Void.class);
    }

    public void c(Bundle bundle) {
        b b4 = b.b(1);
        b4.h(0, bundle);
        this.f36125c.call(131110, b4.l(), Void.class);
    }
}
