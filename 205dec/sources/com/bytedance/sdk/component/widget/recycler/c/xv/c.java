package com.bytedance.sdk.component.widget.recycler.c.xv;

import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {
    public static void c(EdgeEffect edgeEffect, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f4, f5);
        } else {
            edgeEffect.onPull(f4);
        }
    }
}
