package com.bytedance.sdk.openadsdk.core.multipro.aidl.w;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.fp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends fp.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.q.c.w.c.c f33960c;

    /* renamed from: w  reason: collision with root package name */
    private Handler f33961w = new Handler(Looper.getMainLooper());

    public xv(com.bytedance.sdk.openadsdk.q.c.w.c.c cVar) {
        this.f33960c = cVar;
    }

    private void ev() {
        this.f33960c = null;
        this.f33961w = null;
    }

    private Handler gd() {
        Handler handler = this.f33961w;
        if (handler == null) {
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.f33961w = handler2;
            return handler2;
        }
        return handler;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fp
    public void f() throws RemoteException {
        gd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.xv.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.c.w.c.c cVar = xv.this.f33960c;
                if (cVar != null) {
                    cVar.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fp
    public void sr() throws RemoteException {
        gd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.xv.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.c.w.c.c cVar = xv.this.f33960c;
                if (cVar != null) {
                    cVar.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fp
    public void ux() throws RemoteException {
        gd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.xv.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.c.w.c.c cVar = xv.this.f33960c;
                if (cVar != null) {
                    cVar.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fp
    public void w() throws RemoteException {
        gd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.xv.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.c.w.c.c cVar = xv.this.f33960c;
                if (cVar != null) {
                    cVar.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fp
    public void xv() throws RemoteException {
        gd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.xv.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.c.w.c.c cVar = xv.this.f33960c;
                if (cVar != null) {
                    cVar.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fp
    public void c() throws RemoteException {
        ev();
    }
}
