package com.snail.antifake.deviceid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.IpScanner;
import com.snail.antifake.jni.PropertiesGet;
import p645t0.IAndroidIdUtil;
import p648u0.DeviceIdUtil;
import p651v0.EmuCheckUtil;
import p654w0.MacAddressUtils;

/* renamed from: com.snail.antifake.deviceid.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AndroidDeviceIMEIUtil {

    /* renamed from: a */
    public static BatteryChangeReceiver f33797a;

    /* renamed from: a */
    public static String m19705a(Context context) {
        return IAndroidIdUtil.m308a(context);
    }

    /* renamed from: b */
    public static String m19704b() {
        return PropertiesGet.m19666a("ro.product.board");
    }

    /* renamed from: c */
    public static String m19703c() {
        return PropertiesGet.m19666a("ro.bootloader");
    }

    /* renamed from: d */
    public static String m19702d() {
        return PropertiesGet.m19666a("ro.product.brand");
    }

    /* renamed from: e */
    public static String m19701e() {
        return PropertiesGet.m19666a("ro.product.cpu.abi");
    }

    /* renamed from: f */
    public static int m19700f() {
        BatteryChangeReceiver batteryChangeReceiver = f33797a;
        if (batteryChangeReceiver != null) {
            return batteryChangeReceiver.m19707a();
        }
        return -1;
    }

    /* renamed from: g */
    public static String m19699g() {
        return PropertiesGet.m19666a("ro.product.device");
    }

    /* renamed from: h */
    public static String m19698h(Context context) {
        return DeviceIdUtil.m243a(context);
    }

    /* renamed from: i */
    public static String m19697i() {
        return PropertiesGet.m19666a("ro.hardware");
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: j */
    public static String m19696j(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    /* renamed from: k */
    public static void m19695k(IpScanner.InterfaceC11946c interfaceC11946c) {
        new IpScanner().m19680e(interfaceC11946c);
    }

    /* renamed from: l */
    public static String m19694l(Context context) {
        return MacAddressUtils.m47b(context);
    }

    /* renamed from: m */
    public static String m19693m() {
        return PropertiesGet.m19666a("ro.product.manufacturer");
    }

    /* renamed from: n */
    public static String m19692n() {
        return PropertiesGet.m19666a("ro.product.model");
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: o */
    public static String m19691o() {
        String str = "";
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                str = Build.getSerial();
            } else {
                str = PropertiesGet.m19666a("ro.serialno");
                if (TextUtils.isEmpty(str)) {
                    str = Build.SERIAL;
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* renamed from: p */
    public static boolean m19690p() {
        BatteryChangeReceiver batteryChangeReceiver = f33797a;
        return (batteryChangeReceiver == null || batteryChangeReceiver.m19706b()) ? false : true;
    }

    /* renamed from: q */
    public static boolean m19689q(Context context) {
        return EmuCheckUtil.m196n(context);
    }

    /* renamed from: r */
    public static void m19688r(Context context) {
        if (f33797a == null) {
            f33797a = new BatteryChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            context.registerReceiver(f33797a, intentFilter);
        }
    }

    /* renamed from: s */
    public static void m19687s(Context context) {
        BatteryChangeReceiver batteryChangeReceiver = f33797a;
        if (batteryChangeReceiver == null) {
            context.unregisterReceiver(batteryChangeReceiver);
            f33797a = null;
        }
    }
}
