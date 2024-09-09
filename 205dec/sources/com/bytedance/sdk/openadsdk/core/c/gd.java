package com.bytedance.sdk.openadsdk.core.c;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.ys.w.w.fp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends com.bytedance.sdk.openadsdk.fz.c.w.c.r implements w {

    /* renamed from: c  reason: collision with root package name */
    private long f32059c;

    public gd(Bridge bridge) {
        super(bridge);
        this.f32059c = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
    public void onError(final int i4, final String str) {
        if (str == null) {
            str = "\u672a\u77e5\u5f02\u5e38";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onError(i4, str);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.gd.1
                @Override // java.lang.Runnable
                public void run() {
                    gd.super.onError(i4, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
    public void onRewardVideoAdLoad(final fp fpVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onRewardVideoAdLoad(fpVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.gd.2
                @Override // java.lang.Runnable
                public void run() {
                    gd.super.onRewardVideoAdLoad(fpVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
    public void onRewardVideoCached() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onRewardVideoCached();
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.gd.3
                @Override // java.lang.Runnable
                public void run() {
                    gd.super.onRewardVideoCached();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.c.w
    public long c() {
        return this.f32059c;
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
    public void onRewardVideoCached(final fp fpVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onRewardVideoCached(fpVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.gd.4
                @Override // java.lang.Runnable
                public void run() {
                    gd.super.onRewardVideoCached(fpVar);
                }
            });
        }
    }
}
