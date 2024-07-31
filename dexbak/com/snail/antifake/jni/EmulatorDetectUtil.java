package com.snail.antifake.jni;

import android.content.Context;
import com.snail.antifake.deviceid.AndroidDeviceIMEIUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class EmulatorDetectUtil {
    static {
        System.loadLibrary("emulator_check");
    }

    /* renamed from: a */
    public static boolean m19669a() {
        return detect();
    }

    /* renamed from: b */
    public static boolean m19668b(Context context) {
        return AndroidDeviceIMEIUtil.m19689q(context) || detect();
    }

    public static native boolean detect();

    /* renamed from: c */
    public void m19667c() {
    }
}
