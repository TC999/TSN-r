package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MoveGestureDetector.java */
/* renamed from: com.amap.api.col.3l.t  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t extends r {

    /* renamed from: o  reason: collision with root package name */
    private static final PointF f8974o = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private final a f8975j;

    /* renamed from: k  reason: collision with root package name */
    private PointF f8976k;

    /* renamed from: l  reason: collision with root package name */
    private PointF f8977l;

    /* renamed from: m  reason: collision with root package name */
    private PointF f8978m;

    /* renamed from: n  reason: collision with root package name */
    private PointF f8979n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MoveGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.t$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        boolean a(t tVar);

        void b(t tVar);

        boolean c(t tVar);
    }

    public t(Context context, a aVar) {
        super(context);
        this.f8978m = new PointF();
        this.f8979n = new PointF();
        this.f8975j = aVar;
    }

    @Override // com.amap.api.col.p0003l.r
    protected final void c(int i4, MotionEvent motionEvent) {
        if (i4 != 1) {
            if (i4 == 2) {
                e(motionEvent);
                if (this.f8847e / this.f8848f <= 0.67f || motionEvent.getPointerCount() > 1 || !this.f8975j.c(this)) {
                    return;
                }
                this.f8845c.recycle();
                this.f8845c = MotionEvent.obtain(motionEvent);
                return;
            } else if (i4 != 3) {
                return;
            }
        }
        this.f8975j.b(this);
        a();
    }

    @Override // com.amap.api.col.p0003l.r
    protected final void d(int i4, MotionEvent motionEvent, int i5, int i6) {
        if (i4 == 0) {
            a();
            this.f8845c = MotionEvent.obtain(motionEvent);
            this.f8849g = 0L;
            e(motionEvent);
        } else if (i4 == 2) {
            this.f8844b = this.f8975j.a(this);
        } else if (i4 != 5) {
        } else {
            MotionEvent motionEvent2 = this.f8845c;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.f8845c = MotionEvent.obtain(motionEvent);
            e(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003l.r
    public final void e(MotionEvent motionEvent) {
        PointF pointF;
        super.e(motionEvent);
        MotionEvent motionEvent2 = this.f8845c;
        this.f8976k = r.g(motionEvent);
        this.f8977l = r.g(motionEvent2);
        boolean z3 = this.f8845c.getPointerCount() != motionEvent.getPointerCount();
        if (z3) {
            pointF = f8974o;
        } else {
            PointF pointF2 = this.f8976k;
            float f4 = pointF2.x;
            PointF pointF3 = this.f8977l;
            pointF = new PointF(f4 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f8979n = pointF;
        if (z3) {
            this.f8845c.recycle();
            this.f8845c = MotionEvent.obtain(motionEvent);
        }
        PointF pointF4 = this.f8978m;
        float f5 = pointF4.x;
        PointF pointF5 = this.f8979n;
        pointF4.x = f5 + pointF5.x;
        pointF4.y += pointF5.y;
    }

    public final PointF j() {
        return this.f8979n;
    }
}
