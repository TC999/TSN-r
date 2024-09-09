package m1;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IPhoneSubInfoUtil.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class b {
    private static String a(String str, IBinder iBinder, String str2, int i4) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str2);
            if (!TextUtils.isEmpty(str)) {
                obtain.writeString(str);
            }
            iBinder.transact(i4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static String b(Context context) {
        String e4 = e(context);
        if (TextUtils.isEmpty(e4)) {
            e4 = d(context);
            if (TextUtils.isEmpty(e4)) {
                e4 = c(context);
                if (!TextUtils.isEmpty(e4)) {
                }
            }
        }
        return e4;
    }

    public static String c(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubscriberInfo", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(telephonyManager, new Object[0]);
            try {
                Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getDeviceId", String.class);
                if (declaredMethod2 != null) {
                    return (String) declaredMethod2.invoke(invoke, context.getPackageName());
                }
            } catch (Exception unused) {
            }
            Method declaredMethod3 = invoke.getClass().getDeclaredMethod("getDeviceId", new Class[0]);
            return declaredMethod3 != null ? (String) declaredMethod3.invoke(invoke, new Object[0]) : "";
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class);
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = Class.forName("com.android.internal.telephony.IPhoneSubInfo$Stub").getDeclaredMethod("asInterface", IBinder.class);
            declaredMethod2.setAccessible(true);
            Object invoke = declaredMethod2.invoke(null, (IBinder) declaredMethod.invoke(null, "iphonesubinfo"));
            try {
                Method declaredMethod3 = invoke.getClass().getDeclaredMethod("getDeviceId", String.class);
                if (declaredMethod3 != null) {
                    return (String) declaredMethod3.invoke(invoke, context.getPackageName());
                }
            } catch (Exception unused) {
            }
            Method declaredMethod4 = invoke.getClass().getDeclaredMethod("getDeviceId", new Class[0]);
            return declaredMethod4 != null ? (String) declaredMethod4.invoke(invoke, new Object[0]) : "";
        } catch (Exception unused2) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0073 A[Catch: Exception -> 0x0080, TRY_LEAVE, TryCatch #0 {Exception -> 0x0080, blocks: (B:9:0x0067, B:11:0x0073), top: B:18:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e(android.content.Context r12) {
        /*
            java.lang.String r0 = "TRANSACTION_getDeviceId"
            java.lang.String r1 = "getDeviceId"
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            java.lang.String r3 = ""
            java.lang.String r4 = "android.os.ServiceManager"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L81
            java.lang.String r5 = "getService"
            r6 = 1
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L81
            r8 = 0
            r7[r8] = r2     // Catch: java.lang.Exception -> L81
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r5, r7)     // Catch: java.lang.Exception -> L81
            r4.setAccessible(r6)     // Catch: java.lang.Exception -> L81
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L81
            java.lang.String r7 = "iphonesubinfo"
            r5[r8] = r7     // Catch: java.lang.Exception -> L81
            r7 = 0
            java.lang.Object r4 = r4.invoke(r7, r5)     // Catch: java.lang.Exception -> L81
            android.os.IBinder r4 = (android.os.IBinder) r4     // Catch: java.lang.Exception -> L81
            java.lang.String r5 = "com.android.internal.telephony.IPhoneSubInfo$Stub"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L81
            java.lang.String r9 = "asInterface"
            java.lang.Class[] r10 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L81
            java.lang.Class<android.os.IBinder> r11 = android.os.IBinder.class
            r10[r8] = r11     // Catch: java.lang.Exception -> L81
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r9, r10)     // Catch: java.lang.Exception -> L81
            r5.setAccessible(r6)     // Catch: java.lang.Exception -> L81
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L81
            r9[r8] = r4     // Catch: java.lang.Exception -> L81
            java.lang.Object r5 = r5.invoke(r7, r9)     // Catch: java.lang.Exception -> L81
            java.lang.Class r7 = r5.getClass()     // Catch: java.lang.Exception -> L66
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L66
            r6[r8] = r2     // Catch: java.lang.Exception -> L66
            java.lang.reflect.Method r2 = r7.getDeclaredMethod(r1, r6)     // Catch: java.lang.Exception -> L66
            if (r2 == 0) goto L66
            java.lang.String r12 = r12.getPackageName()     // Catch: java.lang.Exception -> L66
            java.lang.String r2 = com.snail.antifake.deviceid.b.a(r5)     // Catch: java.lang.Exception -> L66
            int r6 = com.snail.antifake.deviceid.b.b(r5, r0)     // Catch: java.lang.Exception -> L66
            java.lang.String r12 = a(r12, r4, r2, r6)     // Catch: java.lang.Exception -> L66
            goto L67
        L66:
            r12 = r3
        L67:
            java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Exception -> L80
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch: java.lang.Exception -> L80
            java.lang.reflect.Method r1 = r2.getDeclaredMethod(r1, r6)     // Catch: java.lang.Exception -> L80
            if (r1 == 0) goto L82
            java.lang.String r1 = com.snail.antifake.deviceid.b.a(r5)     // Catch: java.lang.Exception -> L80
            int r0 = com.snail.antifake.deviceid.b.b(r5, r0)     // Catch: java.lang.Exception -> L80
            java.lang.String r12 = a(r3, r4, r1, r0)     // Catch: java.lang.Exception -> L80
            goto L82
        L80:
            r3 = r12
        L81:
            r12 = r3
        L82:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.b.e(android.content.Context):java.lang.String");
    }
}
