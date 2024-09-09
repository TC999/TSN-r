package com.bytedance.adsdk.ugeno.component.frame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.w.h;
import j0.d;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class UGFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private d f26132a;

    /* renamed from: b  reason: collision with root package name */
    private Map<Integer, h> f26133b;

    public UGFrameLayout(Context context) {
        super(context);
    }

    public void a(d dVar) {
        this.f26132a = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f26132a;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f26132a;
        if (dVar != null) {
            dVar.r();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        d dVar = this.f26132a;
        if (dVar != null) {
            dVar.c(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, h> map = this.f26133b;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        d dVar = this.f26132a;
        if (dVar != null) {
            dVar.ux();
        }
        super.onLayout(z3, i4, i5, i6, i7);
        d dVar2 = this.f26132a;
        if (dVar2 != null) {
            dVar2.c(i4, i5, i6, i7);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        d dVar = this.f26132a;
        if (dVar != null) {
            int[] c4 = dVar.c(i4, i5);
            super.onMeasure(c4[0], c4[1]);
        } else {
            super.onMeasure(i4, i5);
        }
        d dVar2 = this.f26132a;
        if (dVar2 != null) {
            dVar2.sr();
        }
    }

    public void setEventMap(Map<Integer, h> map) {
        this.f26133b = map;
    }
}
