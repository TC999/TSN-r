package com.bytedance.sdk.openadsdk.core.multipro.aidl.w;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.fz;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends fz.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.gb.c.w.c.c f33942c;

    /* renamed from: w  reason: collision with root package name */
    private Handler f33943w = new Handler(Looper.getMainLooper());

    public ux(com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar) {
        this.f33942c = cVar;
    }

    private void gd() {
        this.f33942c = null;
        this.f33943w = null;
    }

    private Handler p() {
        Handler handler = this.f33943w;
        if (handler == null) {
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.f33943w = handler2;
            return handler2;
        }
        return handler;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz
    public void f() throws RemoteException {
        p().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar = ux.this.f33942c;
                if (cVar != null) {
                    cVar.onVideoError();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz
    public void r() throws RemoteException {
        p().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux.6
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar = ux.this.f33942c;
                if (cVar != null) {
                    cVar.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz
    public void sr() throws RemoteException {
        p().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar = ux.this.f33942c;
                if (cVar != null) {
                    cVar.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz
    public void ux() throws RemoteException {
        p().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar = ux.this.f33942c;
                if (cVar != null) {
                    cVar.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz
    public void w() throws RemoteException {
        p().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar = ux.this.f33942c;
                if (cVar != null) {
                    cVar.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz
    public void xv() throws RemoteException {
        p().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar = ux.this.f33942c;
                if (cVar != null) {
                    cVar.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz
    public void c() throws RemoteException {
        gd();
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz
    public void c(final boolean z3, final int i4, final String str, final int i5, final String str2) throws RemoteException {
        p().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar = ux.this.f33942c;
                if (cVar != null) {
                    cVar.onRewardVerify(z3, i4, str, i5, str2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz
    public void c(final boolean z3, final int i4, final Bundle bundle) {
        p().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux.8
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar = ux.this.f33942c;
                if (cVar == null || eq.f33190w < 4400) {
                    return;
                }
                try {
                    cVar.onRewardArrived(z3, i4, bundle);
                } catch (AbstractMethodError unused) {
                    Log.e("RewardVideoListenerImpl", "onRewardArrived \u672a\u5b9e\u73b0\uff01");
                }
            }
        });
    }
}
