package com.beizi.fusion.g;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ShapeUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class at {
    @SuppressLint({"NewApi"})
    public static void a(View view, String str, int i4, String str2, int i5) {
        view.setBackground(a(str, i4, str2, i5));
    }

    private static Drawable a(String str, int i4, String str2, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00000000"));
        }
        if (i5 > 0) {
            gradientDrawable.setCornerRadius(i5);
        }
        if (i4 > 0 && !TextUtils.isEmpty(str2) && str2.startsWith("#")) {
            gradientDrawable.setStroke(i4, Color.parseColor(str2));
        }
        return gradientDrawable;
    }
}
