package com.bytedance.sdk.openadsdk.core.c;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.q;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.sdk.openadsdk.fz.c.w.c.c implements w {

    /* renamed from: c  reason: collision with root package name */
    private long f32082c;

    public xv(Bridge bridge) {
        super(bridge);
        this.f32082c = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.c
    public void onSplashLoadFail(final com.bytedance.sdk.openadsdk.ys.w.w.c cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onSplashLoadFail(cVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.xv.2
                @Override // java.lang.Runnable
                public void run() {
                    xv.super.onSplashLoadFail(cVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.c
    public void onSplashLoadSuccess(final com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onSplashLoadSuccess(wVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.xv.1
                @Override // java.lang.Runnable
                public void run() {
                    xv.super.onSplashLoadSuccess(wVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.c
    public void onSplashRenderFail(final com.bytedance.sdk.openadsdk.ys.w.w.w wVar, final com.bytedance.sdk.openadsdk.ys.w.w.c cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onSplashRenderFail(wVar, cVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.xv.4
                @Override // java.lang.Runnable
                public void run() {
                    xv.super.onSplashRenderFail(wVar, cVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.c
    public void onSplashRenderSuccess(final com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.onSplashRenderSuccess(wVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.xv.3
                @Override // java.lang.Runnable
                public void run() {
                    xv.super.onSplashRenderSuccess(wVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.c.w
    public long c() {
        return this.f32082c;
    }
}
