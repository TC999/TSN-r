package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HoverGestureDetectorAbstract.java */
/* renamed from: com.amap.api.col.3l.s  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s extends q {
    private static final PointF C = new PointF();
    private PointF A;
    private PointF B;

    /* renamed from: w  reason: collision with root package name */
    private final a f8922w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f8923x;

    /* renamed from: y  reason: collision with root package name */
    private PointF f8924y;

    /* renamed from: z  reason: collision with root package name */
    private PointF f8925z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HoverGestureDetectorAbstract.java */
    /* renamed from: com.amap.api.col.3l.s$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(s sVar);

        boolean b(s sVar);

        boolean c(s sVar);
    }

    public s(Context context, a aVar) {
        super(context);
        this.A = new PointF();
        this.B = new PointF();
        this.f8922w = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003l.r
    public final void a() {
        super.a();
        this.f8923x = false;
    }

    @Override // com.amap.api.col.p0003l.r
    protected final void c(int i4, MotionEvent motionEvent) {
        if (i4 == 2) {
            e(motionEvent);
            if (this.f8847e / this.f8848f <= 0.67f || !this.f8922w.b(this)) {
                return;
            }
            this.f8845c.recycle();
            this.f8845c = MotionEvent.obtain(motionEvent);
        } else if (i4 == 3) {
            if (!this.f8923x) {
                this.f8922w.a(this);
            }
            a();
        } else if (i4 != 6) {
        } else {
            e(motionEvent);
            if (!this.f8923x) {
                this.f8922w.a(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003l.r
    protected final void d(int i4, MotionEvent motionEvent, int i5, int i6) {
        if (i4 == 2) {
            if (this.f8923x) {
                boolean l4 = l(motionEvent, i5, i6);
                this.f8923x = l4;
                if (l4) {
                    return;
                }
                this.f8844b = this.f8922w.c(this);
            }
        } else if (i4 != 5) {
        } else {
            a();
            this.f8845c = MotionEvent.obtain(motionEvent);
            this.f8849g = 0L;
            e(motionEvent);
            boolean l5 = l(motionEvent, i5, i6);
            this.f8923x = l5;
            if (l5) {
                return;
            }
            this.f8844b = this.f8922w.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003l.q, com.amap.api.col.p0003l.r
    public final void e(MotionEvent motionEvent) {
        PointF pointF;
        super.e(motionEvent);
        MotionEvent motionEvent2 = this.f8845c;
        this.f8924y = r.g(motionEvent);
        this.f8925z = r.g(motionEvent2);
        if (this.f8845c.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = C;
        } else {
            PointF pointF2 = this.f8924y;
            float f4 = pointF2.x;
            PointF pointF3 = this.f8925z;
            pointF = new PointF(f4 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.B = pointF;
        PointF pointF4 = this.A;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }

    public final PointF n() {
        return this.B;
    }
}
