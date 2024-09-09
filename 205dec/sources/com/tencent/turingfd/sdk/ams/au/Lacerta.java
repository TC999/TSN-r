package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Lacerta {

    /* renamed from: a  reason: collision with root package name */
    public static final Chestnut<String> f52107a = new Chestnut<>();

    public static String a() {
        Iterator it = ((ArrayList) Cepheus.a()).iterator();
        while (it.hasNext()) {
            Cswitch cswitch = (Cswitch) it.next();
            if (cswitch.f52361c.contains(Damson.f52011c)) {
                return cswitch.f52362d;
            }
        }
        return "";
    }

    public static int b(Context context) {
        Intent intent = null;
        try {
            intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable unused) {
        }
        if (intent == null) {
            return 0;
        }
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            int intExtra2 = intent.getIntExtra("plugged", -1);
            if (intExtra2 == 2) {
                return 3;
            }
            return intExtra2 == 1 ? 2 : 0;
        }
        return 1;
    }

    public static String c(Context context) {
        Chestnut<String> chestnut = f52107a;
        synchronized (chestnut) {
            String a4 = chestnut.a();
            if (a4 != null) {
                return a4;
            }
            StringBuilder sb = new StringBuilder();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            sb.append(telephonyManager.getSimState());
            if (Build.VERSION.SDK_INT >= 23) {
                int phoneCount = telephonyManager.getPhoneCount();
                sb.append(",");
                sb.append(phoneCount);
            }
            String sb2 = sb.toString();
            chestnut.a(sb2, PolicyConfig.mServerBusyRetryBaseInternal);
            return sb2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 24
            if (r0 < r2) goto L8
            return r1
        L8:
            int[] r0 = com.tencent.turingfd.sdk.ams.au.Cextends.f52287n0
            java.lang.String r0 = com.tencent.turingfd.sdk.ams.au.Cextends.a(r0)
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            r0 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L28
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L28
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L28
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> L26
            com.tencent.turingfd.sdk.ams.au.Ccontinue.a(r3)
            goto L30
        L26:
            r0 = r3
            goto L29
        L28:
        L29:
            if (r0 == 0) goto L2e
            com.tencent.turingfd.sdk.ams.au.Ccontinue.a(r0)
        L2e:
            java.lang.String r0 = ""
        L30:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L37
            return r1
        L37:
            java.lang.String r2 = "CONFIGURED"
            boolean r2 = r2.equals(r0)
            r3 = 3
            if (r2 == 0) goto L54
            r0 = 1
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = "adb_enabled"
            int r5 = android.provider.Settings.Secure.getInt(r5, r2, r1)     // Catch: java.lang.Throwable -> L4f
            if (r5 <= 0) goto L50
            r1 = 1
            goto L50
        L4f:
        L50:
            if (r1 == 0) goto L53
            return r0
        L53:
            return r3
        L54:
            java.lang.String r5 = "DISCONNECTED"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L5e
            r5 = 2
            return r5
        L5e:
            java.lang.String r5 = "CONNECTED"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L67
            return r3
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Lacerta.d(android.content.Context):int");
    }

    public static boolean e(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) <= 0) {
                return false;
            }
        } else if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) <= 0) {
            return false;
        }
        return true;
    }

    public static String f(Context context) {
        Map<String, Set<String>> map = Virgo.f52208a;
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            String a4 = Sculptor.a(context, packageName);
            Cswitch cswitch = new Cswitch();
            cswitch.f52361c = Damson.f52009a + Damson.f52010b;
            cswitch.f52362d = packageName + "_" + a4;
            arrayList.add(cswitch);
        }
        return arrayList.size() != 0 ? ((Cswitch) arrayList.get(0)).f52362d : "";
    }

    public static int a(Context context) {
        boolean z3 = false;
        int a4 = Cgoto.a(Cgoto.a(0, e(context), 0), Build.VERSION.SDK_INT >= 17 && Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) > 0, 1);
        try {
            if ((context.getApplicationInfo().flags & 2) > 0) {
                z3 = true;
            }
        } catch (Throwable unused) {
        }
        return Cgoto.a(Cgoto.a(a4, z3, 2), Debug.isDebuggerConnected(), 3);
    }

    public static String b() {
        Iterator it = ((ArrayList) Cepheus.a()).iterator();
        while (it.hasNext()) {
            Cswitch cswitch = (Cswitch) it.next();
            if (cswitch.f52361c.contains(Damson.f52012d)) {
                return cswitch.f52362d;
            }
        }
        return "";
    }
}
