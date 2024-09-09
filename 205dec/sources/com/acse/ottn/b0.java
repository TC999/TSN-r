package com.acse.ottn;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b0 extends View implements n1 {

    /* renamed from: a  reason: collision with root package name */
    public o1 f5163a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f5164b;

    /* renamed from: c  reason: collision with root package name */
    public float f5165c;

    public b0(Context context) {
        this(context, null);
    }

    @Override // com.acse.ottn.n1
    public void a(int i4, int i5) {
        this.f5163a.d(i4);
        this.f5163a.a(i5);
        requestLayout();
    }

    @Override // com.acse.ottn.n1
    public o1 getIndicatorConfig() {
        return this.f5163a;
    }

    @Override // com.acse.ottn.n1
    @NonNull
    public View getIndicatorView() {
        if (this.f5163a.l()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int b4 = this.f5163a.b();
            if (b4 == 0) {
                layoutParams.gravity = 8388691;
            } else if (b4 == 1) {
                layoutParams.gravity = 81;
            } else if (b4 == 2) {
                layoutParams.gravity = 8388693;
            }
            layoutParams.leftMargin = this.f5163a.f().f6092a;
            layoutParams.rightMargin = this.f5163a.f().f6094c;
            layoutParams.topMargin = this.f5163a.f().f6093b;
            layoutParams.bottomMargin = this.f5163a.f().f6095d;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    @Override // com.acse.ottn.s2
    public void onPageScrollStateChanged(int i4) {
    }

    @Override // com.acse.ottn.s2
    public void onPageScrolled(int i4, float f4, int i5) {
        this.f5165c = f4;
        invalidate();
    }

    @Override // com.acse.ottn.s2
    public void onPageSelected(int i4) {
        this.f5163a.a(i4);
        invalidate();
    }

    public b0(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b0(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5163a = new o1();
        Paint paint = new Paint();
        this.f5164b = paint;
        paint.setAntiAlias(true);
        this.f5164b.setColor(this.f5163a.g());
    }
}
