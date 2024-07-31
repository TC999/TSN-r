package com.github.barteksc.pdfviewer.util;

import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;

/* renamed from: com.github.barteksc.pdfviewer.util.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PageSizeCalculator {

    /* renamed from: a */
    private FitPolicy f23745a;

    /* renamed from: b */
    private final Size f23746b;

    /* renamed from: c */
    private final Size f23747c;

    /* renamed from: d */
    private final Size f23748d;

    /* renamed from: e */
    private SizeF f23749e;

    /* renamed from: f */
    private SizeF f23750f;

    /* renamed from: g */
    private float f23751g;

    /* renamed from: h */
    private float f23752h;

    /* renamed from: i */
    private boolean f23753i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageSizeCalculator.java */
    /* renamed from: com.github.barteksc.pdfviewer.util.e$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static /* synthetic */ class C6667a {

        /* renamed from: a */
        static final /* synthetic */ int[] f23754a;

        static {
            int[] iArr = new int[FitPolicy.values().length];
            f23754a = iArr;
            try {
                iArr[FitPolicy.HEIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23754a[FitPolicy.BOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PageSizeCalculator(FitPolicy fitPolicy, Size size, Size size2, Size size3, boolean z) {
        this.f23745a = fitPolicy;
        this.f23746b = size;
        this.f23747c = size2;
        this.f23748d = size3;
        this.f23753i = z;
        m35300b();
    }

    /* renamed from: b */
    private void m35300b() {
        int i = C6667a.f23754a[this.f23745a.ordinal()];
        if (i == 1) {
            SizeF m35298d = m35298d(this.f23747c, this.f23748d.m19714a());
            this.f23750f = m35298d;
            this.f23752h = m35298d.m19712a() / this.f23747c.m19714a();
            Size size = this.f23746b;
            this.f23749e = m35298d(size, size.m19714a() * this.f23752h);
        } else if (i != 2) {
            SizeF m35297e = m35297e(this.f23746b, this.f23748d.m19713b());
            this.f23749e = m35297e;
            this.f23751g = m35297e.m19711b() / this.f23746b.m19713b();
            Size size2 = this.f23747c;
            this.f23750f = m35297e(size2, size2.m19713b() * this.f23751g);
        } else {
            float m19711b = m35299c(this.f23746b, this.f23748d.m19713b(), this.f23748d.m19714a()).m19711b() / this.f23746b.m19713b();
            Size size3 = this.f23747c;
            SizeF m35299c = m35299c(size3, size3.m19713b() * m19711b, this.f23748d.m19714a());
            this.f23750f = m35299c;
            this.f23752h = m35299c.m19712a() / this.f23747c.m19714a();
            SizeF m35299c2 = m35299c(this.f23746b, this.f23748d.m19713b(), this.f23746b.m19714a() * this.f23752h);
            this.f23749e = m35299c2;
            this.f23751g = m35299c2.m19711b() / this.f23746b.m19713b();
        }
    }

    /* renamed from: c */
    private SizeF m35299c(Size size, float f, float f2) {
        float m19713b = size.m19713b() / size.m19714a();
        float floor = (float) Math.floor(f / m19713b);
        if (floor > f2) {
            f = (float) Math.floor(m19713b * f2);
        } else {
            f2 = floor;
        }
        return new SizeF(f, f2);
    }

    /* renamed from: d */
    private SizeF m35298d(Size size, float f) {
        return new SizeF((float) Math.floor(f / (size.m19714a() / size.m19713b())), f);
    }

    /* renamed from: e */
    private SizeF m35297e(Size size, float f) {
        return new SizeF(f, (float) Math.floor(f / (size.m19713b() / size.m19714a())));
    }

    /* renamed from: a */
    public SizeF m35301a(Size size) {
        if (size.m19713b() > 0 && size.m19714a() > 0) {
            float m19713b = this.f23753i ? this.f23748d.m19713b() : size.m19713b() * this.f23751g;
            float m19714a = this.f23753i ? this.f23748d.m19714a() : size.m19714a() * this.f23752h;
            int i = C6667a.f23754a[this.f23745a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return m35297e(size, m19713b);
                }
                return m35299c(size, m19713b, m19714a);
            }
            return m35298d(size, m19714a);
        }
        return new SizeF(0.0f, 0.0f);
    }

    /* renamed from: f */
    public SizeF m35296f() {
        return this.f23750f;
    }

    /* renamed from: g */
    public SizeF m35295g() {
        return this.f23749e;
    }
}
