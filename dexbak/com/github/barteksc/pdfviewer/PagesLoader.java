package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.util.C6663b;
import com.github.barteksc.pdfviewer.util.C6668f;
import com.github.barteksc.pdfviewer.util.MathUtils;
import com.shockwave.pdfium.util.SizeF;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.github.barteksc.pdfviewer.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PagesLoader {

    /* renamed from: a */
    private PDFView f23661a;

    /* renamed from: b */
    private int f23662b;

    /* renamed from: c */
    private float f23663c;

    /* renamed from: d */
    private float f23664d;

    /* renamed from: e */
    private float f23665e;

    /* renamed from: f */
    private float f23666f;

    /* renamed from: g */
    private float f23667g;

    /* renamed from: h */
    private float f23668h;

    /* renamed from: i */
    private final RectF f23669i = new RectF(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: j */
    private final int f23670j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PagesLoader.java */
    /* renamed from: com.github.barteksc.pdfviewer.f$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6656b {

        /* renamed from: a */
        int f23671a;

        /* renamed from: b */
        int f23672b;

        private C6656b() {
        }

        public String toString() {
            return "GridSize{rows=" + this.f23671a + ", cols=" + this.f23672b + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PagesLoader.java */
    /* renamed from: com.github.barteksc.pdfviewer.f$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6657c {

        /* renamed from: a */
        int f23674a;

        /* renamed from: b */
        int f23675b;

        private C6657c() {
        }

        public String toString() {
            return "Holder{row=" + this.f23674a + ", col=" + this.f23675b + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PagesLoader.java */
    /* renamed from: com.github.barteksc.pdfviewer.f$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6658d {

        /* renamed from: a */
        int f23677a = 0;

        /* renamed from: b */
        C6656b f23678b;

        /* renamed from: c */
        C6657c f23679c;

        /* renamed from: d */
        C6657c f23680d;

        C6658d() {
            this.f23678b = new C6656b();
            this.f23679c = new C6657c();
            this.f23680d = new C6657c();
        }

        public String toString() {
            return "RenderRange{page=" + this.f23677a + ", gridSize=" + this.f23678b + ", leftTop=" + this.f23679c + ", rightBottom=" + this.f23680d + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PagesLoader(PDFView pDFView) {
        this.f23661a = pDFView;
        this.f23670j = C6668f.m35294a(pDFView.getContext(), C6663b.f23737d);
    }

    /* renamed from: a */
    private void m35361a(C6656b c6656b) {
        float f = 1.0f / c6656b.f23672b;
        this.f23665e = f;
        float f2 = 1.0f / c6656b.f23671a;
        this.f23666f = f2;
        float f3 = C6663b.f23736c;
        this.f23667g = f3 / f;
        this.f23668h = f3 / f2;
    }

    /* renamed from: b */
    private void m35360b(C6656b c6656b, int i) {
        SizeF m35339n = this.f23661a.f23568h.m35339n(i);
        float m19712a = (C6663b.f23736c * (1.0f / m35339n.m19712a())) / this.f23661a.getZoom();
        float m19711b = (C6663b.f23736c * (1.0f / m35339n.m19711b())) / this.f23661a.getZoom();
        c6656b.f23671a = MathUtils.m35309a(1.0f / m19712a);
        c6656b.f23672b = MathUtils.m35309a(1.0f / m19711b);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0190  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.github.barteksc.pdfviewer.PagesLoader.C6658d> m35359c(float r20, float r21, float r22, float r23) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PagesLoader.m35359c(float, float, float, float):java.util.List");
    }

    /* renamed from: d */
    private boolean m35358d(int i, int i2, int i3, float f, float f2) {
        float f3 = i3 * f;
        float f4 = i2 * f2;
        float f5 = this.f23667g;
        float f6 = this.f23668h;
        float f7 = f3 + f > 1.0f ? 1.0f - f3 : f;
        float f8 = f4 + f2 > 1.0f ? 1.0f - f4 : f2;
        float f9 = f5 * f7;
        float f10 = f6 * f8;
        RectF rectF = new RectF(f3, f4, f7 + f3, f8 + f4);
        if (f9 <= 0.0f || f10 <= 0.0f) {
            return false;
        }
        if (!this.f23661a.f23565e.m35375k(i, rectF, this.f23662b)) {
            PDFView pDFView = this.f23661a;
            pDFView.f23577q.m35325b(i, f9, f10, rectF, false, this.f23662b, pDFView.m35493J(), this.f23661a.m35496G());
        }
        this.f23662b++;
        return true;
    }

    /* renamed from: e */
    private int m35357e(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        while (i2 <= i3) {
            for (int i8 = i4; i8 <= i5; i8++) {
                if (m35358d(i, i2, i8, this.f23665e, this.f23666f)) {
                    i7++;
                }
                if (i7 >= i6) {
                    return i7;
                }
            }
            i2++;
        }
        return i7;
    }

    /* renamed from: g */
    private void m35355g(int i) {
        SizeF m35339n = this.f23661a.f23568h.m35339n(i);
        float m19711b = m35339n.m19711b() * C6663b.f23735b;
        float m19712a = m35339n.m19712a() * C6663b.f23735b;
        if (this.f23661a.f23565e.m35382d(i, this.f23669i)) {
            return;
        }
        PDFView pDFView = this.f23661a;
        pDFView.f23577q.m35325b(i, m19711b, m19712a, this.f23669i, true, 0, pDFView.m35493J(), this.f23661a.m35496G());
    }

    /* renamed from: h */
    private void m35354h() {
        float f = this.f23670j;
        float f2 = this.f23663c;
        float f3 = this.f23664d;
        List<C6658d> m35359c = m35359c((-f2) + f, (-f3) + f, ((-f2) - this.f23661a.getWidth()) - f, ((-f3) - this.f23661a.getHeight()) - f);
        for (C6658d c6658d : m35359c) {
            m35355g(c6658d.f23677a);
        }
        int i = 0;
        for (C6658d c6658d2 : m35359c) {
            m35361a(c6658d2.f23678b);
            int i2 = c6658d2.f23677a;
            C6657c c6657c = c6658d2.f23679c;
            int i3 = c6657c.f23674a;
            C6657c c6657c2 = c6658d2.f23680d;
            i += m35357e(i2, i3, c6657c2.f23674a, c6657c.f23675b, c6657c2.f23675b, C6663b.C6664a.f23738a - i);
            if (i >= C6663b.C6664a.f23738a) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public void m35356f() {
        this.f23662b = 1;
        this.f23663c = -MathUtils.m35305e(this.f23661a.getCurrentXOffset(), 0.0f);
        this.f23664d = -MathUtils.m35305e(this.f23661a.getCurrentYOffset(), 0.0f);
        m35354h();
    }
}
