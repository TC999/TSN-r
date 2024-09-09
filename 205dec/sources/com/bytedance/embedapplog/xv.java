package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class xv<SERVICE, RESULT> {

    /* renamed from: c  reason: collision with root package name */
    private final CountDownLatch f26843c = new CountDownLatch(1);
    private final Context sr;

    /* renamed from: w  reason: collision with root package name */
    private final Intent f26844w;
    private final w<SERVICE, RESULT> xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class c implements ServiceConnection {
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        SERVICE f26845c;
        private final w<SERVICE, RESULT> sr;
        private final CountDownLatch xv;

        c(CountDownLatch countDownLatch, w<SERVICE, RESULT> wVar) {
            this.xv = countDownLatch;
            this.sr = wVar;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            be.c("ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                this.f26845c = this.sr.c(iBinder);
                this.xv.countDown();
            } catch (Exception e4) {
                be.c(e4);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            be.c("ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.xv.countDown();
            } catch (Exception e4) {
                be.c(e4);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    interface w<T, RESULT> {
        T c(IBinder iBinder);

        RESULT c(T t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xv(Context context, Intent intent, w<SERVICE, RESULT> wVar) {
        this.sr = context;
        this.f26844w = intent;
        this.xv = wVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RESULT c() {
        xv<SERVICE, RESULT>.c cVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            be.xv("Don't do this in ui thread.", null);
            return null;
        }
        try {
            cVar = new c(this.f26843c, this.xv);
            this.sr.bindService(this.f26844w, cVar, 1);
            this.f26843c.await();
        } catch (Throwable th) {
            th = th;
            cVar = null;
        }
        try {
            return this.xv.c((w<SERVICE, RESULT>) cVar.f26845c);
        } catch (Throwable th2) {
            th = th2;
            try {
                be.c(th);
                return null;
            } finally {
                c(cVar);
            }
        }
    }

    private void c(xv<SERVICE, RESULT>.c cVar) {
        if (cVar != null) {
            try {
                this.sr.unbindService(cVar);
            } catch (Throwable th) {
                be.c(th);
            }
        }
    }
}
