package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.IDeviceIdService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.umeng.analytics.pro.be */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SamsungDeviceIdSupplier implements IDeviceIdSupplier {

    /* compiled from: SamsungDeviceIdSupplier.java */
    /* renamed from: com.umeng.analytics.pro.be$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class ServiceConnectionC13123a implements ServiceConnection {

        /* renamed from: a */
        boolean f37740a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f37741b;

        /* renamed from: a */
        public IBinder m14667a() throws InterruptedException {
            if (!this.f37740a) {
                this.f37740a = true;
                return this.f37741b.poll(5L, TimeUnit.SECONDS);
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f37741b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private ServiceConnectionC13123a() {
            this.f37740a = false;
            this.f37741b = new LinkedBlockingQueue<>();
        }
    }

    @Override // com.umeng.analytics.pro.IDeviceIdSupplier
    /* renamed from: a */
    public String mo14666a(Context context) {
        ServiceConnectionC13123a serviceConnectionC13123a = new ServiceConnectionC13123a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, serviceConnectionC13123a, 1)) {
            try {
                return IDeviceIdService.AbstractBinderC13120b.m14674a(serviceConnectionC13123a.m14667a()).mo14671a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC13123a);
            }
        }
        return null;
    }
}
