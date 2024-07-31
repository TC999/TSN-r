package com.facebook.rebound.p198ui;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* renamed from: com.facebook.rebound.ui.Util */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class Util {
    /* renamed from: a */
    public static final FrameLayout.LayoutParams m35525a(int i, int i2) {
        return new FrameLayout.LayoutParams(i, i2);
    }

    /* renamed from: b */
    public static final FrameLayout.LayoutParams m35524b() {
        return m35525a(-1, -1);
    }

    /* renamed from: c */
    public static final FrameLayout.LayoutParams m35523c() {
        return m35525a(-1, -2);
    }

    /* renamed from: d */
    public static final FrameLayout.LayoutParams m35522d() {
        return m35525a(-2, -1);
    }

    /* renamed from: e */
    public static final FrameLayout.LayoutParams m35521e() {
        return m35525a(-2, -2);
    }

    /* renamed from: f */
    public static final int m35520f(float f, Resources resources) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
