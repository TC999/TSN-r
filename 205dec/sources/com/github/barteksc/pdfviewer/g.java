package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseBooleanArray;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: PdfFile.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
class g {

    /* renamed from: t  reason: collision with root package name */
    private static final Object f37251t = new Object();

    /* renamed from: a  reason: collision with root package name */
    private PdfDocument f37252a;

    /* renamed from: b  reason: collision with root package name */
    private PdfiumCore f37253b;

    /* renamed from: k  reason: collision with root package name */
    private boolean f37262k;

    /* renamed from: l  reason: collision with root package name */
    private int f37263l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f37264m;

    /* renamed from: q  reason: collision with root package name */
    private final FitPolicy f37268q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f37269r;

    /* renamed from: s  reason: collision with root package name */
    private int[] f37270s;

    /* renamed from: c  reason: collision with root package name */
    private int f37254c = 0;

    /* renamed from: d  reason: collision with root package name */
    private List<Size> f37255d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<SizeF> f37256e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private SparseBooleanArray f37257f = new SparseBooleanArray();

    /* renamed from: g  reason: collision with root package name */
    private Size f37258g = new Size(0, 0);

    /* renamed from: h  reason: collision with root package name */
    private Size f37259h = new Size(0, 0);

    /* renamed from: i  reason: collision with root package name */
    private SizeF f37260i = new SizeF(0.0f, 0.0f);

    /* renamed from: j  reason: collision with root package name */
    private SizeF f37261j = new SizeF(0.0f, 0.0f);

    /* renamed from: n  reason: collision with root package name */
    private List<Float> f37265n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private List<Float> f37266o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private float f37267p = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PdfiumCore pdfiumCore, PdfDocument pdfDocument, FitPolicy fitPolicy, Size size, int[] iArr, boolean z3, int i4, boolean z4, boolean z5) {
        this.f37253b = pdfiumCore;
        this.f37252a = pdfDocument;
        this.f37268q = fitPolicy;
        this.f37270s = iArr;
        this.f37262k = z3;
        this.f37263l = i4;
        this.f37264m = z4;
        this.f37269r = z5;
        A(size);
    }

    private void A(Size size) {
        int[] iArr = this.f37270s;
        if (iArr != null) {
            this.f37254c = iArr.length;
        } else {
            this.f37254c = this.f37253b.d(this.f37252a);
        }
        for (int i4 = 0; i4 < this.f37254c; i4++) {
            Size h4 = this.f37253b.h(this.f37252a, c(i4));
            if (h4.b() > this.f37258g.b()) {
                this.f37258g = h4;
            }
            if (h4.a() > this.f37259h.a()) {
                this.f37259h = h4;
            }
            this.f37255d.add(h4);
        }
        y(size);
    }

    private void v(Size size) {
        float b4;
        float b5;
        this.f37266o.clear();
        for (int i4 = 0; i4 < p(); i4++) {
            SizeF sizeF = this.f37256e.get(i4);
            if (this.f37262k) {
                b4 = size.a();
                b5 = sizeF.a();
            } else {
                b4 = size.b();
                b5 = sizeF.b();
            }
            float max = Math.max(0.0f, b4 - b5);
            if (i4 < p() - 1) {
                max += this.f37263l;
            }
            this.f37266o.add(Float.valueOf(max));
        }
    }

    private void w() {
        float f4;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < p(); i4++) {
            SizeF sizeF = this.f37256e.get(i4);
            f5 += this.f37262k ? sizeF.a() : sizeF.b();
            if (this.f37264m) {
                f4 = this.f37266o.get(i4).floatValue();
            } else if (i4 < p() - 1) {
                f4 = this.f37263l;
            }
            f5 += f4;
        }
        this.f37267p = f5;
    }

    private void x() {
        float f4;
        this.f37265n.clear();
        float f5 = 0.0f;
        for (int i4 = 0; i4 < p(); i4++) {
            SizeF sizeF = this.f37256e.get(i4);
            float a4 = this.f37262k ? sizeF.a() : sizeF.b();
            if (this.f37264m) {
                f5 += this.f37266o.get(i4).floatValue() / 2.0f;
                if (i4 == 0) {
                    f5 -= this.f37263l / 2.0f;
                } else if (i4 == p() - 1) {
                    f5 += this.f37263l / 2.0f;
                }
                this.f37265n.add(Float.valueOf(f5));
                f4 = this.f37266o.get(i4).floatValue() / 2.0f;
            } else {
                this.f37265n.add(Float.valueOf(f5));
                f4 = this.f37263l;
            }
            f5 += a4 + f4;
        }
    }

    public int a(int i4) {
        int p3;
        if (i4 <= 0) {
            return 0;
        }
        int[] iArr = this.f37270s;
        if (iArr != null) {
            if (i4 >= iArr.length) {
                p3 = iArr.length;
                return p3 - 1;
            }
            return i4;
        }
        if (i4 >= p()) {
            p3 = p();
            return p3 - 1;
        }
        return i4;
    }

    public void b() {
        PdfDocument pdfDocument;
        PdfiumCore pdfiumCore = this.f37253b;
        if (pdfiumCore != null && (pdfDocument = this.f37252a) != null) {
            pdfiumCore.a(pdfDocument);
        }
        this.f37252a = null;
        this.f37270s = null;
    }

    public int c(int i4) {
        int i5;
        int[] iArr = this.f37270s;
        if (iArr == null) {
            i5 = i4;
        } else if (i4 < 0 || i4 >= iArr.length) {
            return -1;
        } else {
            i5 = iArr[i4];
        }
        if (i5 < 0 || i4 >= p()) {
            return -1;
        }
        return i5;
    }

    public List<PdfDocument.Bookmark> d() {
        PdfDocument pdfDocument = this.f37252a;
        if (pdfDocument == null) {
            return new ArrayList();
        }
        return this.f37253b.k(pdfDocument);
    }

    public float e(float f4) {
        return this.f37267p * f4;
    }

    public float f() {
        return g().a();
    }

    public SizeF g() {
        return this.f37262k ? this.f37261j : this.f37260i;
    }

    public float h() {
        return g().b();
    }

    public PdfDocument.Meta i() {
        PdfDocument pdfDocument = this.f37252a;
        if (pdfDocument == null) {
            return null;
        }
        return this.f37253b.b(pdfDocument);
    }

    public int j(float f4, float f5) {
        int i4 = 0;
        for (int i5 = 0; i5 < p() && (this.f37265n.get(i5).floatValue() * f5) - (o(i5, f5) / 2.0f) < f4; i5++) {
            i4++;
        }
        int i6 = i4 - 1;
        if (i6 >= 0) {
            return i6;
        }
        return 0;
    }

    public float k(int i4, float f4) {
        SizeF n4 = n(i4);
        return (this.f37262k ? n4.a() : n4.b()) * f4;
    }

    public List<PdfDocument.Link> l(int i4) {
        return this.f37253b.g(this.f37252a, c(i4));
    }

    public float m(int i4, float f4) {
        if (c(i4) < 0) {
            return 0.0f;
        }
        return this.f37265n.get(i4).floatValue() * f4;
    }

    public SizeF n(int i4) {
        if (c(i4) < 0) {
            return new SizeF(0.0f, 0.0f);
        }
        return this.f37256e.get(i4);
    }

    public float o(int i4, float f4) {
        return (this.f37264m ? this.f37266o.get(i4).floatValue() : this.f37263l) * f4;
    }

    public int p() {
        return this.f37254c;
    }

    public SizeF q(int i4, float f4) {
        SizeF n4 = n(i4);
        return new SizeF(n4.b() * f4, n4.a() * f4);
    }

    public float r(int i4, float f4) {
        float f5;
        float a4;
        SizeF n4 = n(i4);
        if (this.f37262k) {
            f5 = h();
            a4 = n4.b();
        } else {
            f5 = f();
            a4 = n4.a();
        }
        return (f4 * (f5 - a4)) / 2.0f;
    }

    public RectF s(int i4, int i5, int i6, int i7, int i8, RectF rectF) {
        return this.f37253b.m(this.f37252a, c(i4), i5, i6, i7, i8, 0, rectF);
    }

    public boolean t(int i4) throws PageRenderingException {
        int c4 = c(i4);
        if (c4 < 0) {
            return false;
        }
        synchronized (f37251t) {
            if (this.f37257f.indexOfKey(c4) < 0) {
                try {
                    this.f37253b.r(this.f37252a, c4);
                    this.f37257f.put(c4, true);
                    return true;
                } catch (Exception e4) {
                    this.f37257f.put(c4, false);
                    throw new PageRenderingException(i4, e4);
                }
            }
            return false;
        }
    }

    public boolean u(int i4) {
        return !this.f37257f.get(c(i4), false);
    }

    public void y(Size size) {
        this.f37256e.clear();
        com.github.barteksc.pdfviewer.util.e eVar = new com.github.barteksc.pdfviewer.util.e(this.f37268q, this.f37258g, this.f37259h, size, this.f37269r);
        this.f37261j = eVar.g();
        this.f37260i = eVar.f();
        for (Size size2 : this.f37255d) {
            this.f37256e.add(eVar.a(size2));
        }
        if (this.f37264m) {
            v(size);
        }
        w();
        x();
    }

    public void z(Bitmap bitmap, int i4, Rect rect, boolean z3) {
        this.f37253b.x(this.f37252a, bitmap, c(i4), rect.left, rect.top, rect.width(), rect.height(), z3);
    }
}
