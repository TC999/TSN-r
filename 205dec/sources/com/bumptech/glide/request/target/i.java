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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FixedSizeDrawable.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f17983a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f17984b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f17985c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f17986d;

    /* renamed from: e  reason: collision with root package name */
    private a f17987e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17988f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FixedSizeDrawable.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f17989a;

        /* renamed from: b  reason: collision with root package name */
        final int f17990b;

        /* renamed from: c  reason: collision with root package name */
        final int f17991c;

        a(a aVar) {
            this(aVar.f17989a, aVar.f17990b, aVar.f17991c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new i(this, this.f17989a.newDrawable());
        }

        a(Drawable.ConstantState constantState, int i4, int i5) {
            this.f17989a = constantState;
            this.f17990b = i4;
            this.f17991c = i5;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new i(this, this.f17989a.newDrawable(resources));
        }
    }

    public i(Drawable drawable, int i4, int i5) {
        this(new a(drawable.getConstantState(), i4, i5), drawable);
    }

    private void a() {
        this.f17983a.setRectToRect(this.f17984b, this.f17985c, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f17986d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.f17983a);
        this.f17986d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
    public int getAlpha() {
        return this.f17986d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.f17986d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f17986d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f17987e;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f17986d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f17987e.f17991c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f17987e.f17990b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f17986d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f17986d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f17986d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f17986d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f17986d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f17988f && super.mutate() == this) {
            this.f17986d = this.f17986d.mutate();
            this.f17987e = new a(this.f17987e);
            this.f17988f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(@NonNull Runnable runnable, long j4) {
        super.scheduleSelf(runnable, j4);
        this.f17986d.scheduleSelf(runnable, j4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f17986d.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i4, int i5, int i6, int i7) {
        super.setBounds(i4, i5, i6, i7);
        this.f17985c.set(i4, i5, i6, i7);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i4) {
        this.f17986d.setChangingConfigurations(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i4, @NonNull PorterDuff.Mode mode) {
        this.f17986d.setColorFilter(i4, mode);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z3) {
        this.f17986d.setDither(z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z3) {
        this.f17986d.setFilterBitmap(z3);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        return this.f17986d.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f17986d.unscheduleSelf(runnable);
    }

    i(a aVar, Drawable drawable) {
        this.f17987e = (a) com.bumptech.glide.util.j.d(aVar);
        this.f17986d = (Drawable) com.bumptech.glide.util.j.d(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f17983a = new Matrix();
        this.f17984b = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f17985c = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17986d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        this.f17985c.set(rect);
        a();
    }
}
