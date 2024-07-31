package com.beizi.p051ad.internal.utilities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;

/* renamed from: com.beizi.ad.internal.utilities.ShapeUtil */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ShapeUtil {
    private static Drawable createDrawable(String str, int i, String str2, int i2) {
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

    @SuppressLint({"NewApi"})
    public static void setViewBackGround(View view, String str, int i, String str2, int i2) {
        view.setBackground(createDrawable(str, i, str2, i2));
    }

    @SuppressLint({"NewApi"})
    public static void setViewBackGround(View view, String str, int i, String str2, float[] fArr) {
        view.setBackground(createDrawable(str, i, str2, fArr));
    }

    private static Drawable createDrawable(String str, int i, String str2, float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00000000"));
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (fArr[i2] >= 0.0f) {
                fArr2[i2] = fArr[i2];
            } else {
                fArr2[i2] = 0.0f;
            }
        }
        gradientDrawable.setCornerRadii(fArr2);
        if (i > 0 && !TextUtils.isEmpty(str2) && str2.startsWith("#")) {
            gradientDrawable.setStroke(i, Color.parseColor(str2));
        }
        return gradientDrawable;
    }
}
