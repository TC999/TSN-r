package com.snail.antifake.deviceid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.d;
import com.snail.antifake.jni.PropertiesGet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: AndroidDeviceIMEIUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static BatteryChangeReceiver f48131a;

    public static String a(Context context) {
        return t0.a.a(context);
    }

    public static String b() {
        return PropertiesGet.a("ro.product.board");
    }

    public static String c() {
        return PropertiesGet.a("ro.bootloader");
    }

    public static String d() {
        return PropertiesGet.a("ro.product.brand");
    }

    public static String e() {
        return PropertiesGet.a("ro.product.cpu.abi");
    }

    public static int f() {
        BatteryChangeReceiver batteryChangeReceiver = f48131a;
        if (batteryChangeReceiver != null) {
            return batteryChangeReceiver.a();
        }
        return -1;
    }

    public static String g() {
        return PropertiesGet.a("ro.product.device");
    }

    public static String h(Context context) {
        return u0.a.a(context);
    }

    public static String i() {
        return PropertiesGet.a("ro.hardware");
    }

    @SuppressLint({"MissingPermission"})
    public static String j(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    public static void k(d.c cVar) {
        new d().e(cVar);
    }

    public static String l(Context context) {
        return w0.b.b(context);
    }

    public static String m() {
        return PropertiesGet.a("ro.product.manufacturer");
    }

    public static String n() {
        return PropertiesGet.a("ro.product.model");
    }

    @SuppressLint({"MissingPermission"})
    public static String o() {
        String str = "";
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                str = Build.getSerial();
            } else {
                str = PropertiesGet.a("ro.serialno");
                if (TextUtils.isEmpty(str)) {
                    str = Build.SERIAL;
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static boolean p() {
        BatteryChangeReceiver batteryChangeReceiver = f48131a;
        return (batteryChangeReceiver == null || batteryChangeReceiver.b()) ? false : true;
    }

    public static boolean q(Context context) {
        return v0.a.n(context);
    }

    public static void r(Context context) {
        if (f48131a == null) {
            f48131a = new BatteryChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            context.registerReceiver(f48131a, intentFilter);
        }
    }

    public static void s(Context context) {
        BatteryChangeReceiver batteryChangeReceiver = f48131a;
        if (batteryChangeReceiver == null) {
            context.unregisterReceiver(batteryChangeReceiver);
            f48131a = null;
        }
    }
}
