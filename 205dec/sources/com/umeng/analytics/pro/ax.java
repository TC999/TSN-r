package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.stub.StubApp;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: CoolpadDeviceIdSupplier.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ax implements av {

    /* renamed from: a  reason: collision with root package name */
    private static final String f52598a = "Coolpad";

    /* renamed from: b  reason: collision with root package name */
    private static final String f52599b = "com.coolpad.deviceidsupport";

    /* renamed from: c  reason: collision with root package name */
    private static final String f52600c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d  reason: collision with root package name */
    private static a f52601d;

    /* renamed from: f  reason: collision with root package name */
    private CountDownLatch f52603f;

    /* renamed from: g  reason: collision with root package name */
    private Context f52604g;

    /* renamed from: e  reason: collision with root package name */
    private String f52602e = "";

    /* renamed from: h  reason: collision with root package name */
    private final ServiceConnection f52605h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ax.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ax.f52601d = a.b.a(iBinder);
                ax.this.f52602e = ax.f52601d.b(ax.this.f52604g.getPackageName());
                Log.d("Coolpad", "onServiceConnected: oaid = " + ax.this.f52602e);
            } catch (RemoteException | NullPointerException e4) {
                Log.e("Coolpad", "onServiceConnected failed e=" + e4.getMessage());
            }
            ax.this.f52603f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("Coolpad", "onServiceDisconnected");
            a unused = ax.f52601d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            if (context.bindService(intent, this.f52605h, 1)) {
                return;
            }
            Log.e("Coolpad", "bindService return false");
        } catch (Throwable th) {
            Log.e("Coolpad", "bindService failed. e=" + th.getMessage());
            this.f52603f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d("Coolpad", "call unbindService.");
            context.unbindService(this.f52605h);
        } catch (Throwable th) {
            Log.e("Coolpad", "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.av
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f52604g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f52603f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f52603f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e("Coolpad", "getOAID time-out");
            }
            return this.f52602e;
        } catch (InterruptedException e4) {
            Log.e("Coolpad", "getOAID interrupted. e=" + e4.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
