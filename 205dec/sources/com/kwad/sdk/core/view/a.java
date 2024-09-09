package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends ImageSpan {
    public a(@NonNull Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(@NonNull Canvas canvas, CharSequence charSequence, int i4, int i5, float f4, int i6, int i7, int i8, @NonNull Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.translate(f4, (((i8 - i6) - drawable.getBounds().bottom) / 2) + i6);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(@NonNull Paint paint, CharSequence charSequence, int i4, int i5, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i6 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i7 = (bounds.bottom - bounds.top) / 2;
            int i8 = i6 / 4;
            int i9 = i7 - i8;
            int i10 = -(i7 + i8);
            fontMetricsInt.ascent = i10;
            fontMetricsInt.top = i10;
            fontMetricsInt.bottom = i9;
            fontMetricsInt.descent = i9;
        }
        return bounds.right;
    }
}
