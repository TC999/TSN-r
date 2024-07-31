package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* renamed from: com.amap.api.col.3l.s */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class HoverGestureDetectorAbstract extends AbstractTwoFingerGestureDetector {

    /* renamed from: C */
    private static final PointF f5207C = new PointF();

    /* renamed from: A */
    private PointF f5208A;

    /* renamed from: B */
    private PointF f5209B;

    /* renamed from: w */
    private final InterfaceC1935a f5210w;

    /* renamed from: x */
    private boolean f5211x;

    /* renamed from: y */
    private PointF f5212y;

    /* renamed from: z */
    private PointF f5213z;

    /* compiled from: HoverGestureDetectorAbstract.java */
    /* renamed from: com.amap.api.col.3l.s$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1935a {
        /* renamed from: a */
        void mo54017a(HoverGestureDetectorAbstract hoverGestureDetectorAbstract);

        /* renamed from: b */
        boolean mo54016b(HoverGestureDetectorAbstract hoverGestureDetectorAbstract);

        /* renamed from: c */
        boolean mo54015c(HoverGestureDetectorAbstract hoverGestureDetectorAbstract);
    }

    public HoverGestureDetectorAbstract(Context context, InterfaceC1935a interfaceC1935a) {
        super(context);
        this.f5208A = new PointF();
        this.f5209B = new PointF();
        this.f5210w = interfaceC1935a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: a */
    public final void mo53630a() {
        super.mo53630a();
        this.f5211x = false;
    }

    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: c */
    protected final void mo53629c(int i, MotionEvent motionEvent) {
        if (i == 2) {
            mo53627e(motionEvent);
            if (this.f5141e / this.f5142f <= 0.67f || !this.f5210w.mo54016b(this)) {
                return;
            }
            this.f5139c.recycle();
            this.f5139c = MotionEvent.obtain(motionEvent);
        } else if (i == 3) {
            if (!this.f5211x) {
                this.f5210w.mo54017a(this);
            }
            mo53630a();
        } else if (i != 6) {
        } else {
            mo53627e(motionEvent);
            if (!this.f5211x) {
                this.f5210w.mo54017a(this);
            }
            mo53630a();
        }
    }

    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: d */
    protected final void mo53628d(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i == 2) {
            if (this.f5211x) {
                boolean m54157l = m54157l(motionEvent, i2, i3);
                this.f5211x = m54157l;
                if (m54157l) {
                    return;
                }
                this.f5138b = this.f5210w.mo54015c(this);
            }
        } else if (i != 5) {
        } else {
            mo53630a();
            this.f5139c = MotionEvent.obtain(motionEvent);
            this.f5143g = 0L;
            mo53627e(motionEvent);
            boolean m54157l2 = m54157l(motionEvent, i2, i3);
            this.f5211x = m54157l2;
            if (m54157l2) {
                return;
            }
            this.f5138b = this.f5210w.mo54015c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.AbstractTwoFingerGestureDetector, com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: e */
    public final void mo53627e(MotionEvent motionEvent) {
        PointF pointF;
        super.mo53627e(motionEvent);
        MotionEvent motionEvent2 = this.f5139c;
        this.f5212y = BaseGestureDetector.m54089g(motionEvent);
        this.f5213z = BaseGestureDetector.m54089g(motionEvent2);
        if (this.f5139c.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = f5207C;
        } else {
            PointF pointF2 = this.f5212y;
            float f = pointF2.x;
            PointF pointF3 = this.f5213z;
            pointF = new PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f5209B = pointF;
        PointF pointF4 = this.f5208A;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }

    /* renamed from: n */
    public final PointF m54018n() {
        return this.f5209B;
    }
}
