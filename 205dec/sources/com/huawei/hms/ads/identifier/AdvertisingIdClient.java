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
import b.a;
import b.b;
import java.io.IOException;

@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdvertisingIdClient {
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";

    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z3) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z3;
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

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class XI implements Runnable {

        /* renamed from: XI  reason: collision with root package name */
        public final /* synthetic */ Context f37478XI;

        public XI(Context context) {
            this.f37478XI = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(this.f37478XI);
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
            b bVar = new b();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        if (!bVar.f237a) {
                            bVar.f237a = true;
                            IBinder take = bVar.f238b.take();
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
                                    boolean z3 = obtain2.readInt() != 0;
                                    obtain2.recycle();
                                    obtain.recycle();
                                    Info info = new Info(readString, z3);
                                    try {
                                        context.unbindService(bVar);
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
                    context.unbindService(bVar);
                } catch (Throwable unused4) {
                }
                throw th;
            }
        } catch (PackageManager.NameNotFoundException unused5) {
            throw new IOException("Service not found");
        }
    }

    private static void updateAdvertisingIdInfo(Context context) {
        a.a.execute(new XI(context));
    }

    @Keep
    public static boolean verifyAdId(Context context, String str, boolean z3) {
        Info requestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
        if (requestAdvertisingIdInfo != null && TextUtils.equals(str, requestAdvertisingIdInfo.getId())) {
            if (z3 == requestAdvertisingIdInfo.isLimitAdTrackingEnabled()) {
                return true;
            }
        }
        return false;
    }
}
