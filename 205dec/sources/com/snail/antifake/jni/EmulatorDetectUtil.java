package com.snail.antifake.jni;

import android.content.Context;
import com.snail.antifake.deviceid.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class EmulatorDetectUtil {
    static {
        System.loadLibrary("emulator_check");
    }

    public static boolean a() {
        return detect();
    }

    public static boolean b(Context context) {
        return a.q(context) || detect();
    }

    public static native boolean detect();

    public void c() {
    }
}
