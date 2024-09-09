package com.scwang.smartrefresh.layout.util;

import android.content.res.Resources;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DensityUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    float f48079a = Resources.getSystem().getDisplayMetrics().density;

    public static int b(float f4) {
        return (int) ((f4 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static float d(float f4) {
        return f4 / Resources.getSystem().getDisplayMetrics().density;
    }

    public int a(float f4) {
        return (int) ((f4 * this.f48079a) + 0.5f);
    }

    public float c(float f4) {
        return f4 / this.f48079a;
    }
}
