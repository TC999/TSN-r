package com.bytedance.sdk.openadsdk.fz.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ys.w.w.p;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35879c;

    public w(Bridge bridge) {
        this.f35879c = bridge == null ? b.f24741d : bridge;
    }

    public void onDrawFeedAdLoad(List<p> list) {
        b b4 = b.b(1);
        b4.h(0, list);
        this.f35879c.call(172102, b4.l(), Void.class);
    }

    public void onError(int i4, String str) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.i(1, str);
        this.f35879c.call(172101, b4.l(), Void.class);
    }
}
