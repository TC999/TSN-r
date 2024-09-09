package com.bytedance.adsdk.ugeno.component.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.ScrollView;
import j0.d;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class UGScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private d f26212a;

    public UGScrollView(Context context) {
        super(context);
    }

    public void a(d dVar) {
        this.f26212a = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f26212a;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f26212a;
        if (dVar != null) {
            dVar.r();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        d dVar = this.f26212a;
        if (dVar != null) {
            dVar.c(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        d dVar = this.f26212a;
        if (dVar != null) {
            dVar.c(i4, i5, i6, i7);
        }
        super.onLayout(z3, i4, i5, i6, i7);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        d dVar = this.f26212a;
        if (dVar != null) {
            int[] c4 = dVar.c(i4, i5);
            super.onMeasure(c4[0], c4[1]);
        } else {
            super.onMeasure(i4, i5);
        }
        super.onMeasure(i4, i5);
    }
}
