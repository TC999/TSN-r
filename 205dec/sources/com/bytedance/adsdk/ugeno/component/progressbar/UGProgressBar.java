package com.bytedance.adsdk.ugeno.component.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import j0.d;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class UGProgressBar extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private d f26188a;

    /* renamed from: b  reason: collision with root package name */
    private View f26189b;

    /* renamed from: c  reason: collision with root package name */
    private View f26190c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26191d;

    /* renamed from: e  reason: collision with root package name */
    private int f26192e;

    public UGProgressBar(Context context) {
        super(context);
        b(context);
    }

    private int a(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i4, size) : i4;
    }

    private void b(Context context) {
        this.f26189b = new View(context);
        this.f26190c = new View(context);
        addView(this.f26189b);
        addView(this.f26190c);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26189b.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.f26189b.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f26190c.getLayoutParams();
        layoutParams2.width = this.f26192e;
        layoutParams2.gravity = 5;
        this.f26190c.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.f26191d = textView;
        textView.setTextColor(-1);
        this.f26191d.setTextSize(16.0f);
        this.f26191d.setGravity(17);
        addView(this.f26191d);
    }

    public void c(d dVar) {
        this.f26188a = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f26188a;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f26188a;
        if (dVar != null) {
            dVar.r();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        d dVar = this.f26188a;
        if (dVar != null) {
            dVar.c(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        d dVar = this.f26188a;
        if (dVar != null) {
            dVar.c(i4, i5, i6, i7);
        }
        super.onLayout(z3, i4, i5, i6, i7);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        d dVar = this.f26188a;
        if (dVar != null) {
            dVar.c(i4, i5);
        }
        super.onMeasure(i4, i5);
        this.f26192e = a(0, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f26192e = i4;
    }

    public void setProgress(float f4) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26189b.getLayoutParams();
        float f5 = width;
        float f6 = (f4 / 100.0f) * f5;
        layoutParams.width = (int) f6;
        this.f26189b.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f26190c.getLayoutParams();
        layoutParams2.width = (int) (f5 - f6);
        this.f26190c.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f26191d.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setProgressBgColor(int i4) {
        this.f26190c.setBackgroundColor(i4);
    }

    public void setProgressColor(int i4) {
        this.f26189b.setBackgroundColor(i4);
    }

    public void setText(String str) {
        this.f26191d.setText(str);
    }

    public void setTextColor(int i4) {
        this.f26191d.setTextColor(i4);
    }
}
