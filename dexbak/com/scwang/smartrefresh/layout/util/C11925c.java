package com.scwang.smartrefresh.layout.util;

import android.content.res.Resources;

/* compiled from: DensityUtil.java */
/* renamed from: com.scwang.smartrefresh.layout.util.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11925c {

    /* renamed from: a */
    float f33745a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    public static int m19766b(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: d */
    public static float m19764d(float f) {
        return f / Resources.getSystem().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public int m19767a(float f) {
        return (int) ((f * this.f33745a) + 0.5f);
    }

    /* renamed from: c */
    public float m19765c(float f) {
        return f / this.f33745a;
    }
}
