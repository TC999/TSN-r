package com.github.barteksc.pdfviewer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.github.barteksc.pdfviewer.util.C6663b;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.SizeF;
import p616l0.LinkTapEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.github.barteksc.pdfviewer.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class DragPinchManager implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* renamed from: a */
    private PDFView f23654a;

    /* renamed from: b */
    private AnimationManager f23655b;

    /* renamed from: c */
    private GestureDetector f23656c;

    /* renamed from: d */
    private ScaleGestureDetector f23657d;

    /* renamed from: e */
    private boolean f23658e = false;

    /* renamed from: f */
    private boolean f23659f = false;

    /* renamed from: g */
    private boolean f23660g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DragPinchManager(PDFView pDFView, AnimationManager animationManager) {
        this.f23654a = pDFView;
        this.f23655b = animationManager;
        this.f23656c = new GestureDetector(pDFView.getContext(), this);
        this.f23657d = new ScaleGestureDetector(pDFView.getContext(), this);
        pDFView.setOnTouchListener(this);
    }

    /* renamed from: a */
    private boolean m35370a(float f, float f2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (this.f23654a.m35486Q()) {
            if (abs2 > abs) {
                return true;
            }
        } else if (abs > abs2) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m35369b(float f, float f2) {
        int m35335r;
        int m35340m;
        PDFView pDFView = this.f23654a;
        PdfFile pdfFile = pDFView.f23568h;
        if (pdfFile == null) {
            return false;
        }
        float f3 = (-pDFView.getCurrentXOffset()) + f;
        float f4 = (-this.f23654a.getCurrentYOffset()) + f2;
        int m35343j = pdfFile.m35343j(this.f23654a.m35486Q() ? f4 : f3, this.f23654a.getZoom());
        SizeF m35336q = pdfFile.m35336q(m35343j, this.f23654a.getZoom());
        if (this.f23654a.m35486Q()) {
            m35340m = (int) pdfFile.m35335r(m35343j, this.f23654a.getZoom());
            m35335r = (int) pdfFile.m35340m(m35343j, this.f23654a.getZoom());
        } else {
            m35335r = (int) pdfFile.m35335r(m35343j, this.f23654a.getZoom());
            m35340m = (int) pdfFile.m35340m(m35343j, this.f23654a.getZoom());
        }
        int i = m35340m;
        int i2 = m35335r;
        for (PdfDocument.Link link : pdfFile.m35341l(m35343j)) {
            RectF m35334s = pdfFile.m35334s(m35343j, i, i2, (int) m35336q.m19711b(), (int) m35336q.m19712a(), link.m19749a());
            m35334s.sort();
            if (m35334s.contains(f3, f4)) {
                this.f23654a.f23579s.m12657a(new LinkTapEvent(f, f2, f3, f4, m35334s, link));
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m35365f() {
        ScrollHandle scrollHandle = this.f23654a.getScrollHandle();
        if (scrollHandle == null || !scrollHandle.mo35315i()) {
            return;
        }
        scrollHandle.mo35317g();
    }

    /* renamed from: g */
    private void m35364g(float f, float f2) {
        float f3;
        float f4;
        int currentXOffset = (int) this.f23654a.getCurrentXOffset();
        int currentYOffset = (int) this.f23654a.getCurrentYOffset();
        PDFView pDFView = this.f23654a;
        PdfFile pdfFile = pDFView.f23568h;
        float f5 = -pdfFile.m35340m(pDFView.getCurrentPage(), this.f23654a.getZoom());
        float m35342k = f5 - pdfFile.m35342k(this.f23654a.getCurrentPage(), this.f23654a.getZoom());
        float f6 = 0.0f;
        if (this.f23654a.m35486Q()) {
            f4 = -(this.f23654a.m35445p0(pdfFile.m35345h()) - this.f23654a.getWidth());
            f3 = m35342k + this.f23654a.getHeight();
            f6 = f5;
            f5 = 0.0f;
        } else {
            float width = m35342k + this.f23654a.getWidth();
            f3 = -(this.f23654a.m35445p0(pdfFile.m35347f()) - this.f23654a.getHeight());
            f4 = width;
        }
        this.f23655b.m35392g(currentXOffset, currentYOffset, (int) f, (int) f2, (int) f4, (int) f5, (int) f3, (int) f6);
    }

    /* renamed from: h */
    private void m35363h(MotionEvent motionEvent) {
        this.f23654a.m35477Z();
        m35365f();
        if (this.f23655b.m35393f()) {
            return;
        }
        this.f23654a.m35463g0();
    }

    /* renamed from: i */
    private void m35362i(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x;
        float x2;
        if (m35370a(f, f2)) {
            int i = -1;
            if (!this.f23654a.m35486Q() ? f <= 0.0f : f2 <= 0.0f) {
                i = 1;
            }
            if (this.f23654a.m35486Q()) {
                x = motionEvent2.getY();
                x2 = motionEvent.getY();
            } else {
                x = motionEvent2.getX();
                x2 = motionEvent.getX();
            }
            float f3 = x - x2;
            int max = Math.max(0, Math.min(this.f23654a.getPageCount() - 1, this.f23654a.m35436u(this.f23654a.getCurrentXOffset() - (this.f23654a.getZoom() * f3), this.f23654a.getCurrentYOffset() - (f3 * this.f23654a.getZoom())) + i));
            this.f23655b.m35391h(-this.f23654a.m35449n0(max, this.f23654a.m35434v(max)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m35368c() {
        this.f23660g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m35367d() {
        this.f23656c.setIsLongpressEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m35366e() {
        this.f23660g = true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f23654a.m35492K()) {
            if (this.f23654a.getZoom() < this.f23654a.getMidZoom()) {
                this.f23654a.m35431w0(motionEvent.getX(), motionEvent.getY(), this.f23654a.getMidZoom());
                return true;
            } else if (this.f23654a.getZoom() < this.f23654a.getMaxZoom()) {
                this.f23654a.m35431w0(motionEvent.getX(), motionEvent.getY(), this.f23654a.getMaxZoom());
                return true;
            } else {
                this.f23654a.m35455k0();
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
        this.f23655b.m35386m();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float m35445p0;
        int height;
        if (this.f23654a.m35487P()) {
            if (this.f23654a.m35490M()) {
                if (this.f23654a.m35465f0()) {
                    m35364g(f, f2);
                } else {
                    m35362i(motionEvent, motionEvent2, f, f2);
                }
                return true;
            }
            int currentXOffset = (int) this.f23654a.getCurrentXOffset();
            int currentYOffset = (int) this.f23654a.getCurrentYOffset();
            PDFView pDFView = this.f23654a;
            PdfFile pdfFile = pDFView.f23568h;
            if (pDFView.m35486Q()) {
                f3 = -(this.f23654a.m35445p0(pdfFile.m35345h()) - this.f23654a.getWidth());
                m35445p0 = pdfFile.m35348e(this.f23654a.getZoom());
                height = this.f23654a.getHeight();
            } else {
                f3 = -(pdfFile.m35348e(this.f23654a.getZoom()) - this.f23654a.getWidth());
                m35445p0 = this.f23654a.m35445p0(pdfFile.m35347f());
                height = this.f23654a.getHeight();
            }
            this.f23655b.m35392g(currentXOffset, currentYOffset, (int) f, (int) f2, (int) f3, 0, (int) (-(m35445p0 - height)), 0);
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f23654a.f23579s.m12655c(motionEvent);
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float zoom = this.f23654a.getZoom() * scaleFactor;
        float min = Math.min(C6663b.C6665b.f23741b, this.f23654a.getMinZoom());
        float min2 = Math.min(C6663b.C6665b.f23740a, this.f23654a.getMaxZoom());
        if (zoom < min) {
            scaleFactor = min / this.f23654a.getZoom();
        } else if (zoom > min2) {
            scaleFactor = min2 / this.f23654a.getZoom();
        }
        this.f23654a.m35439s0(scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f23659f = true;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f23654a.m35477Z();
        m35365f();
        this.f23659f = false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f23658e = true;
        if (this.f23654a.m35485R() || this.f23654a.m35487P()) {
            this.f23654a.m35475a0(-f, -f2);
        }
        if (!this.f23659f || this.f23654a.m35452m()) {
            this.f23654a.m35478Y();
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        ScrollHandle scrollHandle;
        boolean m12650h = this.f23654a.f23579s.m12650h(motionEvent);
        boolean m35369b = m35369b(motionEvent.getX(), motionEvent.getY());
        if (!m12650h && !m35369b && (scrollHandle = this.f23654a.getScrollHandle()) != null && !this.f23654a.m35450n()) {
            if (!scrollHandle.mo35315i()) {
                scrollHandle.show();
            } else {
                scrollHandle.mo35318f();
            }
        }
        this.f23654a.performClick();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f23660g) {
            boolean z = this.f23656c.onTouchEvent(motionEvent) || this.f23657d.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1 && this.f23658e) {
                this.f23658e = false;
                m35363h(motionEvent);
            }
            return z;
        }
        return false;
    }
}
