package com.bytedance.sdk.openadsdk.mediation.ad.c.w.c;

import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36043c;

    public w(Bridge bridge) {
        this.f36043c = bridge == null ? b.f24741d : bridge;
    }

    public View c(com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c cVar) {
        b b4 = b.b(1);
        b4.h(0, cVar);
        return (View) this.f36043c.call(266013, b4.l(), View.class);
    }
}
