package com.qq.e.comm.plugin.util;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n1 {
    public static ShapeDrawable a(float f4, int i4, int i5) {
        return a(f4, f4, f4, f4, i4, i5);
    }

    public static ShapeDrawable a(float f4, float f5, float f6, float f7, int i4, int i5) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f4, f4, f5, f5, f6, f6, f7, f7}, null, null));
        shapeDrawable.getPaint().setColor(i4);
        shapeDrawable.getPaint().setAlpha(i5);
        return shapeDrawable;
    }
}
