package com.bytedance.sdk.openadsdk.fz.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ys.w.w.ys;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35875c;

    public f(Bridge bridge) {
        this.f35875c = bridge == null ? b.f24741d : bridge;
    }

    public void onError(int i4, String str) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.i(1, str);
        this.f35875c.call(153101, b4.l(), Void.class);
    }

    public void onNativeExpressAdLoad(List<ys> list) {
        b b4 = b.b(1);
        b4.h(0, list);
        this.f35875c.call(153102, b4.l(), Void.class);
    }
}
