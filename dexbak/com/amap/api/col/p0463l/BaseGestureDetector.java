package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* renamed from: com.amap.api.col.3l.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BaseGestureDetector {

    /* renamed from: a */
    protected final Context f5137a;

    /* renamed from: b */
    protected boolean f5138b;

    /* renamed from: c */
    protected MotionEvent f5139c;

    /* renamed from: d */
    protected MotionEvent f5140d;

    /* renamed from: e */
    protected float f5141e;

    /* renamed from: f */
    protected float f5142f;

    /* renamed from: g */
    protected long f5143g;

    /* renamed from: h */
    protected int f5144h = 0;

    /* renamed from: i */
    protected int f5145i = 0;

    public BaseGestureDetector(Context context) {
        this.f5137a = context;
    }

    /* renamed from: g */
    public static PointF m54089g(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            f += motionEvent.getX(i);
            f2 += motionEvent.getY(i);
        }
        float f3 = pointerCount;
        return new PointF(f / f3, f2 / f3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo53630a() {
        MotionEvent motionEvent = this.f5139c;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f5139c = null;
        }
        MotionEvent motionEvent2 = this.f5140d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f5140d = null;
        }
        this.f5138b = false;
    }

    /* renamed from: b */
    public final void m54091b(int i, int i2) {
        this.f5144h = i;
        this.f5145i = i2;
    }

    /* renamed from: c */
    protected abstract void mo53629c(int i, MotionEvent motionEvent);

    /* renamed from: d */
    protected abstract void mo53628d(int i, MotionEvent motionEvent, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public void mo53627e(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f5139c;
        MotionEvent motionEvent3 = this.f5140d;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.f5140d = null;
        }
        this.f5140d = MotionEvent.obtain(motionEvent);
        this.f5143g = motionEvent.getEventTime() - motionEvent2.getEventTime();
        this.f5141e = motionEvent.getPressure(motionEvent.getActionIndex());
        this.f5142f = motionEvent2.getPressure(motionEvent2.getActionIndex());
    }

    /* renamed from: f */
    public final long m54090f() {
        return this.f5143g;
    }

    /* renamed from: h */
    public final boolean m54088h(MotionEvent motionEvent, int i, int i2) {
        int action = motionEvent.getAction() & 255;
        if (!this.f5138b) {
            mo53628d(action, motionEvent, i, i2);
            return true;
        }
        mo53629c(action, motionEvent);
        return true;
    }

    /* renamed from: i */
    public final MotionEvent m54087i() {
        return this.f5140d;
    }
}
