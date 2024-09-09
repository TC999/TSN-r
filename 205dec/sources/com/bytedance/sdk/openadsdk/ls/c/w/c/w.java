package com.bytedance.sdk.openadsdk.ls.c.w.c;

import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35969c;

    public w(Bridge bridge) {
        this.f35969c = bridge == null ? b.f24741d : bridge;
    }

    public void onAdClicked(View view, int i4) {
        b b4 = b.b(2);
        b4.h(0, view);
        b4.e(1, i4);
        this.f35969c.call(151101, b4.l(), Void.class);
    }

    public void onAdShow(View view, int i4) {
        b b4 = b.b(2);
        b4.h(0, view);
        b4.e(1, i4);
        this.f35969c.call(151102, b4.l(), Void.class);
    }

    public void onRenderFail(View view, String str, int i4) {
        b b4 = b.b(3);
        b4.h(0, view);
        b4.i(1, str);
        b4.e(2, i4);
        this.f35969c.call(151103, b4.l(), Void.class);
    }

    public void onRenderSuccess(View view, float f4, float f5) {
        b b4 = b.b(3);
        b4.h(0, view);
        b4.d(1, f4);
        b4.d(2, f5);
        this.f35969c.call(151104, b4.l(), Void.class);
    }
}
