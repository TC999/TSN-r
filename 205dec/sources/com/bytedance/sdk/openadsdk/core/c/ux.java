package com.bytedance.sdk.openadsdk.core.c;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.ys.w.w.k;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends com.bytedance.sdk.openadsdk.fz.c.w.c.xv implements w {

    /* renamed from: c  reason: collision with root package name */
    private long f32077c;

    public ux(Bridge bridge) {
        super(bridge);
        this.f32077c = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.xv
    public void onError(final int i4, final String str) {
        if (str == null) {
            str = "\u672a\u77e5\u5f02\u5e38";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onError(i4, str);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.ux.1
                @Override // java.lang.Runnable
                public void run() {
                    ux.super.onError(i4, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.xv
    public void onFeedAdLoad(final List<k> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onFeedAdLoad(list);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.ux.2
                @Override // java.lang.Runnable
                public void run() {
                    ux.super.onFeedAdLoad(list);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.c.w
    public long c() {
        return this.f32077c;
    }
}
