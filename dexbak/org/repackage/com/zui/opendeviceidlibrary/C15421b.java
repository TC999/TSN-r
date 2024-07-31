package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* compiled from: OpenDeviceId.java */
/* renamed from: org.repackage.com.zui.opendeviceidlibrary.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C15421b {

    /* renamed from: e */
    private static String f44288e = "OpenDeviceId library";

    /* renamed from: f */
    private static boolean f44289f;

    /* renamed from: b */
    private IDeviceidInterface f44291b;

    /* renamed from: c */
    private ServiceConnection f44292c;

    /* renamed from: a */
    private Context f44290a = null;

    /* renamed from: d */
    private InterfaceC15423b f44293d = null;

    /* compiled from: OpenDeviceId.java */
    /* renamed from: org.repackage.com.zui.opendeviceidlibrary.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class ServiceConnectionC15422a implements ServiceConnection {
        ServiceConnectionC15422a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C15421b.this.f44291b = IDeviceidInterface.Stub.m2686a(iBinder);
            if (C15421b.this.f44293d != null) {
                C15421b.this.f44293d.m2665a("Deviceid Service Connected", C15421b.this);
            }
            C15421b.this.m2674e("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C15421b.this.f44291b = null;
            C15421b.this.m2674e("Service onServiceDisconnected");
        }
    }

    /* compiled from: OpenDeviceId.java */
    /* renamed from: org.repackage.com.zui.opendeviceidlibrary.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15423b<T> {
        /* renamed from: a */
        void m2665a(T t, C15421b c15421b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2674e(String str) {
        if (f44289f) {
            Log.i(f44288e, str);
        }
    }

    /* renamed from: i */
    private void m2670i(String str) {
        if (f44289f) {
            Log.e(f44288e, str);
        }
    }

    /* renamed from: a */
    public int m2678a(Context context, InterfaceC15423b<String> interfaceC15423b) {
        if (context != null) {
            this.f44290a = context;
            this.f44293d = interfaceC15423b;
            this.f44292c = new ServiceConnectionC15422a();
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f44290a.bindService(intent, this.f44292c, 1)) {
                m2674e("bindService Successful!");
                return 1;
            }
            m2674e("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    /* renamed from: b */
    public String m2677b() {
        if (this.f44290a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f44291b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.mo2685a();
                }
                return null;
            } catch (RemoteException e) {
                m2670i("getOAID error, RemoteException!");
                e.printStackTrace();
                return null;
            }
        }
        m2670i("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    /* renamed from: g */
    public void m2672g(boolean z) {
        f44289f = z;
    }

    /* renamed from: h */
    public String m2671h() {
        if (this.f44290a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f44291b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.mo2683b();
                }
                return null;
            } catch (RemoteException e) {
                m2670i("getUDID error, RemoteException!");
                e.printStackTrace();
                return null;
            } catch (Exception e2) {
                m2670i("getUDID error, Exception!");
                e2.printStackTrace();
                return null;
            }
        }
        m2670i("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    /* renamed from: j */
    public boolean m2669j() {
        try {
            if (this.f44291b != null) {
                m2674e("Device support opendeviceid");
                return this.f44291b.mo2681c();
            }
            return false;
        } catch (RemoteException unused) {
            m2670i("isSupport error, RemoteException!");
            return false;
        }
    }

    /* renamed from: k */
    public String m2668k() {
        Context context = this.f44290a;
        if (context != null) {
            String packageName = context.getPackageName();
            m2674e("liufeng, getVAID package：" + packageName);
            if (packageName != null && !packageName.equals("")) {
                try {
                    IDeviceidInterface iDeviceidInterface = this.f44291b;
                    if (iDeviceidInterface != null) {
                        return iDeviceidInterface.mo2684a(packageName);
                    }
                    return null;
                } catch (RemoteException e) {
                    m2670i("getVAID error, RemoteException!");
                    e.printStackTrace();
                    return null;
                }
            }
            m2674e("input package is null!");
            return null;
        }
        m2674e("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    /* renamed from: l */
    public String m2667l() {
        Context context = this.f44290a;
        if (context != null) {
            String packageName = context.getPackageName();
            m2674e("liufeng, getAAID package：" + packageName);
            String str = null;
            if (packageName != null && !packageName.equals("")) {
                try {
                    IDeviceidInterface iDeviceidInterface = this.f44291b;
                    if (iDeviceidInterface != null) {
                        str = iDeviceidInterface.mo2682b(packageName);
                        return ((str == null || "".equals(str)) && this.f44291b.mo2680c(packageName)) ? this.f44291b.mo2682b(packageName) : str;
                    }
                    return null;
                } catch (RemoteException unused) {
                    m2670i("getAAID error, RemoteException!");
                    return str;
                }
            }
            m2674e("input package is null!");
            return null;
        }
        m2674e("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    /* renamed from: m */
    public void m2666m() {
        try {
            this.f44290a.unbindService(this.f44292c);
            m2674e("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            m2670i("unBind Service exception");
        }
        this.f44291b = null;
    }
}
