package com.bytedance.sdk.openadsdk.core.multipro.aidl.w;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.t;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends t.c {

    /* renamed from: c  reason: collision with root package name */
    private Handler f33921c = new Handler(Looper.getMainLooper());

    /* renamed from: w  reason: collision with root package name */
    private f.c f33922w;

    public c(f.c cVar) {
        this.f33922w = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.t
    public void w() throws RemoteException {
        a.w("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnNo");
        c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f33922w != null) {
                    c.this.f33922w.w();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.t
    public void xv() throws RemoteException {
        a.w("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogCancel");
        c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f33922w != null) {
                    c.this.f33922w.xv();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.t
    public void c() throws RemoteException {
        a.w("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnYes");
        c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f33922w != null) {
                    c.this.f33922w.c();
                }
            }
        });
    }

    private void c(Runnable runnable) {
        this.f33921c.post(runnable);
    }
}
