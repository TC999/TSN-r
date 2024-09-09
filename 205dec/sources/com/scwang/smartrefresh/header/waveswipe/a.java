package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DisplayUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    private a() {
    }

    public static boolean a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }
}
