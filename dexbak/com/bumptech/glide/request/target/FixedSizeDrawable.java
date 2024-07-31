package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.util.C3770j;

/* renamed from: com.bumptech.glide.request.target.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FixedSizeDrawable extends Drawable {

    /* renamed from: a */
    private final Matrix f14465a;

    /* renamed from: b */
    private final RectF f14466b;

    /* renamed from: c */
    private final RectF f14467c;

    /* renamed from: d */
    private Drawable f14468d;

    /* renamed from: e */
    private C3751a f14469e;

    /* renamed from: f */
    private boolean f14470f;

    /* compiled from: FixedSizeDrawable.java */
    /* renamed from: com.bumptech.glide.request.target.i$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static final class C3751a extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f14471a;

        /* renamed from: b */
        final int f14472b;

        /* renamed from: c */
        final int f14473c;

        C3751a(C3751a c3751a) {
            this(c3751a.f14471a, c3751a.f14472b, c3751a.f14473c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.f14471a.newDrawable());
        }

        C3751a(Drawable.ConstantState constantState, int i, int i2) {
            this.f14471a = constantState;
            this.f14472b = i;
            this.f14473c = i2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new FixedSizeDrawable(this, this.f14471a.newDrawable(resources));
        }
    }

    public FixedSizeDrawable(Drawable drawable, int i, int i2) {
        this(new C3751a(drawable.getConstantState(), i, i2), drawable);
    }

    /* renamed from: a */
    private void m44488a() {
        this.f14465a.setRectToRect(this.f14466b, this.f14467c, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f14468d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.f14465a);
        this.f14468d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
    public int getAlpha() {
        return this.f14468d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.f14468d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f14468d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f14469e;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f14468d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f14469e.f14473c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f14469e.f14472b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f14468d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f14468d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f14468d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f14468d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f14468d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f14470f && super.mutate() == this) {
            this.f14468d = this.f14468d.mutate();
            this.f14469e = new C3751a(this.f14469e);
            this.f14470f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(@NonNull Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f14468d.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f14468d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f14467c.set(i, i2, i3, i4);
        m44488a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f14468d.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.f14468d.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.f14468d.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f14468d.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f14468d.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f14468d.unscheduleSelf(runnable);
    }

    FixedSizeDrawable(C3751a c3751a, Drawable drawable) {
        this.f14469e = (C3751a) C3770j.m44392d(c3751a);
        this.f14468d = (Drawable) C3770j.m44392d(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f14465a = new Matrix();
        this.f14466b = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f14467c = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f14468d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        this.f14467c.set(rect);
        m44488a();
    }
}
