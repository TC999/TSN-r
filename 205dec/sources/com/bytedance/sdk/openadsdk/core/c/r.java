package com.bytedance.sdk.openadsdk.core.c;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends com.bytedance.sdk.openadsdk.fz.c.w.c.ux implements w {

    /* renamed from: c  reason: collision with root package name */
    private long f32067c;

    public r(Bridge bridge) {
        super(bridge);
        this.f32067c = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.ux
    public void c(final int i4, final String str) {
        if (str == null) {
            str = "\u672a\u77e5\u5f02\u5e38";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(i4, str);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.r.1
                @Override // java.lang.Runnable
                public void run() {
                    r.super.c(i4, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.ux
    public void c(final List<t> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(list);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.r.2
                @Override // java.lang.Runnable
                public void run() {
                    r.super.c(list);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.c.w
    public long c() {
        return this.f32067c;
    }
}
