package com.acse.ottn.banner.b;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.acse.ottn.banner.config.IndicatorConfig;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a extends View implements c {

    /* renamed from: a  reason: collision with root package name */
    protected IndicatorConfig f5246a;

    /* renamed from: b  reason: collision with root package name */
    protected Paint f5247b;

    /* renamed from: c  reason: collision with root package name */
    protected float f5248c;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5246a = new IndicatorConfig();
        Paint paint = new Paint();
        this.f5247b = paint;
        paint.setAntiAlias(true);
        this.f5247b.setColor(this.f5246a.g());
    }

    @Override // com.acse.ottn.banner.b.c
    public void a(int i4, int i5) {
        this.f5246a.d(i4);
        this.f5246a.a(i5);
        requestLayout();
    }

    @Override // com.acse.ottn.banner.b.c
    public IndicatorConfig getIndicatorConfig() {
        return this.f5246a;
    }

    @Override // com.acse.ottn.banner.b.c
    @NonNull
    public View getIndicatorView() {
        int i4;
        if (this.f5246a.l()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int b4 = this.f5246a.b();
            if (b4 == 0) {
                i4 = 8388691;
            } else if (b4 != 1) {
                if (b4 == 2) {
                    i4 = 8388693;
                }
                layoutParams.leftMargin = this.f5246a.f().leftMargin;
                layoutParams.rightMargin = this.f5246a.f().rightMargin;
                layoutParams.topMargin = this.f5246a.f().topMargin;
                layoutParams.bottomMargin = this.f5246a.f().bottomMargin;
                setLayoutParams(layoutParams);
            } else {
                i4 = 81;
            }
            layoutParams.gravity = i4;
            layoutParams.leftMargin = this.f5246a.f().leftMargin;
            layoutParams.rightMargin = this.f5246a.f().rightMargin;
            layoutParams.topMargin = this.f5246a.f().topMargin;
            layoutParams.bottomMargin = this.f5246a.f().bottomMargin;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    @Override // com.acse.ottn.banner.d.b
    public void onPageScrollStateChanged(int i4) {
    }

    @Override // com.acse.ottn.banner.d.b
    public void onPageScrolled(int i4, float f4, int i5) {
        this.f5248c = f4;
        invalidate();
    }

    @Override // com.acse.ottn.banner.d.b
    public void onPageSelected(int i4) {
        this.f5246a.a(i4);
        invalidate();
    }
}
