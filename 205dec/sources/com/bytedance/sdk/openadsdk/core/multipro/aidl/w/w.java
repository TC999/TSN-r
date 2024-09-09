package com.bytedance.sdk.openadsdk.core.multipro.aidl.w;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.eq.r;
import com.bytedance.sdk.openadsdk.core.ys;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends ys.c {

    /* renamed from: c  reason: collision with root package name */
    private Handler f33955c = new Handler(Looper.getMainLooper());

    /* renamed from: w  reason: collision with root package name */
    private r.c f33956w;

    public w(r.c cVar) {
        this.f33956w = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys
    public void c() throws RemoteException {
        c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.w.1
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.f33956w != null) {
                    w.this.f33956w.c();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys
    public void c(final String str) throws RemoteException {
        c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.w.2
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.f33956w != null) {
                    w.this.f33956w.c(str);
                }
            }
        });
    }

    private void c(Runnable runnable) {
        if (this.f33955c == null) {
            this.f33955c = new Handler(Looper.getMainLooper());
        }
        this.f33955c.post(runnable);
    }
}
