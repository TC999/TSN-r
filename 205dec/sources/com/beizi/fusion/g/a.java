package com.beizi.fusion.g;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdViewSizeUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {
    public static float a(Context context) {
        float f4 = context.getResources().getDisplayMetrics().density;
        float f5 = context.getResources().getDisplayMetrics().widthPixels;
        if (f4 <= 0.0f) {
            f4 = 1.0f;
        }
        return (f5 / f4) + 0.5f;
    }
}
