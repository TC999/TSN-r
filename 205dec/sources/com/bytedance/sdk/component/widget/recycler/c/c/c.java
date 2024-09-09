package com.bytedance.sdk.component.widget.recycler.c.c;

import android.os.Build;
import android.os.Trace;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {
    public static void c(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void c() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
