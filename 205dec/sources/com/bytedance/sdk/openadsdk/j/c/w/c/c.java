package com.bytedance.sdk.openadsdk.j.c.w.c;

import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ys.w.w.t;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35910c;

    public c(Bridge bridge) {
        this.f35910c = bridge == null ? b.f24741d : bridge;
    }

    public void onAdClicked(View view, t tVar) {
        b b4 = b.b(2);
        b4.h(0, view);
        b4.h(1, tVar);
        this.f35910c.call(141101, b4.l(), Void.class);
    }

    public void onAdCreativeClick(View view, t tVar) {
        b b4 = b.b(2);
        b4.h(0, view);
        b4.h(1, tVar);
        this.f35910c.call(141102, b4.l(), Void.class);
    }

    public void onAdShow(t tVar) {
        b b4 = b.b(1);
        b4.h(0, tVar);
        this.f35910c.call(141103, b4.l(), Void.class);
    }
}
