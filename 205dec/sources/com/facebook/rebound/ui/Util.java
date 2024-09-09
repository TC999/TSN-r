package com.facebook.rebound.ui;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class Util {
    public static final FrameLayout.LayoutParams a(int i4, int i5) {
        return new FrameLayout.LayoutParams(i4, i5);
    }

    public static final FrameLayout.LayoutParams b() {
        return a(-1, -1);
    }

    public static final FrameLayout.LayoutParams c() {
        return a(-1, -2);
    }

    public static final FrameLayout.LayoutParams d() {
        return a(-2, -1);
    }

    public static final FrameLayout.LayoutParams e() {
        return a(-2, -2);
    }

    public static final int f(float f4, Resources resources) {
        return (int) TypedValue.applyDimension(1, f4, resources.getDisplayMetrics());
    }
}
