package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OpenDeviceId.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    private static String f61689e = "OpenDeviceId library";

    /* renamed from: f  reason: collision with root package name */
    private static boolean f61690f;

    /* renamed from: b  reason: collision with root package name */
    private IDeviceidInterface f61692b;

    /* renamed from: c  reason: collision with root package name */
    private ServiceConnection f61693c;

    /* renamed from: a  reason: collision with root package name */
    private Context f61691a = null;

    /* renamed from: d  reason: collision with root package name */
    private InterfaceC1251b f61694d = null;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OpenDeviceId.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f61692b = IDeviceidInterface.Stub.c(iBinder);
            if (b.this.f61694d != null) {
                b.this.f61694d.a("Deviceid Service Connected", b.this);
            }
            b.this.e("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f61692b = null;
            b.this.e("Service onServiceDisconnected");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OpenDeviceId.java */
    /* renamed from: org.repackage.com.zui.opendeviceidlibrary.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface InterfaceC1251b<T> {
        void a(T t3, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (f61690f) {
            Log.i(f61689e, str);
        }
    }

    private void i(String str) {
        if (f61690f) {
            Log.e(f61689e, str);
        }
    }

    public int a(Context context, InterfaceC1251b<String> interfaceC1251b) {
        if (context != null) {
            this.f61691a = context;
            this.f61694d = interfaceC1251b;
            this.f61693c = new a();
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f61691a.bindService(intent, this.f61693c, 1)) {
                e("bindService Successful!");
                return 1;
            }
            e("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public String b() {
        if (this.f61691a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f61692b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.a();
                }
                return null;
            } catch (RemoteException e4) {
                i("getOAID error, RemoteException!");
                e4.printStackTrace();
                return null;
            }
        }
        i("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void g(boolean z3) {
        f61690f = z3;
    }

    public String h() {
        if (this.f61691a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f61692b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.b();
                }
                return null;
            } catch (RemoteException e4) {
                i("getUDID error, RemoteException!");
                e4.printStackTrace();
                return null;
            } catch (Exception e5) {
                i("getUDID error, Exception!");
                e5.printStackTrace();
                return null;
            }
        }
        i("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public boolean j() {
        try {
            if (this.f61692b != null) {
                e("Device support opendeviceid");
                return this.f61692b.c();
            }
            return false;
        } catch (RemoteException unused) {
            i("isSupport error, RemoteException!");
            return false;
        }
    }

    public String k() {
        Context context = this.f61691a;
        if (context != null) {
            String packageName = context.getPackageName();
            e("liufeng, getVAID package\uff1a" + packageName);
            if (packageName != null && !packageName.equals("")) {
                try {
                    IDeviceidInterface iDeviceidInterface = this.f61692b;
                    if (iDeviceidInterface != null) {
                        return iDeviceidInterface.a(packageName);
                    }
                    return null;
                } catch (RemoteException e4) {
                    i("getVAID error, RemoteException!");
                    e4.printStackTrace();
                    return null;
                }
            }
            e("input package is null!");
            return null;
        }
        e("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public String l() {
        Context context = this.f61691a;
        if (context != null) {
            String packageName = context.getPackageName();
            e("liufeng, getAAID package\uff1a" + packageName);
            String str = null;
            if (packageName != null && !packageName.equals("")) {
                try {
                    IDeviceidInterface iDeviceidInterface = this.f61692b;
                    if (iDeviceidInterface != null) {
                        str = iDeviceidInterface.b(packageName);
                        return ((str == null || "".equals(str)) && this.f61692b.c(packageName)) ? this.f61692b.b(packageName) : str;
                    }
                    return null;
                } catch (RemoteException unused) {
                    i("getAAID error, RemoteException!");
                    return str;
                }
            }
            e("input package is null!");
            return null;
        }
        e("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void m() {
        try {
            this.f61691a.unbindService(this.f61693c);
            e("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            i("unBind Service exception");
        }
        this.f61692b = null;
    }
}
