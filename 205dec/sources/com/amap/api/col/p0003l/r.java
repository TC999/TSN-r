package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseGestureDetector.java */
/* renamed from: com.amap.api.col.3l.r  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f8843a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f8844b;

    /* renamed from: c  reason: collision with root package name */
    protected MotionEvent f8845c;

    /* renamed from: d  reason: collision with root package name */
    protected MotionEvent f8846d;

    /* renamed from: e  reason: collision with root package name */
    protected float f8847e;

    /* renamed from: f  reason: collision with root package name */
    protected float f8848f;

    /* renamed from: g  reason: collision with root package name */
    protected long f8849g;

    /* renamed from: h  reason: collision with root package name */
    protected int f8850h = 0;

    /* renamed from: i  reason: collision with root package name */
    protected int f8851i = 0;

    public r(Context context) {
        this.f8843a = context;
    }

    public static PointF g(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < pointerCount; i4++) {
            f4 += motionEvent.getX(i4);
            f5 += motionEvent.getY(i4);
        }
        float f6 = pointerCount;
        return new PointF(f4 / f6, f5 / f6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        MotionEvent motionEvent = this.f8845c;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f8845c = null;
        }
        MotionEvent motionEvent2 = this.f8846d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f8846d = null;
        }
        this.f8844b = false;
    }

    public final void b(int i4, int i5) {
        this.f8850h = i4;
        this.f8851i = i5;
    }

    protected abstract void c(int i4, MotionEvent motionEvent);

    protected abstract void d(int i4, MotionEvent motionEvent, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f8845c;
        MotionEvent motionEvent3 = this.f8846d;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.f8846d = null;
        }
        this.f8846d = MotionEvent.obtain(motionEvent);
        this.f8849g = motionEvent.getEventTime() - motionEvent2.getEventTime();
        this.f8847e = motionEvent.getPressure(motionEvent.getActionIndex());
        this.f8848f = motionEvent2.getPressure(motionEvent2.getActionIndex());
    }

    public final long f() {
        return this.f8849g;
    }

    public final boolean h(MotionEvent motionEvent, int i4, int i5) {
        int action = motionEvent.getAction() & 255;
        if (!this.f8844b) {
            d(action, motionEvent, i4, i5);
            return true;
        }
        c(action, motionEvent);
        return true;
    }

    public final MotionEvent i() {
        return this.f8846d;
    }
}
