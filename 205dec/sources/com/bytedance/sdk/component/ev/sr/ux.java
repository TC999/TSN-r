package com.bytedance.sdk.component.ev.sr;

import android.util.Log;
import com.bytedance.sdk.component.utils.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f29724c = false;

    /* renamed from: w  reason: collision with root package name */
    private static int f29725w = 4;

    public static boolean c() {
        return f29724c;
    }

    public static void w(String str, String str2) {
        if (f29724c && str2 != null && f29725w <= 4) {
            Log.i(a.sr(str), str2);
        }
    }

    public static void c(String str) {
        c("NetLog", str);
    }

    public static void c(String str, String str2) {
        if (f29724c && str2 != null && f29725w <= 2) {
            Log.v(a.sr(str), str2);
        }
    }
}
