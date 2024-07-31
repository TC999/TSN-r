package com.acse.ottn.banner.p037b;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.acse.ottn.banner.config.IndicatorConfig;
import com.google.android.material.badge.BadgeDrawable;

/* renamed from: com.acse.ottn.banner.b.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1448a extends View implements InterfaceC1450c {

    /* renamed from: a */
    protected IndicatorConfig f2645a;

    /* renamed from: b */
    protected Paint f2646b;

    /* renamed from: c */
    protected float f2647c;

    public C1448a(Context context) {
        this(context, null);
    }

    public C1448a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1448a(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2645a = new IndicatorConfig();
        Paint paint = new Paint();
        this.f2646b = paint;
        paint.setAntiAlias(true);
        this.f2646b.setColor(this.f2645a.m56717g());
    }

    @Override // com.acse.ottn.banner.p037b.InterfaceC1450c
    /* renamed from: a */
    public void mo56733a(int i, int i2) {
        this.f2645a.m56722d(i);
        this.f2645a.m56730a(i2);
        requestLayout();
    }

    @Override // com.acse.ottn.banner.p037b.InterfaceC1450c
    public IndicatorConfig getIndicatorConfig() {
        return this.f2645a;
    }

    @Override // com.acse.ottn.banner.p037b.InterfaceC1450c
    @NonNull
    public View getIndicatorView() {
        int i;
        if (this.f2645a.m56708l()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int m56727b = this.f2645a.m56727b();
            if (m56727b == 0) {
                i = BadgeDrawable.BOTTOM_START;
            } else if (m56727b != 1) {
                if (m56727b == 2) {
                    i = BadgeDrawable.BOTTOM_END;
                }
                layoutParams.leftMargin = this.f2645a.m56719f().leftMargin;
                layoutParams.rightMargin = this.f2645a.m56719f().rightMargin;
                layoutParams.topMargin = this.f2645a.m56719f().topMargin;
                layoutParams.bottomMargin = this.f2645a.m56719f().bottomMargin;
                setLayoutParams(layoutParams);
            } else {
                i = 81;
            }
            layoutParams.gravity = i;
            layoutParams.leftMargin = this.f2645a.m56719f().leftMargin;
            layoutParams.rightMargin = this.f2645a.m56719f().rightMargin;
            layoutParams.topMargin = this.f2645a.m56719f().topMargin;
            layoutParams.bottomMargin = this.f2645a.m56719f().bottomMargin;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    @Override // com.acse.ottn.banner.p039d.InterfaceC1456b
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.acse.ottn.banner.p039d.InterfaceC1456b
    public void onPageScrolled(int i, float f, int i2) {
        this.f2647c = f;
        invalidate();
    }

    @Override // com.acse.ottn.banner.p039d.InterfaceC1456b
    public void onPageSelected(int i) {
        this.f2645a.m56730a(i);
        invalidate();
    }
}
