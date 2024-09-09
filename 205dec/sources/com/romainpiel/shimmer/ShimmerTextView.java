package com.romainpiel.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.romainpiel.shimmer.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ShimmerTextView extends TextView implements c {

    /* renamed from: a  reason: collision with root package name */
    private d f47423a;

    public ShimmerTextView(Context context) {
        super(context);
        d dVar = new d(this, getPaint(), null);
        this.f47423a = dVar;
        dVar.l(getCurrentTextColor());
    }

    @Override // com.romainpiel.shimmer.c
    public boolean a() {
        return this.f47423a.f();
    }

    @Override // com.romainpiel.shimmer.c
    public boolean b() {
        return this.f47423a.e();
    }

    @Override // com.romainpiel.shimmer.c
    public float getGradientX() {
        return this.f47423a.a();
    }

    @Override // com.romainpiel.shimmer.c
    public int getPrimaryColor() {
        return this.f47423a.b();
    }

    @Override // com.romainpiel.shimmer.c
    public int getReflectionColor() {
        return this.f47423a.c();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        d dVar = this.f47423a;
        if (dVar != null) {
            dVar.g();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        d dVar = this.f47423a;
        if (dVar != null) {
            dVar.h();
        }
    }

    @Override // com.romainpiel.shimmer.c
    public void setAnimationSetupCallback(d.a aVar) {
        this.f47423a.j(aVar);
    }

    @Override // com.romainpiel.shimmer.c
    public void setGradientX(float f4) {
        this.f47423a.k(f4);
    }

    @Override // com.romainpiel.shimmer.c
    public void setPrimaryColor(int i4) {
        this.f47423a.l(i4);
    }

    @Override // com.romainpiel.shimmer.c
    public void setReflectionColor(int i4) {
        this.f47423a.m(i4);
    }

    @Override // com.romainpiel.shimmer.c
    public void setShimmering(boolean z3) {
        this.f47423a.n(z3);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i4) {
        super.setTextColor(i4);
        d dVar = this.f47423a;
        if (dVar != null) {
            dVar.l(getCurrentTextColor());
        }
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d dVar = new d(this, getPaint(), attributeSet);
        this.f47423a = dVar;
        dVar.l(getCurrentTextColor());
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        d dVar = this.f47423a;
        if (dVar != null) {
            dVar.l(getCurrentTextColor());
        }
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        d dVar = new d(this, getPaint(), attributeSet);
        this.f47423a = dVar;
        dVar.l(getCurrentTextColor());
    }
}