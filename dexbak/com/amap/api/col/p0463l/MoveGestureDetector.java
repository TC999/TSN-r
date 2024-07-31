package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* renamed from: com.amap.api.col.3l.t */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MoveGestureDetector extends BaseGestureDetector {

    /* renamed from: o */
    private static final PointF f5331o = new PointF();

    /* renamed from: j */
    private final InterfaceC1943a f5332j;

    /* renamed from: k */
    private PointF f5333k;

    /* renamed from: l */
    private PointF f5334l;

    /* renamed from: m */
    private PointF f5335m;

    /* renamed from: n */
    private PointF f5336n;

    /* compiled from: MoveGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.t$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1943a {
        /* renamed from: a */
        boolean mo53901a(MoveGestureDetector moveGestureDetector);

        /* renamed from: b */
        void mo53900b(MoveGestureDetector moveGestureDetector);

        /* renamed from: c */
        boolean mo53899c(MoveGestureDetector moveGestureDetector);
    }

    public MoveGestureDetector(Context context, InterfaceC1943a interfaceC1943a) {
        super(context);
        this.f5335m = new PointF();
        this.f5336n = new PointF();
        this.f5332j = interfaceC1943a;
    }

    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: c */
    protected final void mo53629c(int i, MotionEvent motionEvent) {
        if (i != 1) {
            if (i == 2) {
                mo53627e(motionEvent);
                if (this.f5141e / this.f5142f <= 0.67f || motionEvent.getPointerCount() > 1 || !this.f5332j.mo53899c(this)) {
                    return;
                }
                this.f5139c.recycle();
                this.f5139c = MotionEvent.obtain(motionEvent);
                return;
            } else if (i != 3) {
                return;
            }
        }
        this.f5332j.mo53900b(this);
        mo53630a();
    }

    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: d */
    protected final void mo53628d(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i == 0) {
            mo53630a();
            this.f5139c = MotionEvent.obtain(motionEvent);
            this.f5143g = 0L;
            mo53627e(motionEvent);
        } else if (i == 2) {
            this.f5138b = this.f5332j.mo53901a(this);
        } else if (i != 5) {
        } else {
            MotionEvent motionEvent2 = this.f5139c;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.f5139c = MotionEvent.obtain(motionEvent);
            mo53627e(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: e */
    public final void mo53627e(MotionEvent motionEvent) {
        PointF pointF;
        super.mo53627e(motionEvent);
        MotionEvent motionEvent2 = this.f5139c;
        this.f5333k = BaseGestureDetector.m54089g(motionEvent);
        this.f5334l = BaseGestureDetector.m54089g(motionEvent2);
        boolean z = this.f5139c.getPointerCount() != motionEvent.getPointerCount();
        if (z) {
            pointF = f5331o;
        } else {
            PointF pointF2 = this.f5333k;
            float f = pointF2.x;
            PointF pointF3 = this.f5334l;
            pointF = new PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f5336n = pointF;
        if (z) {
            this.f5139c.recycle();
            this.f5139c = MotionEvent.obtain(motionEvent);
        }
        PointF pointF4 = this.f5335m;
        float f2 = pointF4.x;
        PointF pointF5 = this.f5336n;
        pointF4.x = f2 + pointF5.x;
        pointF4.y += pointF5.y;
    }

    /* renamed from: j */
    public final PointF m53902j() {
        return this.f5336n;
    }
}
