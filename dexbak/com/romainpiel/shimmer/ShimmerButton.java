package com.romainpiel.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import com.romainpiel.shimmer.ShimmerViewHelper;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ShimmerButton extends Button implements ShimmerViewBase {

    /* renamed from: a */
    private ShimmerViewHelper f32963a;

    public ShimmerButton(Context context) {
        super(context);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), null);
        this.f32963a = shimmerViewHelper;
        shimmerViewHelper.m20266l(getCurrentTextColor());
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    /* renamed from: a */
    public boolean mo20279a() {
        return this.f32963a.m20272f();
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    /* renamed from: b */
    public boolean mo20278b() {
        return this.f32963a.m20273e();
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    public float getGradientX() {
        return this.f32963a.m20277a();
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    public int getPrimaryColor() {
        return this.f32963a.m20276b();
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    public int getReflectionColor() {
        return this.f32963a.m20275c();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        ShimmerViewHelper shimmerViewHelper = this.f32963a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.m20271g();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ShimmerViewHelper shimmerViewHelper = this.f32963a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.m20270h();
        }
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    public void setAnimationSetupCallback(ShimmerViewHelper.InterfaceC11839a interfaceC11839a) {
        this.f32963a.m20268j(interfaceC11839a);
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    public void setGradientX(float f) {
        this.f32963a.m20267k(f);
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    public void setPrimaryColor(int i) {
        this.f32963a.m20266l(i);
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    public void setReflectionColor(int i) {
        this.f32963a.m20265m(i);
    }

    @Override // com.romainpiel.shimmer.ShimmerViewBase
    public void setShimmering(boolean z) {
        this.f32963a.m20264n(z);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        ShimmerViewHelper shimmerViewHelper = this.f32963a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.m20266l(getCurrentTextColor());
        }
    }

    public ShimmerButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f32963a = shimmerViewHelper;
        shimmerViewHelper.m20266l(getCurrentTextColor());
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        ShimmerViewHelper shimmerViewHelper = this.f32963a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.m20266l(getCurrentTextColor());
        }
    }

    public ShimmerButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f32963a = shimmerViewHelper;
        shimmerViewHelper.m20266l(getCurrentTextColor());
    }
}
