package com.beizi.fusion.p072g;

import android.content.Context;

/* renamed from: com.beizi.fusion.g.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdViewSizeUtils {
    /* renamed from: a */
    public static float m48515a(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }
}
