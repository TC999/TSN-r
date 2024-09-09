package com.bytedance.sdk.openadsdk.core.c;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.ys.w.w.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends com.bytedance.sdk.openadsdk.fz.c.w.c.sr implements w {

    /* renamed from: c  reason: collision with root package name */
    private long f32051c;

    public f(Bridge bridge) {
        super(bridge);
        this.f32051c = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
    public void onError(final int i4, final String str) {
        if (str == null) {
            str = "\u672a\u77e5\u5f02\u5e38";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onError(i4, str);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.super.onError(i4, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
    public void onFullScreenVideoAdLoad(final a aVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onFullScreenVideoAdLoad(aVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f.super.onFullScreenVideoAdLoad(aVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
    public void onFullScreenVideoCached() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onFullScreenVideoCached();
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.f.3
                @Override // java.lang.Runnable
                public void run() {
                    f.super.onFullScreenVideoCached();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.c.w
    public long c() {
        return this.f32051c;
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
    public void onFullScreenVideoCached(final a aVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onFullScreenVideoCached(aVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.f.4
                @Override // java.lang.Runnable
                public void run() {
                    f.super.onFullScreenVideoCached(aVar);
                }
            });
        }
    }
}
