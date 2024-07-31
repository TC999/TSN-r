package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseBooleanArray;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.PageSizeCalculator;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.barteksc.pdfviewer.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
class PdfFile {

    /* renamed from: t */
    private static final Object f23682t = new Object();

    /* renamed from: a */
    private PdfDocument f23683a;

    /* renamed from: b */
    private PdfiumCore f23684b;

    /* renamed from: k */
    private boolean f23693k;

    /* renamed from: l */
    private int f23694l;

    /* renamed from: m */
    private boolean f23695m;

    /* renamed from: q */
    private final FitPolicy f23699q;

    /* renamed from: r */
    private final boolean f23700r;

    /* renamed from: s */
    private int[] f23701s;

    /* renamed from: c */
    private int f23685c = 0;

    /* renamed from: d */
    private List<Size> f23686d = new ArrayList();

    /* renamed from: e */
    private List<SizeF> f23687e = new ArrayList();

    /* renamed from: f */
    private SparseBooleanArray f23688f = new SparseBooleanArray();

    /* renamed from: g */
    private Size f23689g = new Size(0, 0);

    /* renamed from: h */
    private Size f23690h = new Size(0, 0);

    /* renamed from: i */
    private SizeF f23691i = new SizeF(0.0f, 0.0f);

    /* renamed from: j */
    private SizeF f23692j = new SizeF(0.0f, 0.0f);

    /* renamed from: n */
    private List<Float> f23696n = new ArrayList();

    /* renamed from: o */
    private List<Float> f23697o = new ArrayList();

    /* renamed from: p */
    private float f23698p = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfFile(PdfiumCore pdfiumCore, PdfDocument pdfDocument, FitPolicy fitPolicy, Size size, int[] iArr, boolean z, int i, boolean z2, boolean z3) {
        this.f23684b = pdfiumCore;
        this.f23683a = pdfDocument;
        this.f23699q = fitPolicy;
        this.f23701s = iArr;
        this.f23693k = z;
        this.f23694l = i;
        this.f23695m = z2;
        this.f23700r = z3;
        m35353A(size);
    }

    /* renamed from: A */
    private void m35353A(Size size) {
        int[] iArr = this.f23701s;
        if (iArr != null) {
            this.f23685c = iArr.length;
        } else {
            this.f23685c = this.f23684b.m19735d(this.f23683a);
        }
        for (int i = 0; i < this.f23685c; i++) {
            Size m19731h = this.f23684b.m19731h(this.f23683a, m35350c(i));
            if (m19731h.m19713b() > this.f23689g.m19713b()) {
                this.f23689g = m19731h;
            }
            if (m19731h.m19714a() > this.f23690h.m19714a()) {
                this.f23690h = m19731h;
            }
            this.f23686d.add(m19731h);
        }
        m35328y(size);
    }

    /* renamed from: v */
    private void m35331v(Size size) {
        float m19713b;
        float m19711b;
        this.f23697o.clear();
        for (int i = 0; i < m35337p(); i++) {
            SizeF sizeF = this.f23687e.get(i);
            if (this.f23693k) {
                m19713b = size.m19714a();
                m19711b = sizeF.m19712a();
            } else {
                m19713b = size.m19713b();
                m19711b = sizeF.m19711b();
            }
            float max = Math.max(0.0f, m19713b - m19711b);
            if (i < m35337p() - 1) {
                max += this.f23694l;
            }
            this.f23697o.add(Float.valueOf(max));
        }
    }

    /* renamed from: w */
    private void m35330w() {
        float f;
        float f2 = 0.0f;
        for (int i = 0; i < m35337p(); i++) {
            SizeF sizeF = this.f23687e.get(i);
            f2 += this.f23693k ? sizeF.m19712a() : sizeF.m19711b();
            if (this.f23695m) {
                f = this.f23697o.get(i).floatValue();
            } else if (i < m35337p() - 1) {
                f = this.f23694l;
            }
            f2 += f;
        }
        this.f23698p = f2;
    }

    /* renamed from: x */
    private void m35329x() {
        float f;
        this.f23696n.clear();
        float f2 = 0.0f;
        for (int i = 0; i < m35337p(); i++) {
            SizeF sizeF = this.f23687e.get(i);
            float m19712a = this.f23693k ? sizeF.m19712a() : sizeF.m19711b();
            if (this.f23695m) {
                f2 += this.f23697o.get(i).floatValue() / 2.0f;
                if (i == 0) {
                    f2 -= this.f23694l / 2.0f;
                } else if (i == m35337p() - 1) {
                    f2 += this.f23694l / 2.0f;
                }
                this.f23696n.add(Float.valueOf(f2));
                f = this.f23697o.get(i).floatValue() / 2.0f;
            } else {
                this.f23696n.add(Float.valueOf(f2));
                f = this.f23694l;
            }
            f2 += m19712a + f;
        }
    }

    /* renamed from: a */
    public int m35352a(int i) {
        int m35337p;
        if (i <= 0) {
            return 0;
        }
        int[] iArr = this.f23701s;
        if (iArr != null) {
            if (i >= iArr.length) {
                m35337p = iArr.length;
                return m35337p - 1;
            }
            return i;
        }
        if (i >= m35337p()) {
            m35337p = m35337p();
            return m35337p - 1;
        }
        return i;
    }

    /* renamed from: b */
    public void m35351b() {
        PdfDocument pdfDocument;
        PdfiumCore pdfiumCore = this.f23684b;
        if (pdfiumCore != null && (pdfDocument = this.f23683a) != null) {
            pdfiumCore.m19738a(pdfDocument);
        }
        this.f23683a = null;
        this.f23701s = null;
    }

    /* renamed from: c */
    public int m35350c(int i) {
        int i2;
        int[] iArr = this.f23701s;
        if (iArr == null) {
            i2 = i;
        } else if (i < 0 || i >= iArr.length) {
            return -1;
        } else {
            i2 = iArr[i];
        }
        if (i2 < 0 || i >= m35337p()) {
            return -1;
        }
        return i2;
    }

    /* renamed from: d */
    public List<PdfDocument.Bookmark> m35349d() {
        PdfDocument pdfDocument = this.f23683a;
        if (pdfDocument == null) {
            return new ArrayList();
        }
        return this.f23684b.m19728k(pdfDocument);
    }

    /* renamed from: e */
    public float m35348e(float f) {
        return this.f23698p * f;
    }

    /* renamed from: f */
    public float m35347f() {
        return m35346g().m19712a();
    }

    /* renamed from: g */
    public SizeF m35346g() {
        return this.f23693k ? this.f23692j : this.f23691i;
    }

    /* renamed from: h */
    public float m35345h() {
        return m35346g().m19711b();
    }

    /* renamed from: i */
    public PdfDocument.Meta m35344i() {
        PdfDocument pdfDocument = this.f23683a;
        if (pdfDocument == null) {
            return null;
        }
        return this.f23684b.m19737b(pdfDocument);
    }

    /* renamed from: j */
    public int m35343j(float f, float f2) {
        int i = 0;
        for (int i2 = 0; i2 < m35337p() && (this.f23696n.get(i2).floatValue() * f2) - (m35338o(i2, f2) / 2.0f) < f; i2++) {
            i++;
        }
        int i3 = i - 1;
        if (i3 >= 0) {
            return i3;
        }
        return 0;
    }

    /* renamed from: k */
    public float m35342k(int i, float f) {
        SizeF m35339n = m35339n(i);
        return (this.f23693k ? m35339n.m19712a() : m35339n.m19711b()) * f;
    }

    /* renamed from: l */
    public List<PdfDocument.Link> m35341l(int i) {
        return this.f23684b.m19732g(this.f23683a, m35350c(i));
    }

    /* renamed from: m */
    public float m35340m(int i, float f) {
        if (m35350c(i) < 0) {
            return 0.0f;
        }
        return this.f23696n.get(i).floatValue() * f;
    }

    /* renamed from: n */
    public SizeF m35339n(int i) {
        if (m35350c(i) < 0) {
            return new SizeF(0.0f, 0.0f);
        }
        return this.f23687e.get(i);
    }

    /* renamed from: o */
    public float m35338o(int i, float f) {
        return (this.f23695m ? this.f23697o.get(i).floatValue() : this.f23694l) * f;
    }

    /* renamed from: p */
    public int m35337p() {
        return this.f23685c;
    }

    /* renamed from: q */
    public SizeF m35336q(int i, float f) {
        SizeF m35339n = m35339n(i);
        return new SizeF(m35339n.m19711b() * f, m35339n.m19712a() * f);
    }

    /* renamed from: r */
    public float m35335r(int i, float f) {
        float m35347f;
        float m19712a;
        SizeF m35339n = m35339n(i);
        if (this.f23693k) {
            m35347f = m35345h();
            m19712a = m35339n.m19711b();
        } else {
            m35347f = m35347f();
            m19712a = m35339n.m19712a();
        }
        return (f * (m35347f - m19712a)) / 2.0f;
    }

    /* renamed from: s */
    public RectF m35334s(int i, int i2, int i3, int i4, int i5, RectF rectF) {
        return this.f23684b.m19726m(this.f23683a, m35350c(i), i2, i3, i4, i5, 0, rectF);
    }

    /* renamed from: t */
    public boolean m35333t(int i) throws PageRenderingException {
        int m35350c = m35350c(i);
        if (m35350c < 0) {
            return false;
        }
        synchronized (f23682t) {
            if (this.f23688f.indexOfKey(m35350c) < 0) {
                try {
                    this.f23684b.m19721r(this.f23683a, m35350c);
                    this.f23688f.put(m35350c, true);
                    return true;
                } catch (Exception e) {
                    this.f23688f.put(m35350c, false);
                    throw new PageRenderingException(i, e);
                }
            }
            return false;
        }
    }

    /* renamed from: u */
    public boolean m35332u(int i) {
        return !this.f23688f.get(m35350c(i), false);
    }

    /* renamed from: y */
    public void m35328y(Size size) {
        this.f23687e.clear();
        PageSizeCalculator pageSizeCalculator = new PageSizeCalculator(this.f23699q, this.f23689g, this.f23690h, size, this.f23700r);
        this.f23692j = pageSizeCalculator.m35295g();
        this.f23691i = pageSizeCalculator.m35296f();
        for (Size size2 : this.f23686d) {
            this.f23687e.add(pageSizeCalculator.m35301a(size2));
        }
        if (this.f23695m) {
            m35331v(size);
        }
        m35330w();
        m35329x();
    }

    /* renamed from: z */
    public void m35327z(Bitmap bitmap, int i, Rect rect, boolean z) {
        this.f23684b.m19715x(this.f23683a, bitmap, m35350c(i), rect.left, rect.top, rect.width(), rect.height(), z);
    }
}
