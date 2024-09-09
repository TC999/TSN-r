package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class OpenDeviceId {
    private static boolean DBG = false;
    private static String TAG = "OpenDeviceId library";
    private ServiceConnection mConnection;
    private IDeviceidInterface mDeviceidInterface;
    private Context mContext = null;
    private CallBack mCallerCallBack = null;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface CallBack<T> {
        void serviceConnected(T t3, OpenDeviceId openDeviceId);
    }

    private void logPrintE(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPrintI(String str) {
    }

    public String getAAID() {
        Context context = this.mContext;
        if (context == null) {
            logPrintI("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        logPrintI("liufeng, getAAID package\uff1a" + packageName);
        if (packageName == null || packageName.equals("")) {
            logPrintI("input package is null!");
            return null;
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
            if (iDeviceidInterface != null) {
                String aaid = iDeviceidInterface.getAAID(packageName);
                return ((aaid == null || "".equals(aaid)) && this.mDeviceidInterface.f(packageName)) ? this.mDeviceidInterface.getAAID(packageName) : aaid;
            }
            return null;
        } catch (RemoteException unused) {
            logPrintE("getAAID error, RemoteException!");
            return null;
        }
    }

    public String getOAID() {
        if (this.mContext == null) {
            logPrintE("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.getOAID();
            }
            return null;
        } catch (RemoteException e4) {
            logPrintE("getOAID error, RemoteException!");
            e4.printStackTrace();
            return null;
        }
    }

    public String getUDID() {
        if (this.mContext == null) {
            logPrintE("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.getUDID();
            }
            return null;
        } catch (RemoteException e4) {
            logPrintE("getUDID error, RemoteException!");
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            logPrintE("getUDID error, Exception!");
            e5.printStackTrace();
            return null;
        }
    }

    public String getVAID() {
        Context context = this.mContext;
        if (context == null) {
            logPrintI("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        logPrintI("liufeng, getVAID package\uff1a" + packageName);
        if (packageName == null || packageName.equals("")) {
            logPrintI("input package is null!");
            return null;
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.getVAID(packageName);
            }
            return null;
        } catch (RemoteException e4) {
            logPrintE("getVAID error, RemoteException!");
            e4.printStackTrace();
            return null;
        }
    }

    public int init(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.mContext = context;
            this.mCallerCallBack = callBack;
            this.mConnection = new ServiceConnection() { // from class: com.zui.opendeviceidlibrary.OpenDeviceId.1
                @Override // android.content.ServiceConnection
                public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    OpenDeviceId.this.mDeviceidInterface = IDeviceidInterface.Stub.a(iBinder);
                    if (OpenDeviceId.this.mCallerCallBack != null) {
                        OpenDeviceId.this.mCallerCallBack.serviceConnected("Deviceid Service Connected", OpenDeviceId.this);
                    }
                    OpenDeviceId.this.logPrintI("Service onServiceConnected");
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    OpenDeviceId.this.mDeviceidInterface = null;
                    OpenDeviceId.this.logPrintI("Service onServiceDisconnected");
                }
            };
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.mContext.bindService(intent, this.mConnection, 1)) {
                logPrintI("bindService Successful!");
                return 1;
            }
            logPrintI("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface != null) {
                logPrintI("Device support opendeviceid");
                return this.mDeviceidInterface.isSupport();
            }
            return false;
        } catch (RemoteException unused) {
            logPrintE("isSupport error, RemoteException!");
            return false;
        }
    }

    public void setLogEnable(boolean z3) {
        DBG = z3;
    }

    public void shutdown() {
        try {
            this.mContext.unbindService(this.mConnection);
            logPrintI("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            logPrintE("unBind Service exception");
        }
        this.mDeviceidInterface = null;
    }
}
