package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.bk;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.c.f;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.c.r;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.c.sr;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.c.ux;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.c.w;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.c.xv;
import com.stub.StubApp;
import java.util.concurrent.CountDownLatch;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    private static volatile c xv;

    /* renamed from: c  reason: collision with root package name */
    private Context f33903c;
    private CountDownLatch sr;

    /* renamed from: w  reason: collision with root package name */
    private bk f33906w;
    private final Object ux = new Object();

    /* renamed from: f  reason: collision with root package name */
    private long f33904f = 0;

    /* renamed from: r  reason: collision with root package name */
    private ServiceConnection f33905r = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.this.f33906w = bk.c.c(iBinder);
            try {
                c.this.f33906w.asBinder().linkToDeath(c.this.ev, 0);
            } catch (RemoteException e4) {
                a.xv("MultiProcess", "onServiceConnected throws :", e4);
            }
            c.this.sr.countDown();
            a.w("MultiProcess", "onServiceConnected - binderService consume time \uff1a" + (System.currentTimeMillis() - c.this.f33904f));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a.xv("MultiProcess", "BinderPool......onServiceDisconnected");
        }
    };
    private IBinder.DeathRecipient ev = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.c.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            a.sr("MultiProcess", "binder died.");
            c.this.f33906w.asBinder().unlinkToDeath(c.this.ev, 0);
            c.this.f33906w = null;
            c.this.c();
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.multipro.aidl.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class BinderC0498c extends bk.c {
        @Override // com.bytedance.sdk.openadsdk.core.bk
        public IBinder c(int i4) throws RemoteException {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    return null;
                                }
                                return f.w();
                            }
                            return sr.w();
                        }
                        return w.w();
                    }
                    return xv.w();
                }
                return ux.w();
            }
            return r.w();
        }
    }

    private c(Context context) {
        this.f33903c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        c();
    }

    public static c c(Context context) {
        if (xv == null) {
            synchronized (c.class) {
                if (xv == null) {
                    xv = new c(context);
                }
            }
        }
        return xv;
    }

    public IBinder c(int i4) {
        try {
            bk bkVar = this.f33906w;
            if (bkVar != null) {
                return bkVar.c(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        a.xv("MultiProcess", "BinderPool......connectBinderPoolService");
        this.sr = new CountDownLatch(1);
        try {
            this.f33903c.bindService(new Intent(this.f33903c, BinderPoolService.class), this.f33905r, 1);
            this.f33904f = System.currentTimeMillis();
            this.sr.await();
        } catch (Exception e4) {
            a.xv("MultiProcess", "connectBinderPoolService throws: ", e4);
        }
    }
}
