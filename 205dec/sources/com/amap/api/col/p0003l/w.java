package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ZoomOutGestureDetectorAbstract.java */
/* renamed from: com.amap.api.col.3l.w  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class w extends q {
    private static final PointF C = new PointF();
    private PointF A;
    private PointF B;

    /* renamed from: w  reason: collision with root package name */
    private final a f9313w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f9314x;

    /* renamed from: y  reason: collision with root package name */
    private PointF f9315y;

    /* renamed from: z  reason: collision with root package name */
    private PointF f9316z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ZoomOutGestureDetectorAbstract.java */
    /* renamed from: com.amap.api.col.3l.w$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(w wVar);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ZoomOutGestureDetectorAbstract.java */
    /* renamed from: com.amap.api.col.3l.w$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b implements a {
        @Override // com.amap.api.col.p0003l.w.a
        public void a(w wVar) {
        }
    }

    public w(Context context, a aVar) {
        super(context);
        this.A = new PointF();
        this.B = new PointF();
        this.f9313w = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003l.r
    public final void a() {
        super.a();
        this.f9314x = false;
        PointF pointF = this.A;
        pointF.x = 0.0f;
        PointF pointF2 = this.B;
        pointF2.x = 0.0f;
        pointF.y = 0.0f;
        pointF2.y = 0.0f;
    }

    @Override // com.amap.api.col.p0003l.r
    protected final void c(int i4, MotionEvent motionEvent) {
        if (i4 == 3) {
            a();
        } else if (i4 != 6) {
        } else {
            e(motionEvent);
            if (!this.f9314x) {
                this.f9313w.a(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003l.r
    protected final void d(int i4, MotionEvent motionEvent, int i5, int i6) {
        if (i4 != 5) {
            return;
        }
        a();
        this.f8845c = MotionEvent.obtain(motionEvent);
        this.f8849g = 0L;
        e(motionEvent);
        boolean l4 = l(motionEvent, i5, i6);
        this.f9314x = l4;
        if (l4) {
            return;
        }
        this.f8844b = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003l.q, com.amap.api.col.p0003l.r
    public final void e(MotionEvent motionEvent) {
        PointF pointF;
        super.e(motionEvent);
        MotionEvent motionEvent2 = this.f8845c;
        this.f9315y = r.g(motionEvent);
        this.f9316z = r.g(motionEvent2);
        if (this.f8845c.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = C;
        } else {
            PointF pointF2 = this.f9315y;
            float f4 = pointF2.x;
            PointF pointF3 = this.f9316z;
            pointF = new PointF(f4 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.B = pointF;
        PointF pointF4 = this.A;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }

    public final float n() {
        return this.A.x;
    }

    public final float o() {
        return this.A.y;
    }
}
