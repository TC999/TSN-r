package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;
import android.util.DisplayMetrics;

/* compiled from: DisplayUtil.java */
/* renamed from: com.scwang.smartrefresh.header.waveswipe.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11881a {
    private C11881a() {
    }

    /* renamed from: a */
    public static boolean m19996a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }
}
