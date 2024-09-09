package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ShadowDrawableWrapper extends DrawableWrapper {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;
    @NonNull
    final RectF contentBounds;
    float cornerRadius;
    @NonNull
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty;
    @NonNull
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f4, float f5, float f6) {
        super(drawable);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = Math.round(f4);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(paint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f5, f6);
    }

    private void buildComponents(@NonNull Rect rect) {
        float f4 = this.rawMaxShadowSize;
        float f5 = 1.5f * f4;
        this.contentBounds.set(rect.left + f4, rect.top + f5, rect.right - f4, rect.bottom - f5);
        Drawable wrappedDrawable = getWrappedDrawable();
        RectF rectF = this.contentBounds;
        wrappedDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f4 = this.cornerRadius;
        RectF rectF = new RectF(-f4, -f4, f4, f4);
        RectF rectF2 = new RectF(rectF);
        float f5 = this.shadowSize;
        rectF2.inset(-f5, -f5);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f6 = -rectF2.top;
        if (f6 > 0.0f) {
            float f7 = this.cornerRadius / f6;
            this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f7, ((1.0f - f7) / 2.0f) + f7, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f4, float f5, boolean z3) {
        if (z3) {
            double d4 = f4;
            double d5 = f5;
            Double.isNaN(d5);
            Double.isNaN(d4);
            return (float) (d4 + ((1.0d - COS_45) * d5));
        }
        return f4;
    }

    public static float calculateVerticalPadding(float f4, float f5, boolean z3) {
        if (z3) {
            double d4 = f4 * 1.5f;
            double d5 = f5;
            Double.isNaN(d5);
            Double.isNaN(d4);
            return (float) (d4 + ((1.0d - COS_45) * d5));
        }
        return f4 * 1.5f;
    }

    private void drawShadow(@NonNull Canvas canvas) {
        int i4;
        float f4;
        int i5;
        float f5;
        float f6;
        float f7;
        int save = canvas.save();
        canvas.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f8 = this.cornerRadius;
        float f9 = (-f8) - this.shadowSize;
        float f10 = f8 * 2.0f;
        boolean z3 = this.contentBounds.width() - f10 > 0.0f;
        boolean z4 = this.contentBounds.height() - f10 > 0.0f;
        float f11 = this.rawShadowSize;
        float f12 = f8 / ((f11 - (0.5f * f11)) + f8);
        float f13 = f8 / ((f11 - (0.25f * f11)) + f8);
        float f14 = f8 / ((f11 - (f11 * 1.0f)) + f8);
        int save2 = canvas.save();
        RectF rectF = this.contentBounds;
        canvas.translate(rectF.left + f8, rectF.top + f8);
        canvas.scale(f12, f13);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z3) {
            canvas.scale(1.0f / f12, 1.0f);
            i4 = save2;
            f4 = f14;
            i5 = save;
            f5 = f13;
            canvas.drawRect(0.0f, f9, this.contentBounds.width() - f10, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            i4 = save2;
            f4 = f14;
            i5 = save;
            f5 = f13;
        }
        canvas.restoreToCount(i4);
        int save3 = canvas.save();
        RectF rectF2 = this.contentBounds;
        canvas.translate(rectF2.right - f8, rectF2.bottom - f8);
        float f15 = f4;
        canvas.scale(f12, f15);
        canvas.rotate(180.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z3) {
            canvas.scale(1.0f / f12, 1.0f);
            f6 = f5;
            f7 = f15;
            canvas.drawRect(0.0f, f9, this.contentBounds.width() - f10, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
        } else {
            f6 = f5;
            f7 = f15;
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.contentBounds;
        canvas.translate(rectF3.left + f8, rectF3.bottom - f8);
        canvas.scale(f12, f7);
        canvas.rotate(270.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z4) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f9, this.contentBounds.height() - f10, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.contentBounds;
        canvas.translate(rectF4.right - f8, rectF4.top + f8);
        float f16 = f6;
        canvas.scale(f12, f16);
        canvas.rotate(90.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z4) {
            canvas.scale(1.0f / f16, 1.0f);
            canvas.drawRect(0.0f, f9, this.contentBounds.height() - f10, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(i5);
    }

    private static int toEven(float f4) {
        int round = Math.round(f4);
        return round % 2 == 1 ? round - 1 : round;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float f4 = this.rawMaxShadowSize;
        return (Math.max(f4, this.cornerRadius + ((f4 * 1.5f) / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 1.5f * 2.0f);
    }

    public float getMinWidth() {
        float f4 = this.rawMaxShadowSize;
        return (Math.max(f4, this.cornerRadius + (f4 / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean z3) {
        this.addPaddingForCorners = z3;
        invalidateSelf();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        super.setAlpha(i4);
        this.cornerShadowPaint.setAlpha(i4);
        this.edgeShadowPaint.setAlpha(i4);
    }

    public void setCornerRadius(float f4) {
        float round = Math.round(f4);
        if (this.cornerRadius == round) {
            return;
        }
        this.cornerRadius = round;
        this.dirty = true;
        invalidateSelf();
    }

    public void setMaxShadowSize(float f4) {
        setShadowSize(this.rawShadowSize, f4);
    }

    public final void setRotation(float f4) {
        if (this.rotation != f4) {
            this.rotation = f4;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f4, float f5) {
        if (f4 >= 0.0f && f5 >= 0.0f) {
            float even = toEven(f4);
            float even2 = toEven(f5);
            if (even > even2) {
                if (!this.printedShadowClipWarning) {
                    this.printedShadowClipWarning = true;
                }
                even = even2;
            }
            if (this.rawShadowSize == even && this.rawMaxShadowSize == even2) {
                return;
            }
            this.rawShadowSize = even;
            this.rawMaxShadowSize = even2;
            this.shadowSize = Math.round(even * 1.5f);
            this.maxShadowSize = even2;
            this.dirty = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("invalid shadow size");
    }

    public void setShadowSize(float f4) {
        setShadowSize(f4, this.rawMaxShadowSize);
    }
}
