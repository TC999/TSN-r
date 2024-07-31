package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* renamed from: com.amap.api.col.3l.w */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ZoomOutGestureDetectorAbstract extends AbstractTwoFingerGestureDetector {

    /* renamed from: C */
    private static final PointF f5572C = new PointF();

    /* renamed from: A */
    private PointF f5573A;

    /* renamed from: B */
    private PointF f5574B;

    /* renamed from: w */
    private final InterfaceC1975a f5575w;

    /* renamed from: x */
    private boolean f5576x;

    /* renamed from: y */
    private PointF f5577y;

    /* renamed from: z */
    private PointF f5578z;

    /* compiled from: ZoomOutGestureDetectorAbstract.java */
    /* renamed from: com.amap.api.col.3l.w$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1975a {
        /* renamed from: a */
        void mo53624a(ZoomOutGestureDetectorAbstract zoomOutGestureDetectorAbstract);
    }

    /* compiled from: ZoomOutGestureDetectorAbstract.java */
    /* renamed from: com.amap.api.col.3l.w$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1976b implements InterfaceC1975a {
        @Override // com.amap.api.col.p0463l.ZoomOutGestureDetectorAbstract.InterfaceC1975a
        /* renamed from: a */
        public void mo53624a(ZoomOutGestureDetectorAbstract zoomOutGestureDetectorAbstract) {
        }
    }

    public ZoomOutGestureDetectorAbstract(Context context, InterfaceC1975a interfaceC1975a) {
        super(context);
        this.f5573A = new PointF();
        this.f5574B = new PointF();
        this.f5575w = interfaceC1975a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: a */
    public final void mo53630a() {
        super.mo53630a();
        this.f5576x = false;
        PointF pointF = this.f5573A;
        pointF.x = 0.0f;
        PointF pointF2 = this.f5574B;
        pointF2.x = 0.0f;
        pointF.y = 0.0f;
        pointF2.y = 0.0f;
    }

    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: c */
    protected final void mo53629c(int i, MotionEvent motionEvent) {
        if (i == 3) {
            mo53630a();
        } else if (i != 6) {
        } else {
            mo53627e(motionEvent);
            if (!this.f5576x) {
                this.f5575w.mo53624a(this);
            }
            mo53630a();
        }
    }

    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: d */
    protected final void mo53628d(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i != 5) {
            return;
        }
        mo53630a();
        this.f5139c = MotionEvent.obtain(motionEvent);
        this.f5143g = 0L;
        mo53627e(motionEvent);
        boolean m54157l = m54157l(motionEvent, i2, i3);
        this.f5576x = m54157l;
        if (m54157l) {
            return;
        }
        this.f5138b = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.AbstractTwoFingerGestureDetector, com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: e */
    public final void mo53627e(MotionEvent motionEvent) {
        PointF pointF;
        super.mo53627e(motionEvent);
        MotionEvent motionEvent2 = this.f5139c;
        this.f5577y = BaseGestureDetector.m54089g(motionEvent);
        this.f5578z = BaseGestureDetector.m54089g(motionEvent2);
        if (this.f5139c.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = f5572C;
        } else {
            PointF pointF2 = this.f5577y;
            float f = pointF2.x;
            PointF pointF3 = this.f5578z;
            pointF = new PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f5574B = pointF;
        PointF pointF4 = this.f5573A;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }

    /* renamed from: n */
    public final float m53626n() {
        return this.f5573A.x;
    }

    /* renamed from: o */
    public final float m53625o() {
        return this.f5573A.y;
    }
}
