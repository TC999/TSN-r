package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.stub.StubApp;
import com.umeng.analytics.pro.IDeviceIdManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.umeng.analytics.pro.ax */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CoolpadDeviceIdSupplier implements IDeviceIdSupplier {

    /* renamed from: a */
    private static final String f37711a = "Coolpad";

    /* renamed from: b */
    private static final String f37712b = "com.coolpad.deviceidsupport";

    /* renamed from: c */
    private static final String f37713c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d */
    private static IDeviceIdManager f37714d;

    /* renamed from: f */
    private CountDownLatch f37716f;

    /* renamed from: g */
    private Context f37717g;

    /* renamed from: e */
    private String f37715e = "";

    /* renamed from: h */
    private final ServiceConnection f37718h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ax.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                IDeviceIdManager unused = CoolpadDeviceIdSupplier.f37714d = IDeviceIdManager.AbstractBinderC13108b.m14769a(iBinder);
                CoolpadDeviceIdSupplier.this.f37715e = CoolpadDeviceIdSupplier.f37714d.mo14763b(CoolpadDeviceIdSupplier.this.f37717g.getPackageName());
                Log.d(CoolpadDeviceIdSupplier.f37711a, "onServiceConnected: oaid = " + CoolpadDeviceIdSupplier.this.f37715e);
            } catch (RemoteException | NullPointerException e) {
                Log.e(CoolpadDeviceIdSupplier.f37711a, "onServiceConnected failed e=" + e.getMessage());
            }
            CoolpadDeviceIdSupplier.this.f37716f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(CoolpadDeviceIdSupplier.f37711a, "onServiceDisconnected");
            IDeviceIdManager unused = CoolpadDeviceIdSupplier.f37714d = null;
        }
    };

    /* renamed from: b */
    private void m14686b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f37712b, f37713c));
            if (context.bindService(intent, this.f37718h, 1)) {
                return;
            }
            Log.e(f37711a, "bindService return false");
        } catch (Throwable th) {
            Log.e(f37711a, "bindService failed. e=" + th.getMessage());
            this.f37716f.countDown();
        }
    }

    /* renamed from: c */
    private void m14684c(Context context) {
        try {
            Log.d(f37711a, "call unbindService.");
            context.unbindService(this.f37718h);
        } catch (Throwable th) {
            Log.e(f37711a, "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.IDeviceIdSupplier
    /* renamed from: a */
    public String mo14666a(Context context) {
        if (context == null) {
            return null;
        }
        this.f37717g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f37716f = new CountDownLatch(1);
        try {
            m14686b(context);
            if (!this.f37716f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(f37711a, "getOAID time-out");
            }
            return this.f37715e;
        } catch (InterruptedException e) {
            Log.e(f37711a, "getOAID interrupted. e=" + e.getMessage());
            return null;
        } finally {
            m14684c(context);
        }
    }
}
