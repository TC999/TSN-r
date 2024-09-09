package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.util.b;
import com.shockwave.pdfium.util.SizeF;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: PagesLoader.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private PDFView f37230a;

    /* renamed from: b  reason: collision with root package name */
    private int f37231b;

    /* renamed from: c  reason: collision with root package name */
    private float f37232c;

    /* renamed from: d  reason: collision with root package name */
    private float f37233d;

    /* renamed from: e  reason: collision with root package name */
    private float f37234e;

    /* renamed from: f  reason: collision with root package name */
    private float f37235f;

    /* renamed from: g  reason: collision with root package name */
    private float f37236g;

    /* renamed from: h  reason: collision with root package name */
    private float f37237h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f37238i = new RectF(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: j  reason: collision with root package name */
    private final int f37239j;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: PagesLoader.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f37240a;

        /* renamed from: b  reason: collision with root package name */
        int f37241b;

        private b() {
        }

        public String toString() {
            return "GridSize{rows=" + this.f37240a + ", cols=" + this.f37241b + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: PagesLoader.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        int f37243a;

        /* renamed from: b  reason: collision with root package name */
        int f37244b;

        private c() {
        }

        public String toString() {
            return "Holder{row=" + this.f37243a + ", col=" + this.f37244b + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: PagesLoader.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        int f37246a = 0;

        /* renamed from: b  reason: collision with root package name */
        b f37247b;

        /* renamed from: c  reason: collision with root package name */
        c f37248c;

        /* renamed from: d  reason: collision with root package name */
        c f37249d;

        d() {
            this.f37247b = new b();
            this.f37248c = new c();
            this.f37249d = new c();
        }

        public String toString() {
            return "RenderRange{page=" + this.f37246a + ", gridSize=" + this.f37247b + ", leftTop=" + this.f37248c + ", rightBottom=" + this.f37249d + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PDFView pDFView) {
        this.f37230a = pDFView;
        this.f37239j = com.github.barteksc.pdfviewer.util.f.a(pDFView.getContext(), com.github.barteksc.pdfviewer.util.b.f37306d);
    }

    private void a(b bVar) {
        float f4 = 1.0f / bVar.f37241b;
        this.f37234e = f4;
        float f5 = 1.0f / bVar.f37240a;
        this.f37235f = f5;
        float f6 = com.github.barteksc.pdfviewer.util.b.f37305c;
        this.f37236g = f6 / f4;
        this.f37237h = f6 / f5;
    }

    private void b(b bVar, int i4) {
        SizeF n4 = this.f37230a.f37140h.n(i4);
        float a4 = (com.github.barteksc.pdfviewer.util.b.f37305c * (1.0f / n4.a())) / this.f37230a.getZoom();
        float b4 = (com.github.barteksc.pdfviewer.util.b.f37305c * (1.0f / n4.b())) / this.f37230a.getZoom();
        bVar.f37240a = com.github.barteksc.pdfviewer.util.d.a(1.0f / a4);
        bVar.f37241b = com.github.barteksc.pdfviewer.util.d.a(1.0f / b4);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.github.barteksc.pdfviewer.f.d> c(float r20, float r21, float r22, float r23) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.f.c(float, float, float, float):java.util.List");
    }

    private boolean d(int i4, int i5, int i6, float f4, float f5) {
        float f6 = i6 * f4;
        float f7 = i5 * f5;
        float f8 = this.f37236g;
        float f9 = this.f37237h;
        float f10 = f6 + f4 > 1.0f ? 1.0f - f6 : f4;
        float f11 = f7 + f5 > 1.0f ? 1.0f - f7 : f5;
        float f12 = f8 * f10;
        float f13 = f9 * f11;
        RectF rectF = new RectF(f6, f7, f10 + f6, f11 + f7);
        if (f12 <= 0.0f || f13 <= 0.0f) {
            return false;
        }
        if (!this.f37230a.f37137e.k(i4, rectF, this.f37231b)) {
            PDFView pDFView = this.f37230a;
            pDFView.f37149q.b(i4, f12, f13, rectF, false, this.f37231b, pDFView.J(), this.f37230a.G());
        }
        this.f37231b++;
        return true;
    }

    private int e(int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = 0;
        while (i5 <= i6) {
            for (int i11 = i7; i11 <= i8; i11++) {
                if (d(i4, i5, i11, this.f37234e, this.f37235f)) {
                    i10++;
                }
                if (i10 >= i9) {
                    return i10;
                }
            }
            i5++;
        }
        return i10;
    }

    private void g(int i4) {
        SizeF n4 = this.f37230a.f37140h.n(i4);
        float b4 = n4.b() * com.github.barteksc.pdfviewer.util.b.f37304b;
        float a4 = n4.a() * com.github.barteksc.pdfviewer.util.b.f37304b;
        if (this.f37230a.f37137e.d(i4, this.f37238i)) {
            return;
        }
        PDFView pDFView = this.f37230a;
        pDFView.f37149q.b(i4, b4, a4, this.f37238i, true, 0, pDFView.J(), this.f37230a.G());
    }

    private void h() {
        float f4 = this.f37239j;
        float f5 = this.f37232c;
        float f6 = this.f37233d;
        List<d> c4 = c((-f5) + f4, (-f6) + f4, ((-f5) - this.f37230a.getWidth()) - f4, ((-f6) - this.f37230a.getHeight()) - f4);
        for (d dVar : c4) {
            g(dVar.f37246a);
        }
        int i4 = 0;
        for (d dVar2 : c4) {
            a(dVar2.f37247b);
            int i5 = dVar2.f37246a;
            c cVar = dVar2.f37248c;
            int i6 = cVar.f37243a;
            c cVar2 = dVar2.f37249d;
            i4 += e(i5, i6, cVar2.f37243a, cVar.f37244b, cVar2.f37244b, b.a.f37307a - i4);
            if (i4 >= b.a.f37307a) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f37231b = 1;
        this.f37232c = -com.github.barteksc.pdfviewer.util.d.e(this.f37230a.getCurrentXOffset(), 0.0f);
        this.f37233d = -com.github.barteksc.pdfviewer.util.d.e(this.f37230a.getCurrentYOffset(), 0.0f);
        h();
    }
}
