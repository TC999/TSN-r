package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.io.IOException;
import p022b.AbstractC0928a;
import p022b.ServiceConnectionC0929b;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdvertisingIdClient {
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";

    @Keep
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @Keep
        public final String getId() {
            return this.advertisingId;
        }

        @Keep
        public final boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    /* renamed from: com.huawei.hms.ads.identifier.AdvertisingIdClient$XI */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class RunnableC7060XI implements Runnable {

        /* renamed from: XI */
        public final /* synthetic */ Context f23995XI;

        public RunnableC7060XI(Context context) {
            this.f23995XI = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(this.f23995XI);
            } catch (Throwable unused) {
            }
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
                String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    updateAdvertisingIdInfo(context);
                    return new Info(string, Boolean.valueOf(string2).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return requestAdvertisingIdInfo(context);
    }

    @Keep
    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Info requestAdvertisingIdInfo(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            ServiceConnectionC0929b serviceConnectionC0929b = new ServiceConnectionC0929b();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                if (context.bindService(intent, serviceConnectionC0929b, 1)) {
                    try {
                        if (!serviceConnectionC0929b.f235a) {
                            serviceConnectionC0929b.f235a = true;
                            IBinder take = serviceConnectionC0929b.f236b.take();
                            Parcel obtain = Parcel.obtain();
                            Parcel obtain2 = Parcel.obtain();
                            try {
                                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                                take.transact(1, obtain, obtain2, 0);
                                obtain2.readException();
                                String readString = obtain2.readString();
                                obtain2.recycle();
                                obtain.recycle();
                                obtain = Parcel.obtain();
                                obtain2 = Parcel.obtain();
                                try {
                                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                                    take.transact(2, obtain, obtain2, 0);
                                    obtain2.readException();
                                    boolean z = obtain2.readInt() != 0;
                                    obtain2.recycle();
                                    obtain.recycle();
                                    Info info = new Info(readString, z);
                                    try {
                                        context.unbindService(serviceConnectionC0929b);
                                    } catch (Throwable unused) {
                                    }
                                    return info;
                                } finally {
                                }
                            } finally {
                            }
                        }
                        throw new IllegalStateException();
                    } catch (RemoteException unused2) {
                        throw new IOException("bind hms service RemoteException");
                    } catch (InterruptedException unused3) {
                        throw new IOException("bind hms service InterruptedException");
                    }
                }
                throw new IOException("bind failed");
            } catch (Throwable th) {
                try {
                    context.unbindService(serviceConnectionC0929b);
                } catch (Throwable unused4) {
                }
                throw th;
            }
        } catch (PackageManager.NameNotFoundException unused5) {
            throw new IOException("Service not found");
        }
    }

    private static void updateAdvertisingIdInfo(Context context) {
        AbstractC0928a.f233a.execute(new RunnableC7060XI(context));
    }

    @Keep
    public static boolean verifyAdId(Context context, String str, boolean z) {
        Info requestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
        if (requestAdvertisingIdInfo != null && TextUtils.equals(str, requestAdvertisingIdInfo.getId())) {
            if (z == requestAdvertisingIdInfo.isLimitAdTrackingEnabled()) {
                return true;
            }
        }
        return false;
    }
}
