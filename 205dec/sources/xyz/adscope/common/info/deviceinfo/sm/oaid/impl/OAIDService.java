package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stub.StubApp;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
class OAIDService implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64744a;

    /* renamed from: b  reason: collision with root package name */
    public final IGetter f64745b;

    /* renamed from: c  reason: collision with root package name */
    public final RemoteCaller f64746c;

    @FunctionalInterface
    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface RemoteCaller {
        String callRemoteInterface(IBinder iBinder);
    }

    public OAIDService(Context context, IGetter iGetter, RemoteCaller remoteCaller) {
        this.f64744a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f64745b = iGetter;
        this.f64746c = remoteCaller;
    }

    public static void bind(Context context, Intent intent, IGetter iGetter, RemoteCaller remoteCaller) {
        new OAIDService(context, iGetter, remoteCaller).a(intent);
    }

    public final void a(Intent intent) {
        try {
            if (!this.f64744a.bindService(intent, this, 1)) {
                throw new OAIDException("Service binding failed");
            }
            OAIDLog.print("Service has been bound: " + intent);
        } catch (Exception e4) {
            this.f64745b.onOAIDGetError(e4);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        OAIDLog.print("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String callRemoteInterface = this.f64746c.callRemoteInterface(iBinder);
                    if (callRemoteInterface == null || callRemoteInterface.length() == 0) {
                        throw new OAIDException("OAID acquire failed");
                    }
                    OAIDLog.print("OAID acquire success: " + callRemoteInterface);
                    this.f64745b.onOAIDGetComplete(callRemoteInterface);
                    this.f64744a.unbindService(this);
                    OAIDLog.print("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e4) {
                    OAIDLog.print(e4);
                    this.f64745b.onOAIDGetError(e4);
                    this.f64744a.unbindService(this);
                    OAIDLog.print("Service has been unbound: " + componentName.getClassName());
                }
            } catch (Exception e5) {
                OAIDLog.print(e5);
            }
        } catch (Throwable th) {
            try {
                this.f64744a.unbindService(this);
                OAIDLog.print("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e6) {
                OAIDLog.print(e6);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        OAIDLog.print("Service has been disconnected: " + componentName.getClassName());
    }
}
