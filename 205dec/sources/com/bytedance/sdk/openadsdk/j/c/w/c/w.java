package com.bytedance.sdk.openadsdk.j.c.w.c;

import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35911c;

    public w(Bridge bridge) {
        this.f35911c = bridge == null ? b.f24741d : bridge;
    }

    public void onRenderSuccess(View view, float f4, float f5, boolean z3) {
        b b4 = b.b(4);
        b4.h(0, view);
        b4.d(1, f4);
        b4.d(2, f5);
        b4.j(3, z3);
        this.f35911c.call(142101, b4.l(), Void.class);
    }
}
