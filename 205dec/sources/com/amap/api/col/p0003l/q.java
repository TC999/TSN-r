package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AbstractTwoFingerGestureDetector.java */
/* renamed from: com.amap.api.col.3l.q  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class q extends r {

    /* renamed from: j  reason: collision with root package name */
    private final float f8808j;

    /* renamed from: k  reason: collision with root package name */
    private float f8809k;

    /* renamed from: l  reason: collision with root package name */
    private float f8810l;

    /* renamed from: m  reason: collision with root package name */
    protected float f8811m;

    /* renamed from: n  reason: collision with root package name */
    protected float f8812n;

    /* renamed from: o  reason: collision with root package name */
    protected float f8813o;

    /* renamed from: p  reason: collision with root package name */
    protected float f8814p;

    /* renamed from: q  reason: collision with root package name */
    private float f8815q;

    /* renamed from: r  reason: collision with root package name */
    private float f8816r;

    /* renamed from: s  reason: collision with root package name */
    private float f8817s;

    /* renamed from: t  reason: collision with root package name */
    private float f8818t;

    /* renamed from: u  reason: collision with root package name */
    private float f8819u;

    /* renamed from: v  reason: collision with root package name */
    private float f8820v;

    public q(Context context) {
        super(context);
        this.f8817s = 0.0f;
        this.f8818t = 0.0f;
        this.f8819u = 0.0f;
        this.f8820v = 0.0f;
        this.f8808j = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    private static float j(MotionEvent motionEvent, int i4) {
        float x3 = (i4 + motionEvent.getX()) - motionEvent.getRawX();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getX(1) + x3;
        }
        return 0.0f;
    }

    private static float m(MotionEvent motionEvent, int i4) {
        float y3 = (i4 + motionEvent.getY()) - motionEvent.getRawY();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getY(1) + y3;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003l.r
    public void e(MotionEvent motionEvent) {
        super.e(motionEvent);
        MotionEvent motionEvent2 = this.f8845c;
        int pointerCount = motionEvent2.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.f8815q = -1.0f;
            this.f8816r = -1.0f;
            float x3 = motionEvent2.getX(0);
            float y3 = motionEvent2.getY(0);
            float x4 = motionEvent2.getX(1);
            float y4 = motionEvent2.getY(1);
            this.f8811m = x4 - x3;
            this.f8812n = y4 - y3;
            float x5 = motionEvent.getX(0);
            float y5 = motionEvent.getY(0);
            float x6 = motionEvent.getX(1);
            float y6 = motionEvent.getY(1);
            this.f8813o = x6 - x5;
            this.f8814p = y6 - y5;
            this.f8817s = x5 - x3;
            this.f8818t = y5 - y3;
            this.f8819u = x6 - x4;
            this.f8820v = y6 - y4;
        }
    }

    public final PointF k(int i4) {
        if (i4 == 0) {
            return new PointF(this.f8817s, this.f8818t);
        }
        return new PointF(this.f8819u, this.f8820v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean l(MotionEvent motionEvent, int i4, int i5) {
        int i6;
        int i7 = this.f8850h;
        if (i7 != 0 && (i6 = this.f8851i) != 0) {
            float f4 = this.f8808j;
            this.f8809k = i7 - f4;
            this.f8810l = i6 - f4;
        } else {
            DisplayMetrics displayMetrics = this.f8843a.getResources().getDisplayMetrics();
            float f5 = this.f8808j;
            this.f8809k = displayMetrics.widthPixels - f5;
            this.f8810l = displayMetrics.heightPixels - f5;
        }
        float f6 = this.f8808j;
        float f7 = this.f8809k;
        float f8 = this.f8810l;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float j4 = j(motionEvent, i4);
        float m4 = m(motionEvent, i5);
        boolean z3 = rawX < f6 || rawY < f6 || rawX > f7 || rawY > f8;
        boolean z4 = j4 < f6 || m4 < f6 || j4 > f7 || m4 > f8;
        return (z3 && z4) || z3 || z4;
    }
}
