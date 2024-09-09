package com.github.barteksc.pdfviewer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.util.b;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.SizeF;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: DragPinchManager.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class e implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private PDFView f37223a;

    /* renamed from: b  reason: collision with root package name */
    private a f37224b;

    /* renamed from: c  reason: collision with root package name */
    private GestureDetector f37225c;

    /* renamed from: d  reason: collision with root package name */
    private ScaleGestureDetector f37226d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f37227e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37228f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f37229g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PDFView pDFView, a aVar) {
        this.f37223a = pDFView;
        this.f37224b = aVar;
        this.f37225c = new GestureDetector(pDFView.getContext(), this);
        this.f37226d = new ScaleGestureDetector(pDFView.getContext(), this);
        pDFView.setOnTouchListener(this);
    }

    private boolean a(float f4, float f5) {
        float abs = Math.abs(f4);
        float abs2 = Math.abs(f5);
        if (this.f37223a.Q()) {
            if (abs2 > abs) {
                return true;
            }
        } else if (abs > abs2) {
            return true;
        }
        return false;
    }

    private boolean b(float f4, float f5) {
        int r3;
        int m4;
        PDFView pDFView = this.f37223a;
        g gVar = pDFView.f37140h;
        if (gVar == null) {
            return false;
        }
        float f6 = (-pDFView.getCurrentXOffset()) + f4;
        float f7 = (-this.f37223a.getCurrentYOffset()) + f5;
        int j4 = gVar.j(this.f37223a.Q() ? f7 : f6, this.f37223a.getZoom());
        SizeF q3 = gVar.q(j4, this.f37223a.getZoom());
        if (this.f37223a.Q()) {
            m4 = (int) gVar.r(j4, this.f37223a.getZoom());
            r3 = (int) gVar.m(j4, this.f37223a.getZoom());
        } else {
            r3 = (int) gVar.r(j4, this.f37223a.getZoom());
            m4 = (int) gVar.m(j4, this.f37223a.getZoom());
        }
        int i4 = m4;
        int i5 = r3;
        for (PdfDocument.Link link : gVar.l(j4)) {
            RectF s3 = gVar.s(j4, i4, i5, (int) q3.b(), (int) q3.a(), link.a());
            s3.sort();
            if (s3.contains(f6, f7)) {
                this.f37223a.f37151s.a(new f1.a(f4, f5, f6, f7, s3, link));
                return true;
            }
        }
        return false;
    }

    private void f() {
        com.github.barteksc.pdfviewer.scroll.a scrollHandle = this.f37223a.getScrollHandle();
        if (scrollHandle == null || !scrollHandle.i()) {
            return;
        }
        scrollHandle.g();
    }

    private void g(float f4, float f5) {
        float f6;
        float f7;
        int currentXOffset = (int) this.f37223a.getCurrentXOffset();
        int currentYOffset = (int) this.f37223a.getCurrentYOffset();
        PDFView pDFView = this.f37223a;
        g gVar = pDFView.f37140h;
        float f8 = -gVar.m(pDFView.getCurrentPage(), this.f37223a.getZoom());
        float k4 = f8 - gVar.k(this.f37223a.getCurrentPage(), this.f37223a.getZoom());
        float f9 = 0.0f;
        if (this.f37223a.Q()) {
            f7 = -(this.f37223a.p0(gVar.h()) - this.f37223a.getWidth());
            f6 = k4 + this.f37223a.getHeight();
            f9 = f8;
            f8 = 0.0f;
        } else {
            float width = k4 + this.f37223a.getWidth();
            f6 = -(this.f37223a.p0(gVar.f()) - this.f37223a.getHeight());
            f7 = width;
        }
        this.f37224b.g(currentXOffset, currentYOffset, (int) f4, (int) f5, (int) f7, (int) f8, (int) f6, (int) f9);
    }

    private void h(MotionEvent motionEvent) {
        this.f37223a.Z();
        f();
        if (this.f37224b.f()) {
            return;
        }
        this.f37223a.g0();
    }

    private void i(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        float x3;
        float x4;
        if (a(f4, f5)) {
            int i4 = -1;
            if (!this.f37223a.Q() ? f4 <= 0.0f : f5 <= 0.0f) {
                i4 = 1;
            }
            if (this.f37223a.Q()) {
                x3 = motionEvent2.getY();
                x4 = motionEvent.getY();
            } else {
                x3 = motionEvent2.getX();
                x4 = motionEvent.getX();
            }
            float f6 = x3 - x4;
            int max = Math.max(0, Math.min(this.f37223a.getPageCount() - 1, this.f37223a.u(this.f37223a.getCurrentXOffset() - (this.f37223a.getZoom() * f6), this.f37223a.getCurrentYOffset() - (f6 * this.f37223a.getZoom())) + i4));
            this.f37224b.h(-this.f37223a.n0(max, this.f37223a.v(max)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f37229g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f37225c.setIsLongpressEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f37229g = true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f37223a.K()) {
            if (this.f37223a.getZoom() < this.f37223a.getMidZoom()) {
                this.f37223a.w0(motionEvent.getX(), motionEvent.getY(), this.f37223a.getMidZoom());
                return true;
            } else if (this.f37223a.getZoom() < this.f37223a.getMaxZoom()) {
                this.f37223a.w0(motionEvent.getX(), motionEvent.getY(), this.f37223a.getMaxZoom());
                return true;
            } else {
                this.f37223a.k0();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f37224b.m();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        float f6;
        float p02;
        int height;
        if (this.f37223a.P()) {
            if (this.f37223a.M()) {
                if (this.f37223a.f0()) {
                    g(f4, f5);
                } else {
                    i(motionEvent, motionEvent2, f4, f5);
                }
                return true;
            }
            int currentXOffset = (int) this.f37223a.getCurrentXOffset();
            int currentYOffset = (int) this.f37223a.getCurrentYOffset();
            PDFView pDFView = this.f37223a;
            g gVar = pDFView.f37140h;
            if (pDFView.Q()) {
                f6 = -(this.f37223a.p0(gVar.h()) - this.f37223a.getWidth());
                p02 = gVar.e(this.f37223a.getZoom());
                height = this.f37223a.getHeight();
            } else {
                f6 = -(gVar.e(this.f37223a.getZoom()) - this.f37223a.getWidth());
                p02 = this.f37223a.p0(gVar.f());
                height = this.f37223a.getHeight();
            }
            this.f37224b.g(currentXOffset, currentYOffset, (int) f4, (int) f5, (int) f6, 0, (int) (-(p02 - height)), 0);
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f37223a.f37151s.c(motionEvent);
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float zoom = this.f37223a.getZoom() * scaleFactor;
        float min = Math.min(b.C0545b.f37310b, this.f37223a.getMinZoom());
        float min2 = Math.min(b.C0545b.f37309a, this.f37223a.getMaxZoom());
        if (zoom < min) {
            scaleFactor = min / this.f37223a.getZoom();
        } else if (zoom > min2) {
            scaleFactor = min2 / this.f37223a.getZoom();
        }
        this.f37223a.s0(scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f37228f = true;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f37223a.Z();
        f();
        this.f37228f = false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        this.f37227e = true;
        if (this.f37223a.R() || this.f37223a.P()) {
            this.f37223a.a0(-f4, -f5);
        }
        if (!this.f37228f || this.f37223a.m()) {
            this.f37223a.Y();
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        com.github.barteksc.pdfviewer.scroll.a scrollHandle;
        boolean h4 = this.f37223a.f37151s.h(motionEvent);
        boolean b4 = b(motionEvent.getX(), motionEvent.getY());
        if (!h4 && !b4 && (scrollHandle = this.f37223a.getScrollHandle()) != null && !this.f37223a.n()) {
            if (!scrollHandle.i()) {
                scrollHandle.show();
            } else {
                scrollHandle.f();
            }
        }
        this.f37223a.performClick();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f37229g) {
            boolean z3 = this.f37225c.onTouchEvent(motionEvent) || this.f37226d.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1 && this.f37227e) {
                this.f37227e = false;
                h(motionEvent);
            }
            return z3;
        }
        return false;
    }
}
