package com.beizi.fusion.p072g;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;

/* renamed from: com.beizi.fusion.g.as */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ShapeUtil {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m48318a(View view, String str, int i, String str2, int i2) {
        view.setBackground(m48317a(str, i, str2, i2));
    }

    /* renamed from: a */
    private static Drawable m48317a(String str, int i, String str2, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00000000"));
        }
        if (i2 > 0) {
            gradientDrawable.setCornerRadius(i2);
        }
        if (i > 0 && !TextUtils.isEmpty(str2) && str2.startsWith("#")) {
            gradientDrawable.setStroke(i, Color.parseColor(str2));
        }
        return gradientDrawable;
    }
}
