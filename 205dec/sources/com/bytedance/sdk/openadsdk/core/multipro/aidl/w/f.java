package com.bytedance.sdk.openadsdk.core.multipro.aidl.w;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.u;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends u.c {

    /* renamed from: c  reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.core.p.w.c f33926c;

    /* renamed from: w  reason: collision with root package name */
    private Handler f33927w = new Handler(Looper.getMainLooper());

    public f(com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
        this.f33926c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
        return cVar != null;
    }

    private Handler sr() {
        Handler handler = this.f33927w;
        if (handler == null) {
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.f33927w = handler2;
            return handler2;
        }
        return handler;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public void w(final long j4, final long j5, final String str, final String str2) throws RemoteException {
        if (this.f33926c != null) {
            sr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.p.w.c cVar = f.this.f33926c;
                    if (f.this.c(cVar)) {
                        cVar.w(j4, j5, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public void xv(final long j4, final long j5, final String str, final String str2) throws RemoteException {
        if (this.f33926c != null) {
            sr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.p.w.c cVar = f.this.f33926c;
                    if (f.this.c(cVar)) {
                        cVar.xv(j4, j5, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public void c() throws RemoteException {
        if (this.f33926c != null) {
            sr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.p.w.c cVar = f.this.f33926c;
                    if (f.this.c(cVar)) {
                        cVar.c();
                    }
                }
            });
        }
    }

    public void xv() {
        this.f33926c = null;
        this.f33927w = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public void c(final long j4, final long j5, final String str, final String str2) throws RemoteException {
        if (this.f33926c != null) {
            sr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.p.w.c cVar = f.this.f33926c;
                    if (f.this.c(cVar)) {
                        cVar.c(j4, j5, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public void c(final long j4, final String str, final String str2) throws RemoteException {
        if (this.f33926c != null) {
            sr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.p.w.c cVar = f.this.f33926c;
                    if (f.this.c(cVar)) {
                        cVar.c(j4, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public void c(final String str, final String str2) throws RemoteException {
        if (this.f33926c != null) {
            sr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.p.w.c cVar = f.this.f33926c;
                    if (f.this.c(cVar)) {
                        String str3 = str;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = str2;
                        cVar.c(str3, str4 != null ? str4 : "");
                    }
                }
            });
        }
    }
}
